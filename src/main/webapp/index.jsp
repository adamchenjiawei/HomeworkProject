<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Responsive Nav &middot; Advanced Left Navigation Demo</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/responsive-nav.css">
<link rel="stylesheet" href="./css/styles.css">
<script src="./javascript/responsive-nav.js"></script>
<script src="./javascript/jquery.min.js"></script>
<script>
	$(function() {
		/*   	var navigation = responsiveNav("foo", {customToggle: ".nav-toggle"}); */
		var liobj = $("#action li");
		liobj
				.each(function() {
					$(this)
							.click(
									function() {
										liobj.removeClass("active")
										$(this).addClass("active");
										//return false;    //加这句来阻止跳转 可用来调试效果
										var li_text = $(".active a").text();
										switch (li_text) {
										case "首页":
											$(".main")
													.html(
															"<iframe src='./${user.role}/Home.jsp' width='100%' height='100%'></iframe>");
											break;
										case "作业":
											$(".main")
													.html(
															"<iframe src='./${user.role}/homeworks.jsp' width='100%' height='100%'></iframe>");
											break;
										case "做作业":
											$(".main")
													.html(
															"<iframe src='./${user.role}/editor_homework.jsp' width='100%' height='100%'></iframe>");
											break;
										case "布置作业":
											$(".main")
													.html(
															"<iframe src='./${user.role}/setHomework.jsp' width='100%' height='100%'></iframe>");
											break;
											
										case "管理信息":
											$(".main")
													.html(
															"<iframe src='./${user.role}/Home.jsp' width='100%' height='100%'></iframe>");
											break;
										}
									});
				});
		if ("${user.role}" == "Student") {
			$("#Student").css("display", "block");
		} else if ("${user.role}" == "Teacher") {
			$("#Teacher").css("display", "block");
		} else if ("${user.role}" == "Admin") {
			$("#Admin").css("display", "block");
		}

	});
</script>
</head>
<body>

	<div role="navigation" id="foo" class="nav-collapse">
		<div id="top" style="text-Align: center">
			<div class="user_infos">
				<span class="portrait">
					<div>
						<img src="image/touxiang.jpeg" width="180" height="180"
							class="portrait" style="border-radius: 90px">
					</div>
					<div style="color: #FFF; font-size: 24px">${user.name}</div>
				</span>
			</div>
		</div>
		<ul id="action">
			<span id="Student" style="display: none">
				<li class="active"><a href="#">首页</a></li>
				<li value="作业"><a href="#">作业</a></li>
				<li><a href="#">教师信息</a></li>
				<li><a href="#">Blog</a></li>
			</span>
			<span id="Teacher" style="display: none">
				<li class="active"><a href="#">首页</a></li>
				<li value="作业"><a href="#">作业</a></li>
				<li><a href="#">布置作业</a></li>
			</span>

			<span id="Admin" style="display: none">
				<li class="active"><a href="#">管理信息</a></li>
			</span>
		</ul>
	</div>

	<div role="main" class="main" style="padding: 0 0 0 0;">
		<iframe src="./${user.role}/Home.jsp" width="100%" height="100%"></iframe>
	</div>
</body>
</html>