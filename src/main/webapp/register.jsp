<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>æ³¨å</title>
		<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.css" />
		<link rel="stylesheet" href="static/css/book.css" />
		<style>
		form {
			width: 300px;
			margin-left: 50%;
		}
		
		img {
			position: absolute;
			right: 50%;
			top: -50px;
		}
		</style>
	</head>
	<body>
		<div class="v-center-bg">
			<form role="form" action="/login" method="POST">
				<img src="static/img/register-logo.png" />
				<div class="form-group">
					<label>邮箱</label>
					<input type="email" class="form-control" placeholder="你的邮箱" data-check="email" data-with="val: email" name="email"/>
					<p class="help-block" style="color: #b94a48;" data-with="text: error"></p>
				</div>
				
				<div class="form-group">
					<label>密码</label>
					<input type="password" class="form-control" placeholder="密码" name="passwd" data-check="passwd"/>
					<p class="help-block"></p>
				</div>
				
				<div class="form-group">
					<label>昵称</label>
					<input type="text" class="form-control" placeholder="昵称" name="passwd" data-check="name"/>
					<p class="help-block"></p>
				</div>
				
				<button type="submit" class="btn btn-default">注册</button>
				<a type="button" class="btn btn-default" href="/login">
					登陆&nbsp;<span class="glyphicon glyphicon-arrow-right" style="color: blue;"></span>
				</a>
			</form>
		</div>
		
		<script>
			result = <%=new String(request.getParameter("jsonResult").getBytes("iso-8859-1"), "utf-8") %>;
		</script>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="static/bootstrap3/js/bootstrap.js" ></script>
		<script src="static/js/check-form.js"></script>
		<script src="static/js/with.js"></script>
		<script>
		$(function(){
			fillDocument( result );
			
			$('form').checkform({
				error: function (el, msg) {
					el.parent('div').addClass('has-error');
					el.next().text( msg );
				},
				
				success: function (el) {
					el.parent('div').removeClass('has-error');
					el.next().text('');
				}
			});
		})
		</script>
	</body>
</html>