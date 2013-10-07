<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html >
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<meta content="zh-cn" http-equiv="Content-language">
		
		<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.css" >
		<link rel="stylesheet" href="static/css/book.css" >
	</head>
	<style>
	body {
		background: #ceab65;
		overflow: hidden;
	}
	
	#title-contain {
		width: 100%; 
		display: block;
		position: fixed;
		top:150px;
		padding: 50px;
		font-family:微软雅黑 仿宋;
		color:#333333;
		letter-spacing:40px;
	}
	
	#title {
		font-size:80px;
		text-align: center;
		line-height: 80px;
		background: #ceab65;
	}
	
	#desc {
		width: 400px;
		margin: 5px auto;
		text-align: right;
		letter-spacing:4px;
		font-family:微软雅黑;
	}
	
	#desc > span {
		float: right;
	}
	
	#ctrl {
		display: block;
		width: 400px;
		margin: 10px auto;
		letter-spacing: 0;
		font-family:微软雅黑;
	}
	
	#ctrl a {
		float: right;
		width: 150px;
		color: #336666;
		border: none;
		margin-left: 15px;
	}
	
	#ctrl .btn:hover {
		background: #336666;
		color: #ffffcc;
		transition: background 0.5s;
	}
	</style>
<body>
<div id="title-contain">
	<div id="title">
		<div><span class="glyphicon glyphicon-book" style="font-size: 14px; line-height: 14px;letter-spacing: 0; position: relative; top: -50px; left: -10px;"></span>图书漂流</div>
	</div>
	<div id="desc">快捷图书分享&nbsp;&nbsp;让知识不再落单
	</div>
	<div id="ctrl">
		<a type="button" href="/login" class="btn btn-default">登陆</a>
		<a type="button" href="/register" class="btn btn-default">注册</a>
	</div>
</div>
</body>
</html>
