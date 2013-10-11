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
		<a class="navbar-brand">Book Drift</a>
	</div>
	<ul class="nav navbar-nav">
		<li><a href="/myBook" title="主页"><span class="glyphicon glyphicon-home"></span></a></li>
		<li><a href="#add-tag" data-toggle="modal" title="添加新的标签"><span class="glyphicon glyphicon-tag"></span></a></li>
		<li class="active"><a href="#" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
	</ul>
	<ul class="nav navbar-nav pull-right" data-with="bool: user">
		<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
		<li><a href="#" data-with="text: user.userName"></a></li>
	</ul>
</nav>
<div class="container">
	<div class="row">
		<div class="col-lg-5 col-lg-offset-4">
			<input class="form-control" placeholder="书籍关键字" style="display: inline-block; width: 80%;">
			<button style="width: 15%;" class="btn btn-default" type="button" title="搜索" id="searchBooks"><span class="glyphicon glyphicon-search"></span></button>
		</div>
	</div>
	<div id="books">
	<ul data-with="list: books" class="list-group">
		<example>
			<li class="list-group-item">
			<h3 data-with="text: title"></h3>
			<img data-with="src: image"><p class="book-summary" data-with="text: summary" style="display: none;"></p>
			<span class="glyphicon glyphicon-share" data-with="id: loop"></span>
			<small data-with="text: author"></small>
			<p data-with="text: publisher"></p>
			</li>
		</example>
	</ul>
	</div>
</div>

<%@include file="patch/result.jsp" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="static/bootstrap3/js/bootstrap.js" ></script>
<script src="static/js/with.js"></script>
<script src="static/js/douban.js"></script>
<script>
$(function(){
	var saved = {};
	$( '#searchBooks' ).click( function () {
		$( '#books>ul>li' ).remove();
		var keys = $( this ).siblings( 'input' ).val();
		new douban().searchBooksByKeys( keys, function( data ) {
			saved.books = data.books;
			//fill datas
			$( '#books' ).fill( data );
			
			//add action of share
			$( '#books .glyphicon-share' ).click( function () {
				var index = $( this ).attr( 'id' );
				alert( JSON.stringify(saved.books[index]) );
			});
			
			//add action of popover about book's summary
			$( '#books>ul>li img' ).each( function () {
				$( this ).popover({
					trigger: 'hover',
					title: '详细',
					html: true,
					content: function () {
						var node = '<div>';
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
	
});
</script>
</body>
</html>