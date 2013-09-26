<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登陆</title>
		<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.css" />
		<link rel="stylesheet" href="static/css/book.css" />
		<style>
		.v-center-bg {
			position: relative;
			top: 180px;
			width: 100%;
			height: 300px;
			border-style: solid;
			border-width: 1px 0;
			border-color: rgb( 209, 209, 209 );
			background: rgb( 232, 232, 232);
		}
		
		form {
			width: 300px;
			margin-top: 25px;
			margin-left: 50%;
		}
		
		img {
			position: absolute;
			left: 150px;
			top: -60px;
		}
		</style>
	</head>
	<body>
		<div class="v-center-bg">
			<form role="form" action="/login" method="POST">
				<img src="static/img/book-logo.png" />
				<div class="form-group">
					<label>邮箱</label>
					<input type="email" class="form-control" placeholder="你的邮箱" data-check="email" data-with="val: email" name="email"/>
					<p class="help-block"></p>
				</div>
				
				<div class="form-group">
					<label>密码</label>
					<input type="password" class="form-control" placeholder="密码" name="passwd"/>
					<p class="help-block" data-with="text: error"></p>
				</div>
				
				<button type="submit" class="btn btn-default">确定</button>
				<a type="button" class="btn btn-default">
					注册&nbsp;<span class="glyphicon glyphicon-arrow-right" style="color: blue;"></span>
				</a>
			</form>
		</div>
		
		<script>
			result = <%=new String((request.getParameter("jsonResult")==null ? "":request.getParameter("jsonResult")).getBytes("iso-8859-1"), "utf-8") %>;
		</script>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="static/bootstrap3/js/bootstrap.js" ></script>
		<script src="static/js/check-form.js"></script>
		<script src="static/js/with.js"></script>
		<script>
		$(function(){
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
			
			dataWith( result );
		})
		</script>
	</body>
</html>