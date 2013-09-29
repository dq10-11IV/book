<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>分享</title>
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
		<li><a href="#" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
	</ul>
	<ul class="nav navbar-nav pull-right" data-with="bool: user">
		<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
		<li><a href="#" data-with="text: user.userName"></a></li>
	</ul>
</nav>
<div class="container">
	<div class="row">
		<div class="input-group	 col-lg-4 col-lg-offset-4">
			<input class="form-control" placeholder="书籍关键字">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" title="搜索"><span class="glyphicon glyphicon-search"></span></button>
			</span>
		</div>
	</div>
	<div id="books">
	<ul data-with="list: books" class="list-group">
		<example>
			<li class="list-group-item">
			<h3 data-with="text: title"></h3>
			<img data-with="src: image">
			<span class="glyphicon glyphicon-share"></span>
			<small data-with="text: author"></small>
			<p data-with="text: publisher"></p>
			</li>
		</example>
	</ul>
	</div>
</div>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
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
	
	$( '#add-book' ).find( '.modal-footer button' ).click( function () {
		var isbn = $( '#add-book' ).find( '.modal-body input' ).val();
		var data = new douban().askBookByIsbn( isbn, function( data ) {
			$( '#add-book' ).fill( data );
		} );
	} );
	
	new douban().searchBooksByKeys( 'Java ee', function( data ) {
		$( '#books' ).fill( data );
	} );
});
</script>
</body>
</html>