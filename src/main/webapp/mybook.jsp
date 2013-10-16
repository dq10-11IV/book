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
<div class="row" style="z-index: 10;">
	<div class="container">
		<div style="margin: 10px 20%; padding-top: 50px;color:#777777;">
			<div data-with="text: user.userName" style="height: 37px;line-height: 37px; display: inline-block;width:auto;"></div>
			<ul class="nav nav-pills pull-right">
				<li ><a href="/myBook" title="主页"><span class="glyphicon glyphicon-home"></span></a></li>
				<li><a href="#add-tag" data-toggle="modal" title="添加新的标签"><span class="glyphicon glyphicon-tag"></span></a></li>
				<li id=""><a href="/addbook" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
				<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
				<li id="search"><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
			</ul>
			<hr style="margin-top: 5px;">
			<div id="searchInput">
				<input class="form-control" style="display: inline-block;width:84%">
				<button style="width: 15%;" class="btn btn-default" type="button" title="搜索" id="searchBooks">Go</button>
			</div>
		</div>
	</div>
</div>

<div class="fixed-books">
<div class="container">
		<span class="glyphicon glyphicon-remove" id="addbook-hide"></span>
	<div style="margin: 10px 20%;">
		<input class="form-control" placeholder="搜索" style="display: inline-block; width: 84%;">
		<button style="width: 15%;" class="btn btn-default" type="button" title="搜索" id="searchBooks-douban"><span class="glyphicon glyphicon-search"></span></button>
	</div>

	<div id="books">
	<ul data-with="list: books" class="list-group">
		<example>
			<li class="list-group-item">
			<h3 data-with="text: title"></h3>
			<img data-with="src: image"><p class="book-summary" data-with="text: summary" style="display: none;"></p>
			<div><span class="glyphicon glyphicon-share" data-with="id: loop"></span></div>
			<small data-with="text: author"></small>
			<p data-with="text: publisher"></p>
			</li>
		</example>
	</ul>
	</div>
</div>
</div>

<div class="row">
	<div class="container">
		<div class="tab-content">
		<!-- tab_me -->
			<div class="tab-pane active" id="tab_me">
				<ul data-with="list: books" class="list-group">
					<example>
						<li class="list-group-item">
						<h3 data-with="text: bookName"></h3>
						<img data-with="src: imageUrl"><p class="book-summary" data-with="text: summary" style="display: none;"></p>
						<div data-with="attr: title,owner.id" onclick="chat(this)"><span class="glyphicon glyphicon-comment"></span></div>
						<small data-with="text: authorName"></small>
						<p data-with="text: bookPress"></p>
						</li>
					</example>
				</ul>
			</div>
			
			<example>
			<div class="tab-pane" data-with="id: 'tab'-id">
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
			</example>
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

<div class="fixed-tags">
	<ul class="nav nav-pills nav-stacked nav-tabs" data-with="list: labels" id="tags">
		<li class="active"><a href="#tab_me" data-toggle="tab">我</a></li>
		<example>
			<li><a href="" data-toggle="tab" data-with="href: '#tab'-id; text: labelName"></a><span onclick="removeTag(this)" class="glyphicon glyphicon-remove"></span></li>
		</example>
	</ul>
</div>

<div id="message">
	<div class="msg-pane">
	</div>
	<div class="input-inset">
		<span id="msg-close" class="glyphicon glyphicon-remove" style="position: absolute;top: 0;left:15px;"></span>
		<input class="form-control" type="text">
		<span id="msg-send" class="glyphicon glyphicon-send" style="position: absolute;top: 0;right:15px;"></span>
	</div>
</div>

<%@ include file="patch/result.jsp" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->
<script src="static/bootstrap3/js/bootstrap.js" ></script>
<script src="static/js/with.js"></script>
<script src="static/js/douban.js"></script>
<script src="static/js/mybook.js"></script>
</body>
</html>