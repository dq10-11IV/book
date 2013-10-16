function chat(e) {
	var str = 'talk to ' + $(e).attr("title");
	alert(str);
};
function removeTag(e) {
	var str = 'remove tag '+$(e).siblings('a').attr('href').substr(4).trim();
	alert(str);
};
$(function(){
	$('.row').fill( result.data );
	$('.fixed-tags').fill( result.data );
	/* popover */
	function thumbnailPopover( tn ) {
		$( tn ).popover({
			trigger: 'click',
			placement: 'auto right',
			title: '详细',
			html: true,
			container: 'body',
			content: function () {
				return '<div class="book-summary" style="display: block;">' + $( this ).siblings( '.book-summary' ).html() + '</div><button onclick="chat(this)" style="margin-top: 10px;" type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-comment"></span>&nbsp;&nbsp;对话</button>';
			}
		});
	}
	
	$( '.thumbnail>img' ).each( function () {
		thumbnailPopover(this);
	});
	
	/* tab change */
	$( '#tags [data-toggle="tab"]' ).on( 'show.bs.tab', function ( e ) {
		//$( e.relatedTarget ).find( 'span' ).remove().appendTo( $( e.target ) );

		var id = $( e.target ).attr( 'href' ).substr( 1 );
		var pane = $( '#'+id );
		if ( pane.length == 0 ) {
			var node = '<div class="tab-pane" id="'+ id +'"><ul data-with="list: books" class="list-group"><example>' + $( '#tab_me example' ).html().trim() + '<example></ul></div>';
			$( '.tab-content' ).append( node );
			
			var param = {};
			param.ajax = true;
			param.label = id.substr(3).trim();
			$.post( '/getBooksUnderLabel', param, function( data, status ) {
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
	
	$('#search').click(function(){
		$('#searchInput').slideToggle("fast");
	});
	$('#searchBooks').click(function(){
		var param = {};
		param.ajax = true;
		param.keys = $('#searchInput>input').val();
		if (prams.keys == '') return;
		
		$.post('/search', param, function ( data, status) {
			alert( JSON.stringify(data) );
		});
	});
	$('#addbook').click(function(){
		$('.fixed-tags').css("left","-200px");
		setTimeout(function(){
			$('.tab-content').hide(1000);
		}, 500);
		
		$('#book>li').remove();
		setTimeout(function(){
			$('.fixed-books').css({
				"top": "130px"
			});
		},1500);
	});
	$('#addbook-hide').click(function(){
		$('.fixed-books').css({
			"top": "-300px"
		});
		setTimeout(function(){
			$('.tab-content').show(1000);
		}, 1000);
		setTimeout(function(){
			$('.fixed-tags').css("left","0px");
		},2000);
	});
	
	var saved = {};
	$( '#searchBooks-douban' ).click( function () {
		$( '#books>ul>li' ).remove();
		var keys = $( this ).siblings( 'input' ).val();
		new douban().searchBooksByKeys( keys, function( data ) {
			saved.books = data.books;
			//fill datas
			$( '#books' ).fill( data );
			
			//add action of share
			$( '#books .glyphicon-share' ).click( function () {
				var index = $( this ).attr( 'id' );
				saved.books[index].ajax = true;
				saved.books[index].author = saved.books[index].author.join(',');
				$.post( '/addbook', saved.books[index]);
			});
			
			//add action of popover about book's summary
			$( '#books>ul>li img' ).each( function () {
				$( this ).popover({
					trigger: 'click',
					title: '详细',
					html: true,
					container: 'body',
					content: function () {
						var node = '<div class="book-summary" style="display: block;">';
						var text = $( this ).siblings( '.book-summary' ).text().split( '\n' );
						for ( var item in text ) {
							node += '<p>' + text[item] + '</p>';
						}
						node += '</div>';
						return node;
					}
				});
			} );
		} );
	} );
	/*$('.nav-pills').find('li:not(:eq(0))').draggable({
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
	} );*/
	
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