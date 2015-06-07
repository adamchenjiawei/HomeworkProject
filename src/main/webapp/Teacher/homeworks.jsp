<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- 高亮 -->
    <link type="text/css" rel="stylesheet" href="../css/shCoreDefault.css"/>

  </head>
  
  <body>
    <div id="top_tools">
		<nav class="navbar navbar-default" role="navigation">
		   <div class="navbar-header">
		      <a class="navbar-brand" href="#">HomeWork</a>
		   </div>
		   <div>
		      	<ul id="nav" class="nav nav-pills" style="margin-top: 5px">
				   	<li class="active" value="0"><a>查看作业</a></li>
				   	<li value="1"><a>查看未交作业学生</a></li>
				</ul>
		   </div>
		   
		</nav>
	</div>
	<div id="content" style="width: 1068px; height:510px">
		<div id="0" style="width: 1068px; height:auto; float: left; display: block">
			<div id="homeWorkList" style="padding: 10px;">
				<div class="input-group" style="width: 400px; margin-bottom: 10px">
  					<span class="input-group-addon" id="basic-addon1">作业名字</span>
			  		<input id="homeWorkName" type="text" class="form-control" placeholder="作业名字" aria-describedby="basic-addon1">
				</div>
				<div class="input-group" style="width: 400px; margin-bottom: 10px">
  					<span class="input-group-addon" id="basic-addon1">班级名称</span>
			  		<input id="className" type="text" class="form-control" placeholder="班级名称" aria-describedby="basic-addon1">
				</div>
				<input type="button" class="btn btn-default btn-sm" id="search" style="width: 1048px" value="确定"/>
				<table class="table table-striped" style="margin-top:20px;">
			      	<thead>
			        	<tr>
				          	<th>ID</th>
							<th>学生姓名</th>
							<th>上交时间</th>
							<th>操作</th>
			        	</tr>
			      	</thead>
			      	<tbody id="student_homework">
			      	</tbody>
				</table>
			</div>
		</div>
		<div id="1" style="width: 1068px; height:500px; float: left;display: none;padding: 10px;">
			<div class="input-group" style="width: 400px; margin-bottom: 10px">
 				<span class="input-group-addon" id="basic-addon1">作业名字</span>
		  		<input id="homeWorkName_NO" type="text" class="form-control" placeholder="作业名字" aria-describedby="basic-addon1">
			</div>
			<div class="input-group" style="width: 400px; margin-bottom: 10px">
 				<span class="input-group-addon" id="basic-addon1">班级名称</span>
		  		<input id="className_NO" type="text" class="form-control" placeholder="班级名称" aria-describedby="basic-addon1">
			</div>
			<input type="button" class="btn btn-default btn-sm" id="search_NO" style="width: 1048px" value="确定"/>
			<table class="table table-striped" style="margin-top:20px;">
		      	<thead>
		        	<tr>
			          	<th>学生ID</th>
			          	<th>学号</th>
						<th>学生姓名</th>
						<th>学生性别</th>
						<th>电话号码</th>
						<th>QQ</th>
						<th>班级ID</th>
						<th>操作</th>
		        	</tr>
		      	</thead>
		      	<tbody id="student_homework_No">
		      	</tbody>
			</table>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   		<div class="modal-dialog">
      		<div class="modal-content" style="width: 700px; height: 550px">
         		<div class="modal-header">
            		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
            		</button>
            		<h4 class="modal-title" id="myModalLabel">
               			详情
            		</h4>
         		</div>
         		<div id="dialog_content_homeWork" class="modal-body" style="max-height: 430px; padding: 5px">
         		</div>
         		<div class="modal-footer">
            		<button type="button" class="btn btn-default" data-dismiss="modal">
						确定
					</button>
         		</div>
      		</div>
   		</div>
	</div>
	<script type="text/javascript" src="../javascript/jquery.min.js"></script>
	<script type="text/javascript" src="../javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="../javascript/shCore.js"></script>
	<script type="text/javascript" src="../javascript/shBrushJava.js"></script>
	<script src="../javascript/jquery.min.js"></script>
	<script src="../javascript/jquery.tmpl.min.js"></script>
	<script src="../javascript/jquery.paginate.js"></script>
	<script id="myTemplate" type="text/x-jquery-tmpl"></script>
	<script id="student" type="text/x-jquery-tmpl">
		<tr>
			<td>{{= id}}</td>
			<td>{{= student_id}}</td>
			<td style="display: none">{{= content}}</td>
			<td>{{= created_at}}</td>
			<td><a id="download" class="btn" style="display: inline-table">下载</a><a id="xiangqing" class="btn" data-toggle="modal" data-target="#myModal" style="display: inline-table">详情</a></td>
		</tr>
	</script>
	<script id="studentNO" type="text/x-jquery-tmpl">
		<tr>
			<td>{{= id}}</td>
			<td>{{= student_number}}</td>
			<td>{{= name}}</td>
			<td>{{= sex}}</td>
			<td>{{= phone}}</td>
			<td>{{= qq}}</td>
			<td>{{= class_id}}</td>
			<td><a class="btn" style="display: inline-table">通知</a></td>
		</tr>
	</script>
	<script type="text/javascript">
		$(function() {
			//SyntaxHighlighter.config.clipboardSwf = '../javascript/clipboard.swf';
			$("#nav li").click(function() {
				$("#nav li[class='active']").removeClass("active");
				var id = this.value;
				var li = $("#nav li:eq("+id+")");
				li.addClass("active");
				var divs = $("#content > div");
				$("#content > div:visible").css("display", "none");
				for(var i = 0; i < divs.length; i++) {
					var div = $("#content > div:eq(" + i + ")");
					if(i == id) {
						div.css("display", "block");
					}
				}
			});
			$("#search").click(function() {
				var homeWorkVal = $("#homeWorkName").val();
				var classNameVal = $("#className").val();
				if(homeWorkVal == null || classNameVal == null) return;
				$.ajax({
					contentType : "application/json;charset=utf-8",
					type : "GET",
					url : "/ElectronicHomeworkSubmissionSystem/teacher/GetStudent",
					data : "homeWorkName=" + homeWorkVal + "&className=" + classNameVal,
					dataType : "json",
					async : false,
					success : function(res) {
						if(res.length == 0) alert("暂时还没有同学交作业！");
						$("#student_homework").empty();
						for (var j = 0; j < res.length; j++) {
							if (res[j] != null) {
								$("#student").tmpl(res[j]).appendTo("#student_homework");
							} else {
								return false;
							}
						}
						$("#student_homework tr").find("td:eq(4) a:eq(1)").click(function() {
							var content = $("#student_homework tr:eq(0)").find("td:eq(2)").text()
							if(content == "") {
								alert("此为文件作业，不提供查看，请选择【下载】");
								return;
							}
							var homeWrokID = this.parentElement.parentElement.firstElementChild.textContent;
							$.ajax({
								contentType : "application/json;charset=utf-8",
								type : "GET",
								url : "/ElectronicHomeworkSubmissionSystem/teacher/GetHomeWorkContent",
								data : "homeWrokID=" + homeWrokID,
								dataType : "json",
								async : false,
								success : function(res) {
									if(res.length == 0) $("#dialog_content_homeWork").empty().html("<h2>没有数据</h2>");
									$("#dialog_content_homeWork").empty();
									$("#dialog_content_homeWork").html("<pre>"+encodeHtml(res[0].content)+"</pre>");
									var class_v = "brush : java; gutter: true;";
									$("#dialog_content_homeWork pre").addClass(class_v);
									SyntaxHighlighter.highlight();
									$("#dialog_content_homeWork > div").css({"height": "420px", "overflow": "scroll"});
								}
							});
						});
						$("#student_homework tr").find("td:eq(4) a:eq(0)").click(function() {
							var content = $("#student_homework tr:eq(0)").find("td:eq(2)").text()
							if(content != "") {
								alert("此为文本作业，不提供下载，请选择【详情】");
								return;
							}
							/*
							$.ajax({
								contentType : "application/json;charset=utf-8",
								type : "GET",
								url : "/ElectronicHomeworkSubmissionSystem/teacher/GetHomeWorkContent",
								data : "homeWrokID=" + homeWrokID,
								dataType : "json",
								async : false,
								success : function(res) {
									if(res.length == 0) $("#dialog_content_homeWork").empty().html("<h2>没有数据</h2>");
									$("#dialog_content_homeWork").empty();
									$("#dialog_content_homeWork").html("<pre>"+encodeHtml(res[0].content)+"</pre>");
									var class_v = "brush : java; gutter: true;";
									$("#dialog_content_homeWork pre").addClass(class_v);
									SyntaxHighlighter.highlight();
									$("#dialog_content_homeWork > div").css({"height": "420px", "overflow": "scroll"});
								}
							});
							*/
						});
					}
				});
			});
			$("#search_NO").click(function() {
				var homeWorkName_NOVal = $("#homeWorkName_NO").val();
				var className_NOVal = $("#className_NO").val();
				if(homeWorkName_NOVal == null || className_NOVal == null) return;
				$.ajax({
					contentType : "application/json;charset=utf-8",
					type : "GET",
					url : "/ElectronicHomeworkSubmissionSystem/teacher/GetStudent_NO",
					data : "homeWorkName_NO=" + homeWorkName_NOVal + "&className_NO=" + className_NOVal,
					dataType : "json",
					async : false,
					success : function(res) {
						if(res.length == 0) alert("没有未交作业同学！");
						$("#student_homework_No").empty();
						for (var j = 0; j < res.length; j++) {
							if (res[j] != null) {
								$("#studentNO").tmpl(res[j]).appendTo("#student_homework_No");
							} else {
								return false;
							}
						}
					}
				});
			});
		});
		
		function encodeHtml(s){
			var REGX_HTML_ENCODE = /"|&|'|<|>|[\x00-\x20]|[\x7F-\xFF]|[\u0100-\u2700]/g;
		    return (typeof s != "string") ? s : s.replace(REGX_HTML_ENCODE, function($0){
		    	var c = $0.charCodeAt(0), r = ["&#"];
	            c = (c == 0x20) ? 0xA0 : c;
	            r.push(c);
	            r.push(";");
	            return r.join("");
		    });
		}
		
	</script>
  </body>
</html>
