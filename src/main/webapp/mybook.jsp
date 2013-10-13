<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>漂流</title>
	<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.css" />
	<link rel="stylesheet" href="static/css/book.css" />
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand">Book Drift</a>
	</div>
	<ul class="nav navbar-nav">
		<li class="active"><a href="/myBook" title="主页"><span class="glyphicon glyphicon-home"></span></a></li>
		<li><a href="#add-tag" data-toggle="modal" title="添加新的标签"><span class="glyphicon glyphicon-tag"></span></a></li>
		<li><a href="#add-book" data-toggle="modal" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
	</ul>
	<ul class="nav navbar-nav pull-right" data-with="bool: user?(fill: user)(remove)">
		<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
		<li><a href="#" data-with="text: userName"></a></li>
	</ul>
</nav>
<div class="row">
	<div class="col-lg-3">
		<ul class="nav nav-pills nav-stacked nav-tabs" data-with="list: labels" id="tags">
			<li class="active"><a href="#tab_me" data-toggle="tab"><span class="glyphicon glyphicon-hand-right" style="color: black; float: left;"></span>我</a></li>
			<example>
				<li><a href="" data-toggle="tab" data-with="href: '#tab'-id; text: labelName"></a></li>
			</example>
		</ul>
		<button type="button" class="btn btn-lg" style="margin-top: 20px; width: 100%;" id="trash">
			<span class="glyphicon glyphicon-trash"></span>
		</button>
	</div>
	<div class="col-lg-9">
		<div class="tab-content">
			<div class="tab-pane active" id="tab_me">
				
				<div class="row" data-with="list: books">
					<example>
						<div class="col-lg-2">
							<a href="#" class="thumbnail">
								<img data-with="src: imageUrl">
								<ul class="status">
									<li title="可借"><span class="glyphicon glyphicon-ok-sign"></span></li>
									<li title="已借出"><span class="glyphicon glyphicon-minus-sign"></span></li>
									<li title="不可借"><span class="glyphicon glyphicon-remove-sign"></span></li>
								</ul>
								<div class="book-summary">
									<p data-with="text: bookName"></p>
									<p data-with="text: authorName"></p>
									<p data-with="text: bookPress"></p>
									<pre data-with="text: summary"></pre>
								</div>
							</a>
						</div>
					</example>
				</div>
				
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="add-tag" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				添加新的标签
			</div>
			<div class="modal-body">
				<label>标签</label><p></p>
				<input type="text" class="form-control">
				<p data-with="text: msg"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="submitTag">确定</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="add-book" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				分享新的书籍
			</div>
			<div class="modal-body">
				<label>ISBN</label>
				<p></p>
				<div class="input-group">
					<input class="form-control" type="text">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" id="searchIsbn">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			
				<table class="table table-hover" style="display: none;">
				<tbody>
					<tr>
					<td><b>书名</b></td>
					<td data-with="text: title"></td>
					</tr>
					<tr>
					<td><b>作者</b></td>
					<td data-with="text: author"></td>
					</tr>
					<tr>
					<td><b>出版社</b></td>
					<td data-with="text: publisher"></td>
					</tr>
				</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" id="submitBook">完成</button>
				<a type="button" class="btn btn-info" href="/addbook">高级>></a>
			</div>
		</div>
	</div>
</div>

<%@ include file="patch/result.jsp" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="static/bootstrap3/js/bootstrap.js" ></script>
<script src="static/js/with.js"></script>
<script src="static/js/douban.js"></script>
<script>
$(function(){
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
});
</script>
</body>
</html>