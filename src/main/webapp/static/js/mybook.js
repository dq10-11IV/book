$(function(){
	
	/* popover */
	function thumbnailPopover( tn ) {
		$( tn ).popover({
			trigger: 'click',
			placement: 'auto right',
			title: '详细',
			html: true,
			container: 'body',
			content: function () {
				return '<div class="book-summary" style="display: block;">' + $( this ).siblings( '.book-summary' ).html() + '</div>';
			}
		});
	}
	
	$( '.thumbnail>img' ).each( function () {
		thumbnailPopover(this);
	});
	
	/* tab change */
	$( '#tags [data-toggle="tab"]' ).on( 'show.bs.tab', function ( e ) {
		$( e.relatedTarget ).find( 'span' ).remove().appendTo( $( e.target ) );

		var id = $( e.target ).attr( 'href' ).substr( 1 );
		var pane = $( '#'+id );
		if ( pane.length == 0 ) {
			var node = '<div class="tab-pane" id="'+ id +'"><div class="row" data-with="list: books">' +
						'<example>' + $( '#tab_me' ).find( 'example' ).html().trim() + '</example></div></div>';
			$( '.tab-content' ).append( node );

			$.post( '/getBooksUnderLabel', {ajax: true,	label: $( this ).text()	}, function( data, status ) {
				$( '#'+id ).fill( data.data );
				$( '#'+id ).find( '.thumbnail>img' ).each( function () {
					thumbnailPopover( this );
				});
			});
		}
	} );
	
	$('.status').find('li').click(function(){
		var parent = $(this).parent('ul');
		$(this).insertBefore( parent.children().first() );
	});
	
	$('.nav-pills').find('li:not(:eq(0))').draggable({
		revert: 'invalid'
	});
	
	$('#trash').droppable({
		drop: function ( event, ui ) {
			ui.draggable.remove();
		},
		hoverClass: 'btn-danger'
	});
	
	var saved = {};
	$( '#searchIsbn' ).click( function () {
		var isbn = $( '#add-book' ).find( '.modal-body input' ).val();
		var data = new douban().askBookByIsbn( isbn, function( data ) {
			$( '#add-book' ).fill( data );
			$( '#add-book' ).find( 'table' ).show();
			saved.data = data;
		} );
	} );
	
	$( '#submitBook' ).click( function () {
		if ( typeof saved.data !== 'undefined' ) {
			saved.data.ajax = true;
			saved.data.author = saved.data.author.join('');
			$.post( '/addbook', saved.data);
		}
		$( '#add-book' ).find( 'table' ).hide();
	} );
	
	$( '#submitTag' ).click( function () {
		var param = {};
		param['labelName'] = $( '#add-tag input' ).val();
		
		$.post( '/addlabel', param, function ( data, status ) {
			$( '#add-tag' ).fill( data );
			
			if ( data.code == 200 ) {
				setTimeout( function() {
					$( '#add-tag' ).modal( 'hide' );
				}, 1500 )
			}
		})
		
	})
	
	/* message */
	$( document ).keypress( function ( e ) {
		if ( e.keyCode == 13 ) { //enter
			if ( $( '#message' ).css( 'display' ) == 'none' ) {
				$( '#message' ).show().find( 'input' ).val('').focus();
			} else {
				var msg = $('#message input').val();
				if ( msg == '' ) {
					$('#message input').focus();
					return;
				}
				var node = '<p class="me"><b>me:&nbsp;&nbsp;</b><span>'+msg+'</span><span style="float: right;">'+new Date().toLocaleTimeString()+'</span></p>';
				$( '#message .msg-pane' ).append( node );
				$('#message input').val('');
			}
		}
		
		if ( e.keyCode == 27 ) { //esc
			$( '#message' ).hide();
		}
	} );
	$( '#msg-close' ).click(function(){
		$( '#message' ).hide();
	});
	$( '#msg-send' ).click(function(){
		var msg = $('#message input').val();
		if ( msg == '' ) {
			$('#message input').focus();
			return;
		}
		var node = '<p class="me"><b>me:&nbsp;&nbsp;</b><span>'+msg+'</span><span style="float: right;">'+new Date().toLocaleTimeString()+'</span></p>';
		$( '#message .msg-pane' ).append( node );
		$('#message input').val('');
	});
});