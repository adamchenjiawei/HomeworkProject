$(function() {
	GetGrade();
	/**
	 * Created by Administrator on 2015/5/21.
	 */
	// getStudentInfo();
	// grade();
	$("#click_teacher").click(function() {
		getTeacherCount();
		getDateTeacherInfo(0);
	});
	$("#click_class").click(function() {
		getTheClassCount();
		getDateTheClassInfo(0);
	});
});
function deletes() {
	if (confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function the_class(id) {
	window.location.href = 'User_root/RootUpdata.html?id=' + id;
}

function deletes_1() {
	if (confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function updata_teacher(id) {
	window.location.href = 'User_Teacher/TeacherUpdata.html?id=' + id;
}

function updata_root(id) {
	window.location.href = 'User_Student/StudentUpdata.html?id=' + id;
}

function delete_root(id) {
	if (confirm("确认要删除？")) {
		delete_student(id);
		var grade = $("#grade").find('option:selected').text();
		var the_class = $("#the_class").find('option:selected').text();
		getDataStudent_count(grade, the_class);
		getDataStudent(0, grade, the_class);
		window.event.returnValue = false;
	}
}

function teahcer_delete(id) {
	if (confirm("确认要删除？")) {
		delete_teacher(id);
		getTeacherCount();
		window.event.returnValue = false;
	}
}
function delete_teacher(id) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_TeaCher_Delete",
		data : "id=" + id,
		dataType : "json",
		async : false,
		success : function(res) {
		}
	});
}

function theclass_delete(id) {
	if (confirm("确认要删除？")) {
		delete_class(id);
		getTheClassCount();
		window.event.returnValue = false;
	}
}
function delete_class(id) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_TheClass_Delete",
		data : "id=" + id,
		dataType : "json",
		async : false,
		success : function(res) {
		}
	});
}

function exit() {
	if (confirm("确认要注销吗？")) {
		window.top.location.href = "../login.jsp";
		session.invalidate();
		window.event.returnValue = false;
	}
}

function student_search() {
	var name = $("#student_search").val();
	var grade = $("#grade").find('option:selected').text();
	var the_class = $("#the_class").find('option:selected').text();
	getSearchStudent(0, grade, the_class, name);
	getSearchStudent_count(grade, the_class, name);

}
function teache_searh_info() {
	var name = $("#teacher_search").val();
	getSearchTeaCher_Count(name);
}
function getSearchTeaCher_Count(name) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_Search_TeaCher_Count",
		data : "name=" + name,
		dataType : "json",
		async : false,
		success : function(res) {
			user_teacher_page(4, res, name);
			getSearchTeacher(0, name);
		}
	});
}

function user_teacher_page(count_page, display_page, name) {
	$(".pagination").jBootstrapPage({
		pageSize : 20,
		total : display_page,
		maxPageButton : count_page,
		onPageClicked : function(obj, pageIndex) {
			getSearchTeacher((pageIndex) * 20, name);
		}
	});
}

function getSearchTeacher(page, name) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_Search_Teacher",
		data : "page_m=" + page + "&name=" + name,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#teacher_td").empty();
			for (var j = 0; j < reqData.length; j++) {
				if (reqData[j] != null) {
					$("#teacher_id").tmpl(reqData[j]).appendTo("#teacher_td");

				} else {
					return false;
				}
			}
		}
	});
}

function gradechange() {
	$("#grade").change(function() {
	});
}

function cc(grade) {
	GetClass(grade);
	// 获取学生数据ajax
	var the_class = $("#the_class").find('option:selected').text();
	getDataStudent_count(grade, the_class);
	getDataStudent(0, grade, the_class);
}
function aa(the_class) {
	var grade = $("#grade").find('option:selected').text();
	getDataStudent_count(grade, the_class);
	getDataStudent(0, grade, the_class);
}

function delete_student(id) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/delete_student",
		data : "id=" + id,
		dataType : "json",
		async : false,
		success : function(res) {
		}
	});
}

function getDataStudent(page_m, grade, the_class) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/get_students_to_admin",
		data : "grade=" + grade + "&the_class=" + the_class + "&page_m="
				+ page_m,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#content_ul").empty();
			for (var j = 0; j < reqData.length; j++) {
				if (reqData[j] != null) {
					$("#myTemplate").tmpl(reqData[j]).appendTo("#content_ul");
				} else {
					return false;
				}
			}
		}
	});
}

function getTheClassCount() {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_TheClass_Count",
		dataType : "json",
		async : false,
		success : function(res) {
			getPageInate(4, res);
		}

	});
}
function getPageInate(count_page, display_page) {
	$(".the_class_paginate").jBootstrapPage({
		pageSize : 20,
		total : display_page,
		maxPageButton : count_page,
		onPageClicked : function(obj, pageIndex) {
			var grade = $("#grade").find('option:selected').text();
			var the_class = $("#the_class").find('option:selected').text();
			getDateTheClassInfo((pageIndex) * 20);
		}
	});
}
function getDateTheClassInfo(number) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/Get_TheClassByPage",
		data : "pageIndex=" + number,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#classpage").empty();
			for (var j = 0; j < reqData.length; j++) {
				if (reqData[j] != null) {
					$("#the_class_id").tmpl(reqData[j]).appendTo("#classpage");
				} else {
					return false;
				}
			}
		}
	});
}
function getTeacherCount() {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/get_Teacher_count",
		dataType : "json",
		async : false,
		success : function(res) {
			getPage(4, res);
		}
	})

}
function getPage(count_page, display_page) {
	$(".pagination").jBootstrapPage({
		pageSize : 20,
		total : display_page,
		maxPageButton : count_page,
		onPageClicked : function(obj, pageIndex) {
			getDateTeacherInfo((pageIndex) * 20);
		}
	});
}
function getDateTeacherInfo(teacherstatr) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/getTeacherByPage",
		data : "pageIndex=" + teacherstatr,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#teacher_td").empty();
			for (var j = 0; j < reqData.length; j++) {
				if (reqData[j] != null) {
					$("#teacher_id").tmpl(reqData[j]).appendTo("#teacher_td");
				} else {
					return false;
				}
			}
		}
	});
}

function getDataStudent_count(grade, the_class) {
	$
			.ajax({
				contentType : "application/json;charset=utf-8",
				type : "GET",
				url : "/ElectronicHomeworkSubmissionSystem/get_students_count_to_admin",
				data : "grade=" + grade + "&the_class=" + the_class,
				dataType : "json",
				async : false,
				success : function(res) {
					page(4, res);
				}
			});
}

function getSearchStudent(page_m, grade, the_class, name) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/search_student",
		data : "grade=" + grade + "&the_class=" + the_class + "&page_m="
				+ page_m + "&name=" + name,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#content_ul").empty();
			for (var j = 0; j < reqData.length; j++) {
				if (reqData[j] != null) {
					$("#myTemplate").tmpl(reqData[j]).appendTo("#content_ul");
				} else {
					return false;
				}
			}
		}
	});
}

function getSearchStudent_count(grade, the_class, name) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/search_student_count",
		data : "grade=" + grade + "&the_class=" + the_class + "&name=" + name,
		dataType : "json",
		async : false,
		success : function(res) {
			search_page(4, res, name);
		}
	});
}

function search_page(count_page, display_page, name) {
	$(".demo").jBootstrapPage({
		pageSize : 20,
		total : display_page,
		maxPageButton : count_page,
		onPageClicked : function(obj, pageIndex) {
			var grade = $("#grade").find('option:selected').text();
			var the_class = $("#the_class").find('option:selected').text();
			getSearchStudent((pageIndex) * 20, grade, the_class, name);
		}
	});

}

function page(count_page, display_page) {
	$(".demo").jBootstrapPage({
		pageSize : 20,
		total : display_page,
		maxPageButton : count_page,
		onPageClicked : function(obj, pageIndex) {
			var grade = $("#grade").find('option:selected').text();
			var the_class = $("#the_class").find('option:selected').text();
			getDataStudent((pageIndex) * 20, grade, the_class);
		}
	});
}

function GetGrade() {
	$.ajax({
		type : "GET",
		dataType : "text",
		async : false,
		url : "/ElectronicHomeworkSubmissionSystem/get_grade",
		success : function(data) {
			var html = "";
			var temp = data.replace("[", "").replace("]", "").replace(" ", "")
					.split(",");
			for (var i = 0; i < temp.length; i++) {
				html += "<option>" + temp[i].trim() + "</option>";
			}
			$("#grade").html(html);
			GetClass(temp[0].trim());
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}

	});
}

function GetClass(the_class) {
	$.ajax({
		type : "GET",
		async : false,
		dataType : "text",
		url : "/ElectronicHomeworkSubmissionSystem/get_the_class",
		data : "grade=" + the_class,
		success : function(data) {
			var html = "";
			var temp = data.replace("[", "").replace("]", "").replace(" ", "")
					.split(",");
			for (var i = 0; i < temp.length; i++) {
				html += "<option>" + temp[i].trim() + "</option>";
			}
			$("#the_class").html(html);
			var grade = $("#grade").find('option:selected').text();
			var the_class = $("#the_class").find('option:selected').text();
			getDataStudent_count(grade, the_class);
			getDataStudent(0, grade, the_class);
		}
	});
}
