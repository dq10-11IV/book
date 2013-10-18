function chat(e) {
	var tip = '给 '+$(e).data('name')+' 留言';
	$('#message').data('to', $(e).attr('id')).attr('title', tip).show().find('input').attr('placeholder', tip).focus();
};
function removeTag(e) {
	var param = {};
	param.ajax = true;
	param.labelId = $(e).siblings('a').attr('href').substr(4).trim();
	$.post( '/removelabel', param, function ( data, status ) {
		/* todo */
	})
};
$(function(){
	$('#head').fill( result.data );
	$('#tab-me').fill(result.data);
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
				return '<div class="book-summary" style="display: block;">' + $( this ).siblings( '.book-summary' ).html() + '</div>';
			}
		});
	}
	
	$( '#tab_me img' ).each( function () {
		thumbnailPopover(this);
	});
	
	/* tab change */
	$( '#tags [data-toggle="tab"]' ).on( 'show.bs.tab', function ( e ) {
		//$( e.relatedTarget ).find( 'span' ).remove().appendTo( $( e.target ) );

		var id = $( e.target ).attr( 'href' ).substr( 1 );
		var pane = $( '#'+id );
		if ( pane.length == 0 ) {
			var node = '<div class="tab-pane" id="'+ id +'"><ul data-with="list: books" class="list-group"><example>' + $( '#tab-search example' ).html().trim() + '<example></ul></div>';
			$( '.tab-content' ).append( node );
			
			var param = {};
			param.ajax = true;
			param.label = id.substr(3).trim();
			$.post( '/getBooksUnderLabel', param, function( data, status ) {
				$( '#'+id ).fill( data.data );
				$( '#'+id ).find( 'img' ).each( function () {
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
		if ($('#search-input-pane').height() == 0 ) {
			setTimeout(function(){
				$('#search-input-pane').css({
					"transform": "scale(1,1)",
					"height": "80px"
				}).children('input').focus();
			},500);
			$('.fixed-tags').css({
				"left": "-200px"
			})
			$('#search span').removeClass('glyphicon-search').addClass('glyphicon-remove');
		} else {
			$('#search-input-pane').css({
				"transform": "scale(1,0)",
				"height": "0"
			}).children('input').val('');
			setTimeout(function(){
				$($('.fixed-tags').css({
					"left": "0"
				}).find('li.active>a').attr('href').trim()).addClass('active');
			},500);
			$('#search span').removeClass('glyphicon-remove').addClass('glyphicon-search');
			$('#tab-search').removeClass('active');
		}
	});
	$('#search-input-pane').keypress(function(e){
		if (e.keyCode == 13) {
			var param = {};
			param.ajax = true;
			param.bookName = $('#search-input-pane input').val();
			if (param.keys == '') return;
			
			$('#tab-search>ul>li').remove();
			$.post('/query', param, function ( data, status) {
				$('#tab-search').fill(data.data);
				thumbnailPopover('#tab-search img');
				$('.tab-content .active').removeClass('active');
				$('#tab-search').addClass('active');
			});
		}
	});
	
	/*addbook.jsp*/
	var saved = {};
	
	$('#addbook-trigger').click(function(){
		$('#addbook').show();
		$('#content').css({
			"margin-left": "-100%"
		});
	});
	$('#addbook-hide').click(function(){
		$('#content').css({
			"margin-left": "0"
		});
		$('#addbook').hide();
	});
	
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
				$.post( '/addbook', saved.books[index], function( r, s) {
					x.alert({
						text: r.data["error"]
					});
					if ( r.data["error"] == '分享成功' ) {
						var parent = $(this).parents('li');
						parent.children('div').replaceWith('<ul class="status"><li title="可借"><span class="glyphicon glyphicon-ok-sign"></span></li><li title="已借出"><span class="glyphicon glyphicon-minus-sign"></span></li></ul>');
						parent.appendTo($('#tab-me>ul'));
					}
				});
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
	
	/* add tag */
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
		
	});
	
	/* message */
	$( '#message' ).keypress( function ( e ) {
		if ( e.keyCode == 13 ) { //enter
			$('#msg-send').click();
		}
		
		if ( e.keyCode == 27 ) { //esc
			$('#msg-close').click();
		}
	} );
	
	$( '#msg-close' ).click(function(){
		$( '#message' ).hide().find('input').val('');
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
		
		var param = {};
		param.ajax = true;
		param.msg = msg;
		param.to = $('#message').data('to');
		$.post('/message', param);
	});
});