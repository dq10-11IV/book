<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>漂流</title>
		<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.css" />
		<link rel="stylesheet" href="static/css/book.css" />
		<style>
			.navbar .glyphicon {
				padding-top: 2px;
			}
			
			.icon-badge {
				position: absolute;
				top: 8;
				right: 5;
				color: brown;
				font-size: 10px;
			}
			
			.tab-pane > .row {
				margin-bottom: 20px;
			}
			
			.book {
				position: relative;
				width: 100%;
				height: 200px;
				background: rgb( 232, 232, 232);
			}
			
			.book > p {
				position: absolute;
				top: 120px;
				width: 100%;
				text-align: center;
			}
			
			.book > span {
				position: absolute;
				top: 20px;
				right: 20px;
			}
			
			.status {
				position: absolute;
				display: none;
				width: 100%;
				bottom: 12px;
				padding: 10px 5%;
			}
			
			.status > li {
				display: inline-block;
				width: 30%;
				text-align: center;
			}
			
			.status > li:hover {
				cursor: pointer;
				color: blue;
			}
			</style>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Book Drift</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<li><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
				<li><a href="#">xinting</a></li>
			</ul>
		</nav>
		<div class="row">
			<div class="col-lg-3">
				<ul class="nav nav-pills nav-stacked nav-tabs">
					<li class="active"><a href="#tab1" data-toggle="tab">我</a></li>
					<li><a href="#tab2" data-toggle="tab">实验室</a></li>
					<li><a href="#tab3" data-toggle="tab">寝室</a></li>
				</ul>
				<button type="button" class="btn btn-lg" style="margin-top: 20px; width: 100%;" id="trash">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</div>
			<div class="col-lg-9">
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
						<div class="row">
							<div class="col-lg-3">
								<div href="#" class="thumbnail">
									<div class="book">
										<span class="glyphicon glyphicon-ok-sign"></span>
										<p>Book For Coder</p>
										<ul class="status">
											<li><span class="glyphicon glyphicon-ok"></span></li>
											<li><span class="glyphicon glyphicon-minus"></span></li>
											<li><span class="glyphicon glyphicon-remove"></span></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					<div class="tab-pane" id="tab2">2</div>
					<div class="tab-pane" id="tab3">3</div>
				</div>
			</div>
		</div>
	
	
		<script>
			reuslt = <%=request.getAttribute("result") %>
		</script>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="static/bootstrap3/js/bootstrap.js" ></script>
		<script src="static/js/with.js"></script>
		<script>
		$(function(){
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
		});
		</script>
	</body>
</html>