<%@ page import="com.homework.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
    <link href="../css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="../css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="../css/teacher/teacher_home.css">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
	<div id="content">
		<div class="work_title">
			<h2>作业预览</h2>
		</div>
   		<div class="work_tools">
			<li style="margin-Top:7px">开始时间：</li>
			<li>
				<div id="datetimepicker1" class="input-append date">
				    <input id="beginDate" type="text" style="height:30px"></input>
				    <span class="add-on" style="height:30px">
				        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
				    </span>
				</div>
			</li>
			<li style="margin-Top:7px">结束时间：</li>
			<li>
				<div id="datetimepicker2" class="input-append date">
				    <input id="endDate" type="text" style="height:30px"></input>
				    <span class="add-on" style="height:30px">
				        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
				    </span>
				</div>
			</li>
			<li>
				<input type="button" class="btn btn-default btn-sm" id="getWork" value="确定"/>
			</li>
		</div>
		<div id="homeWorkList">
			<table class="table table-striped">
			      <thead>
			        <tr>
			          	<th>ID</th>
						<th>作业题目</th>
						<th>作业内容</th>
						<th>截止时间</th>
						<th>提交班级</th>
						<th>创建时间</th>
			        </tr>
			      </thead>
			      <tbody id="content_homework">
			      </tbody>
			</table>
		</div>
	</div>
	<div id="bottom"></div>
	<script type="text/javascript" src="../javascript/jquery.min.js"></script>
    <script type="text/javascript" src="../javascript/bootstrap.min.js"></script>
    <script type="text/javascript" src="../javascript/bootstrap-datetimepicker.min.js"></script>
    <script src="../javascript/jquery.tmpl.min.js"></script>
	<script src="../javascript/jquery.paginate.js"></script>
    <script id="homeWork_teacher" type="text/x-jquery-tmpl">
		<tr>
			<td>{{= id}}</td>
			<td>{{= title}}</td>
			<td>{{= content}}</td>
			<td>{{= submit_at}}</td>
			<td>{{= the_class_id}}</td>
			<td>{{= created_at}}</td>
		</tr>
	</script>
    
    <script type="text/javascript">
    	$(function() {
    		$.ajax({
				contentType : "application/json;charset=utf-8",
				type : "GET",
				url : "/ElectronicHomeworkSubmissionSystem/teacher/GetAloneHomework",
				dataType : "json",
				async : false,
				success : function(res) {
					$("#content_homework").empty();
					for (var j = 0; j < res.length; j++) {
						if (res[j] != null) {
							$("#homeWork_teacher").tmpl(res[j]).appendTo("#content_homework");
						} else {
							return false;
						}
					}
				}
			});
    	});
      	$('#datetimepicker1').datetimepicker({
	        format: 'yyyy-MM-dd HH:mm:ss',
	        language: 'en',
	        pickDate: true,
	        pickTime: true,
	        hourStep: 1,
	        minuteStep: 15,
	        secondStep: 30,
	        inputMask: true
      	});
      	$('#datetimepicker2').datetimepicker({
        	format: 'yyyy-MM-dd HH:mm:ss',
        	language: 'en',
        	pickDate: true,
        	pickTime: true,
        	hourStep: 1,
        	minuteStep: 15,
        	secondStep: 30,
        	inputMask: true
      	});
		$('#getWork').click(function() {
			var beginDate = $("#beginDate").val();
			var endDate = $("#endDate").val();
			if(beginDate == "" || beginDate == null) {
				alert("开始时间不能为空！");
				return;
			}
			if(endDate == "" || endDate == null) {
				alert("结束时间不能为空！");
				return;
			}
			$.ajax({
				contentType : "application/json;charset=utf-8",
				type : "GET",
				url : "/ElectronicHomeworkSubmissionSystem/teacher/GetAloneHomework",
				data : "beginDate=" + beginDate + "&endDate=" + endDate,
				dataType : "json",
				async : false,
				success : function(res) {
					$("#content_homework").empty();
					for (var j = 0; j < res.length; j++) {
						if (res[j] != null) {
							$("#homeWork_teacher").tmpl(res[j]).appendTo("#content_homework");
						} else {
							return false;
						}
					}
				}
			});
		});
    </script>
</body>
</html>