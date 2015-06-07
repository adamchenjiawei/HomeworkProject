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
    <link href="../css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="../css/bootstrap-datetimepicker.min.css">
</head>
<body>
<div id="title">
	<div id="top_tools">
		<nav class="navbar navbar-default" role="navigation">
		   <div class="navbar-header">
		      <a class="navbar-brand" href="#">布置作业</a>
		   </div>
		</nav>
	</div>
</div>
<div id="content" style="width: 700px">
	<div class="input-group" style="margin-bottom: 10px;">
      	<div class="input-group-btn">
         	<button type="button" class="btn btn-default" tabindex="-1">作业名称
         	</button>
      	</div><!-- /btn-group -->
      	<input id="titleVal" type="text" class="form-control">
  	</div>
	<div class="input-group" style="margin-bottom: 10px;">
       	<div class="input-group-btn" style="vertical-align: -webkit-baseline-middle">
          	<button type="button" class="btn btn-default" tabindex="-1">作业内容
          	</button>
       	</div><!-- /btn-group -->
       	<textarea id="contentVal" class="form-control" rows="3" style="height: 190px"></textarea>
   	</div>
   	<div class="input-group" style="margin-bottom: 10px;">
		<div class="input-group-btn">
   			<button type="button" class="btn btn-default 
      			dropdown-toggle" data-toggle="dropdown">
      			作业类型
      		<span class="caret"></span>
   			</button>
   			<ul id="homeWorkTypeMenu" class="dropdown-menu">
   				<li><a href="#">文件</a></li>
   				<li><a href="#">文本</a></li>
		   	</ul>
		</div><!-- /btn-group -->
		<input id="homeWorkTypeVal" type="text" class="form-control">
	</div>
	
	<div class="input-group" style="margin-bottom: 10px;">
		<div class="input-group-btn">
   			<button id="homeWorkURL" type="button" class="btn btn-default 
      			dropdown-toggle" data-toggle="dropdown">
      			存放路径
      		<span class="caret"></span>
   			</button>
   			<ul id="homeWorkURLMenu" class="dropdown-menu">
		   	</ul>
		</div><!-- /btn-group -->
		<input id="homeWorkURLVal" type="text" class="form-control">
	</div>
	<div class="input-group" style="margin-bottom: 10px;">
		<div class="input-group-btn">
   			<button id="className" type="button" class="btn btn-default 
      			dropdown-toggle" data-toggle="dropdown">
      			班级名称
      		<span class="caret"></span>
   			</button>
   			<ul id="classNameMenu" class="dropdown-menu">
		   	</ul>
		</div><!-- /btn-group -->
		<input id="classNameVal" type="text" class="form-control">
	</div>
	<div class="input-group" style="margin-bottom: 10px;">
		<div class="input-group-btn">
         	<button type="button" class="btn btn-default" tabindex="-1">提交时间
         	</button>
      	</div><!-- /btn-group -->
		<div id="datetimepicker1" class="input-append date" style="margin-top: 5px; width: 200px">
		    <input id="submitDate" class="form-control" type="text" style="height:30px; border-radius: 0"></input>
		    <span class="add-on" style="height:30px">
		        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
		    </span>
		</div>
  	</div>
	<input type="button" class="btn btn-default btn-sm" id="setHomeWork" style="width: 700px; margin-bottom: 10px;" value="确定"/>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../javascript/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../javascript/bootstrap.min.js"></script>
<script src="../javascript/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="../javascript/bootstrap-datetimepicker.min.js"></script>
<script id="classNameTmpl" type="text/x-jquery-tmpl">
	<li><a href="#">{{= grade}}-{{= the_class}}</a></li>
</script>
<script id="urlTmpl" type="text/x-jquery-tmpl">
	<li><a href="#">{{= path}}</a></li>
</script>
<script>
	$(function() {
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
		// 给文本类型下拉绑定事件
		$("#homeWorkTypeMenu > li").click(function() {
			var text = this.firstElementChild.text;
			$("#homeWorkTypeVal").val(text);
		});
		
		// 获取班级信息
		$("#className").click(function() {
			if($("#classNameMenu li").length == 0) {
				$.ajax({
					contentType : "application/json;charset=utf-8",
					type : "GET",
					url : "/ElectronicHomeworkSubmissionSystem/teacher/GetClassName",
					dataType : "json",
					async : false,
					success : function(res) {
						$("#classNameMenu").empty();
						for (var j = 0; j < res.length; j++) {
							if (res[j] != null) {
								$("#classNameTmpl").tmpl(res[j]).appendTo("#classNameMenu");
							} else {
								return false;
							}
						}
						// 给每个li一个点击事件
						$("#classNameMenu > li").click(function() {
							var text = this.firstElementChild.text;
							$("#classNameVal").val(text);
						});
					}
				})
			}
		});
		// 获取url地址
		$("#homeWorkURL").click(function() {
			if($("#homeWorkURLMenu li").length == 0) {
				$.ajax({
					contentType : "application/json;charset=utf-8",
					type : "GET",
					url : "/ElectronicHomeworkSubmissionSystem/teacher/GetURL",
					dataType : "json",
					async : false,
					success : function(res) {
						$("#homeWorkURLMenu").empty();
						for (var j = 0; j < res.length; j++) {
							if (res[j] != null) {
								$("#urlTmpl").tmpl(res[j]).appendTo("#homeWorkURLMenu");
							} else {
								return false;
							}
						}
						// 给每个li一个点击事件
						$("#homeWorkURLMenu > li").click(function() {
							var text = this.firstElementChild.text;
							$("#homeWorkURLVal").val(text);
						});
					}
				})
			}
		});
		// 设置作业
		$("#setHomeWork").click(function() {
			var title = $("#titleVal").val();
			var content = $("#contentVal").val();
			var homeWorkTypeVal = $("#homeWorkTypeVal").val();
			var homeWorkURLVal = $("#homeWorkURLVal").val();
			var classNameVal = $("#classNameVal").val();
			var submitDate = $("#submitDate").val();
			$.ajax({
				contentType : "application/json;charset=utf-8",
				type : "GET",
				url : "/ElectronicHomeworkSubmissionSystem/teacher/SetHomeWork",
				data: "title="+title+"&content="+content+"&homeWorkTypeVal="+homeWorkTypeVal+"&homeWorkURLVal="+homeWorkURLVal+"&classNameVal="+classNameVal+"&submitDate="+submitDate,
				dataType : "String",
				async : false,
				success : function(res) {
					console.log(res);
				}
			})
		});
	});
</script>
</body>
</html>