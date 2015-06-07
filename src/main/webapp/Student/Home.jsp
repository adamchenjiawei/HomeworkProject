<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.homework.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/student/student_home.css">
</head>
<body>
<div id="student_id" style="display: none;">${user.id}</div>
	<div id="top">
		<div class="user_infos">
			<span class="portrait">
				<div>
					<ul class="user_info">
						<li>邮箱：${user.e_mail}</li>
						<li>电话：${user.phone}</li>
					</ul>
				</div> <a><img></a>
			</span>
			<div class="statistics">
				<h2>剩余未完成作业</h2>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="work_title">
			<h2>今日作业</h2>
		</div>
		<span style="float: right;"><a href="homeworks.jsp">more...</a></span>
		<ul class="work_list" id="work">
		</ul>
	</div>
	<script src="../javascript/jquery.min.js"></script>
	<script src="../javascript/jquery.tmpl.min.js"></script>
	<script id="myTemplate" type="text/x-jquery-tmpl">
      <li>老师：{{= teacher}}<a class="w_list" href="editor_homework.jsp?id={{= id}}">
      <font>{{= title}}</font></a></li>
    </script>
	<script src="../javascript/student/home.js"></script>
</body>
</html>