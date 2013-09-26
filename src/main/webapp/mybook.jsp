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
				<a class="navbar-brand" href="#">Book Drift</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<li data-with="bool: username"><a href="#"><span class="glyphicon glyphicon-envelope"></span><strong class="icon-badge">1</strong></a></li>
				<li><a href="#" data-with="text: username">xinting</a></li>
			</ul>
		</nav>
		<div class="row">
			<div class="col-lg-3">
				<ul class="nav nav-pills nav-stacked nav-tabs" data-with="contain: tags">
					<li class="active"><a href="#tab1" data-toggle="tab">我</a></li>
					<example>
						<li><a href="#tab2" data-toggle="tab" data-with="text">实验室</a></li>
					</example>
				</ul>
				<button type="button" class="btn btn-lg" style="margin-top: 20px; width: 100%;" id="trash">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</div>
			<div class="col-lg-9">
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
						<div class="row" data-with="contain: books">
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
					
					<div class="tab-pane" id="tab2">2</div>
					<div class="tab-pane" id="tab3">3</div>
				</div>
			</div>
		</div>
	
	
		<script>
			reuslt = <%=new String(request.getParameter("jsonResult").getBytes("iso-8859-1"), "utf-8") %>;
		</script>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="static/bootstrap3/js/bootstrap.js" ></script>
		<script src="static/js/with.js"></script>
		<script>
		$(function(){
			fillDocument( result );
			
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