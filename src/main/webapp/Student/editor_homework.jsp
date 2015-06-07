<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/button.css">
<link rel="stylesheet" href="../css/student/editor_homework.css">
</head>
<body>
<input type="text" id="student_id" value="${user.id}" style="display: none"/>
<input type="text" id="homework_id" value="<%=request.getParameter("id") %>" style="display: none"/>
	<div id="top">
		<span class="button-wrap"> <a href="homeworks.html"
			class="button button-pill button-raised button-primary">作业列表</a>
		</span>
		<div id="homework_infos" style="position: relative;top:-10px;">
		</div>
	</div>
	<div id="homeworks">
		<h1>未提交作业</h1>
	</div>
	<div id="editor">
		<label class="col-sm-2 control-label">选择作业类型</label>
		<form action="get" method="get">
		<input type="text" style="display:none" name="homework_id" value="1">
			<select name="type" class="select_type">
				<option value="1">文本内容</option>
				<option value="2">代码</option>
				<option value="3">文件</option>
			</select> <input type="file" name="message_img" style="display: none;"
				onchange="ye.value=value" /> <input name="ye" value="None file"
				class="upload_file_text" /> <input type="button" id="upload_file"
				value="选择文件" class="button button-3d button-action button-pill"
				onclick=message_img.click() />
			<div style="text-align: center;">
				<textarea class="text_homework" name="content"
					placeholder="请先选择作业类型后再提交作业。1、文本作业 例（英语作文等） 2、代码作业（需要提交代码的作业）3、文件作业（项目打成压缩包、ppt、word、execl等）"></textarea>
			</div>
			<div style="text-align: center;">
				<input type="submit" id="submit_button"
					class="button button-3d button-primary button-rounded">
			</div>
		</form>
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="../javascript/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../javascript/bootstrap.min.js"></script>
	<script src="../javascript/student/editor_homework.js"></script>
	<script src="../javascript/jquery.paginate.js"></script>
	<script id="myTemplate" type="text/x-jquery-tmpl">
		<div class="title">
			{{= title}}<span class="teacher"> {{= teacher_name}}</span>
			</div>
			<div class="the_class">{{= class_name}}：</div>
			<p class="content">{{= content}}</p>
			<div class="time">
				<span class="submit_at">提交作业时间 ：{{= submit_at}}</span> 
				<span class="created_at">布置作业时间 ：{{= created_at}}</span>
			</div>
</script>
</body>
</html>