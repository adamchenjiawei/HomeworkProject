<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/paginate_style.css">
<link rel="stylesheet" type="text/css"
	href="../css/student/homeworks.css">
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/paginate_style.css" rel="stylesheet" type="text/css">
<link href="../css/jBootsrapPage.css" rel="stylesheet" type="text/css">
<link href="../css/DomeBootsrapPage.css" rel="stylesheet"
	type="text/css">
<Link href="../css/the_class_bootsrappage.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<div id="student_id" style="display: none;">${user.id}</div>
	<div id="right_content">
	<!-- 	<ul id="content_ul">
		</ul> -->
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<table class="table">
						<thead>
							<tr>
								<th style="text-align: center;">老师</th>
								<th style="text-align: center;">作业内容</th>
								<th style="text-align: center;">上交时间</th>
							</tr>
						</thead>
						<tbody id="content_ul">

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<ul class="paginate"></ul>
	</div>

	<script src="../javascript/jquery.min.js"></script>
	<script src="../javascript/jquery.tmpl.min.js"></script>
	<script src="../javascript/jquery.paginate.js"></script>
	<script id="myTemplate" type="text/x-jquery-tmpl">
<tr style="text-align: center">
  <td>{{= teacher}}</td>
  <td><a href="editor_homework.jsp?id={{= id}}" >{{= title}}</a></td>
  <td>{{= submit_at}}</td>
</tr>
</script>
	<script src="../javascript/student/student_homeworks.js"></script>
</body>
</html>