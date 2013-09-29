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
		<a class="navbar-brand" href="/">Book Drift</a>
	</div>
	<ul class="nav navbar-nav">
		<li><a href="#add-tag" data-toggle="modal" title="添加新的标签"><span class="glyphicon glyphicon-tag"></span></a></li>
		<li><a href="#add-book" data-toggle="modal" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
	</ul>
	<ul class="nav navbar-nav pull-right" data-with="bool: user">
		<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
		<li><a href="#" data-with="text: user.userName"></a></li>
	</ul>
</nav>
<div class="row">
	<div class="col-lg-3">
		<ul class="nav nav-pills nav-stacked nav-tabs" data-with="list: labels">
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
						<div class="col-lg-3">
							<div href="#" class="thumbnail">
								<div class="book">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<p class="book-name" data-with="text: bookName"></p>
									<p class="author-name" data-with="text: authorName"></p>
									<p class="book-press" data-with="text: bookPress"></p>
									<ul class="status">
										<li><span class="glyphicon glyphicon-ok"></span></li>
										<li><span class="glyphicon glyphicon-minus"></span></li>
										<li><span class="glyphicon glyphicon-remove"></span></li>
									</ul>
								</div>
							</div>
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
				<label>标签号</label>
				<input type="text" class="form-control">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">确定</button>
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
				<p>
					<div class="input-group">
						<input class="form-control" type="text">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="searchIsbn">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</p>
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
				<button type="button" class="btn btn-primary" data-dismiss="modal" id="submitBook">确定</button>
				<button type="button" class="btn btn-info">更多</button>
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
	$( '#tags [data-toggle="tab"]' ).on( 'show.bs.tab', function ( e ) {
		$( e.relatedTarget ).find( 'span' ).remove().appendTo( $( e.target ) );
	} );
	
	$('.thumbnail').hover(function(){
		$(this).find('.status').slideToggle();
	});
	
	$('.status').find('li').click(function(){
		var claz = $(this).find('span').attr('class')+'-sign';
		$(this).parent('ul').siblings('span').attr('class', claz);
	});
	
	$('.nav-pills').find('li').draggable({
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
			$.post( '/addbook', saved.data);
		}
		$( '#add-book' ).find( 'table' ).hide();
	} );
});
</script>
</body>
</html>