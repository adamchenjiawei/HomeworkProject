<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>后台管理系统</title>

<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/paginate_style.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.css.map" rel="stylesheet" type="text/css">
<link href="../css/jBootsrapPage.css" rel="stylesheet" type="text/css">
<link href="../css/DomeBootsrapPage.css" rel="stylesheet"
	type="text/css">
<Link href="../css/the_class_bootsrappage.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h2 class="text-center">后台管理系统</h2>
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<iframe name="weather_inc" src="http://tianqi.xixik.com/cframe/1"
								width="330" height="35" frameborder="0" marginwidth="0"
								marginheight="0" scrolling="no"></iframe>
						</div>
					</div>
				</div>
				<div class="container-fluid" style="float: right">
					<div class="row-fluid">
						<div class="span12">
							<span style="font-size: 20px">欢迎&nbsp;<span
								style="font-size: 30px; color: #d9534f">${user.name}</span>&nbsp;进入系统
							</span>&nbsp;&nbsp;&nbsp;
							<button class="btn btn-primary" onclick="exit()" type="button">退出系统</button>
						</div>
					</div>
				</div>
				<br>

				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div class="tabbable" id="tabs-614101">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#panel-401474"
										data-toggle="tab">学生信息管理</a></li>
									<li><a href="#panel-26795" data-toggle="tab"
										id="click_teacher">教师信息管理</a></li>
									<li><a href="#panel-11111" data-toggle="tab"
										id="click_class">班级信息管理</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="panel-401474">
										<p>
										<div class="" style="float: left">
											<span style="font-size: 16px; color: #000;">年级:&nbsp;<select
												id="grade" class="selectpicker" data-style="btn-primary"
												onchange="cc(this[selectedIndex].value);"
												style="width: 160px; height: 35px; border-radius: 5px; -webkit-border-radius: 5px;">
											</select> &nbsp;
											</span> <span style="font-size: 16px; color: #000;">班级:&nbsp;
												<select id="the_class" class="shortselect"
												onchange="aa(this[selectedIndex].value);"
												style="width: 160px; height: 35px; border-radius: 5px; -webkit-border-radius: 5px;">
											</select>
											</span>
										</div>
										<div class="container-fluid" style="float: right">
											<div class="row-fluid">
												<div class="span12">
													<input class="input-medium search-query" type="text"
														id="student_search" placeholder="请输入搜索关键字"
														style="width: 280px; height: 35px; border-radius: 5px; -webkit-border-radius: 5px; font-size: 16px;" />
													<button type="button" class="btn btn-primary"
														onclick="student_search()"
														style="width: 80px; height: 35px; margin-bottom: 5px;">查找</button>
												</div>
											</div>
										</div>
										<br> <br>
										<table class="table table-bordered table-hover"
											style="cursor: pointer;">
											<thead>
												<tr class="info">
													<th>ID</th>
													<th>姓名</th>
													<th>性别</th>
													<th>年龄</th>
													<th>电话</th>
													<th>QQ</th>
													<th>E-mail</th>
													<th>班级</th>
													<th>学号</th>
													<th>公寓</th>
													<th>创建时间</th>
													<th>更新时间</th>
													<th>修改</th>
													<th>删除</th>
												</tr>
											</thead>
											<tbody id="content_ul">
											</tbody>
										</table>
										<ul class="demo"></ul>
										<div class="container-fluid">
											<div class="row-fluid">
												<div class="span12">
													<button class="btn btn-block btn-large btn-primary"
														onclick="window.location.href='User_Student/StudentAdd.html'"
														type=" button">添加学生信息</button>
												</div>
											</div>
										</div>
										</p>
									</div>
									<div class="tab-pane" id="panel-26795">
										<!--教师-->
										<p>
										<div class="container-fluid" style="float: right">
											<div class="row-fluid">
												<div class="span12">
													<form class="form-search form-inline">
														<input class="input-medium search-query"
															id="teacher_search" placeholder="请输入搜索关键字"
															style="width: 280px; height: 35px; border-radius: 5px; -webkit-border-radius: 5px; font-size: 18px;"
															type="text" />
														<button type="button" class="btn btn-primary"
															onclick="teache_searh_info()"
															style="margin-bottom: 5px; width: 80px; height: 35px">查找</button>
													</form>
												</div>
											</div>
										</div>
										<br> <br>
										<table class="table table-bordered table-hover"
											style="cursor: pointer; margin-bottom: 0px">
											<thead>
												<tr class="info">
													<th>ID</th>
													<th>姓名</th>
													<th>性别</th>
													<th>年龄</th>
													<th>E-mail</th>
													<th>电话</th>
													<th>QQ</th>
													<th>办公室</th>
													<th>创建时间</th>
													<th>更新时间</th>
													<th>修改</th>
													<th>删除</th>
												</tr>
											</thead>
											<tbody id="teacher_td">
											</tbody>
										</table>
										<ul class="pagination"></ul>
										<div class="container-fluid">
											<div class="row-fluid">
												<div class="span12">
													<button class="btn btn-block btn-large btn-primary"
														onclick="window.location.href='User_Teacher/TeacherAdd.html'"
														type=" button">添加教师信息</button>
												</div>
											</div>
										</div>
										</p>
									</div>
									<div class="tab-pane" id="panel-11111">
										<p>
										<table class="table table-bordered table-hover"
											style="cursor: pointer;">
											<thead>
												<tr class="info">
													<th>ID</th>
													<th>年级</th>
													<th>班级</th>
													<th>辅导员</th>
													<th>年龄</th>
													<th>性别</th>
													<th>E-mail</th>
													<th>手机号码</th>
													<th>创建时间</th>
													<th>更新时间</th>
													<th>修改</th>
													<th>删除</th>
												</tr>
											</thead>
											<tbody id="classpage"></tbody>
										</table>
										<ul class="the_class_paginate"></ul>
										<div class="container-fluid">
											<div class="row-fluid">
												<div class="span12">
													<button class="btn btn-block btn-large btn-primary"
														onclick="window.location.href='User_root/RootAdd.html'"
														type=" button">添加班級信息</button>
												</div>
											</div>
										</div>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../javascript/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../javascript/bootstrap.js"></script>
	<script type="text/javascript" src="../javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="../javascript/jquery.paginate.js"></script>
	<script type="text/javascript" src="../javascript/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="../javascript/jBootstrapPage.js"></script>
	<script id="myTemplate" type="text/x-jquery-tmpl">
<tr style="text-align: center">
  <td>{{= id}}</td>
  <td>{{= name}}</td>
  <td>{{= sex}}</td>
  <td>{{= age}}</td>
  <td>{{= phone}}</td>
  <td>{{= qq}}</td>
  <td>{{= e_mail}}</td>
  <td>{{= the_class}}</td>
  <td>{{= student_number}}</td>
  <td>{{= dormitory}}</td>
  <td>{{= created_at}}</td>
  <td>{{= updated_at}}</td>
 <td><button class="btn btn-info" onclick="updata_root({{= id}})">修改</button></td>
 <td><button class="btn btn-info" onclick="delete_root({{= id}})">删除</buntton></td>
</tr>
</script>
	<script id="teacher_id" type="text/x-jquery-tmpl">
<tr style="text-align: center">
  <td>{{= id}}</td>
  <td>{{= name}}</td>
  <td>{{= sex}}</td>
  <td>{{= age}}</td>
  <td>{{= phone}}</td>
  <td>{{= qq}}</td>
  <td>{{= e_mail}}</td>
  <td>{{= office}}</td>
  <td>{{= created_at}}</td>
  <td>{{= updated_at}}</td>
 <td><button class="btn btn-info" onclick="updata_teacher({{= id}})">修改</button></td>
 <td><button class="btn btn-info" onclick="teahcer_delete({{= id}})">删除</buntton></td>
</tr>
</script>
	<script id=the_class_id type="text/x-jquery-tmpl">
<tr style="text-align: center">
  <td>{{= id}}</td>
  <td>{{= grade}}</td>
  <td>{{= the_class}}</td>
  <td>{{= counselors}}</td>
  <td>{{= age}}</td>
  <td>{{= sex}}</td>
  <td>{{= e_mail}}</td>
  <td>{{= phone}}</td>
  <td>{{= created_at}}</td>
  <td>{{= updated_at}}</td>
<td>
	<button class="btn btn-info" type="button" onclick="the_class({{= id}})">修改</button>
</td>
<td>
	<button class="btn btn-info" type="button"onclick="theclass_delete({{= id}})">删除</button>
</td>
</tr>
</script>
	<script type="text/javascript" src="../javascript/admin/home.js"></script>
</body>
</html>