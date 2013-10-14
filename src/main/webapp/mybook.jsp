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
		<li></li>
		<li><a href="/addbook" title="分享新的书籍"><span class="glyphicon glyphicon-book"></span></a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right" data-with="bool: user?(fill: user)(remove)">
		<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
		<li><a href="#" data-with="text: userName"></a></li>
	</ul>
	<form class="navbar-form navbar-right" role="search" >
		<div class="form-group" style="position: relative;width: 400px; max-width: 500px;">
			<input type="text" class="form-control" >
			<span id="search" class="glyphicon glyphicon-search" style="position:absolute;line-height: 28px; right: 20px;color:#777777;"></span>
		</div>
	</form>
</nav>
<div class="row">
	<div class="col-lg-3">
		<ul class="nav nav-pills nav-stacked nav-tabs" data-with="list: labels" id="tags">
			<li class="active"><a href="#tab_me" data-toggle="tab">我</a></li>
			<example>
				<li><a href="" data-toggle="tab" data-with="href: '#tab'-id; text: labelName"></a><span class="glyphicon glyphicon-remove"></span></li>
			</example>
		</ul>
		<button data-target="#add-tag" type="button" data-toggle="modal" title="添加新的标签" class="btn btn-lg" style="margin-top: 20px; width: 100%;">
			<span class="glyphicon glyphicon-plus"></span>
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

<!-- <div class="modal fade" id="add-book" tabindex="-1" role="dialog" aria-hidden="true">
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
</div> -->

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