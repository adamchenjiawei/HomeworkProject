$(function() {
	getpara();
	get_class();
	function getpara()// 获取参数的函数
	{
		var url = document.URL;
		var para = "";
		if (url.lastIndexOf("?") > 0) {
			para = url.substring(url.lastIndexOf("?") + 1, url.length);
			var arr = para.split("&");
			para = "";
			for (var i = 0; i < arr.length; i++) {
				para = +arr[i].split("=")[1];
			}
			Stutent_Query(para);
		} else {
			document.write("没有参数!");
		}
	}

	function Stutent_Query(id) {
		$.ajax({
			contentType : "application/json;charset=utf-8",
			type : "GET",
			url : "/ElectronicHomeworkSubmissionSystem/Get_Student_Query",
			data : "id=" + id,
			dataType : "json",
			async : false,
			success : function(res) {
				for (var i = 0; i < res.length; i++) {
					$("#id").val(res[i].id);
					$("#name").val(res[i].name);
					$("#sex").val(res[i].sex);
					$("#age").val(res[i].age);
					$("#phone").val(res[i].phone);
					$("#qq").val(res[i].qq);
					$("#e_mail").val(res[i].e_mail);
					$("#class_id").val(res[i].class_id);
					$("#student_number").val(res[i].student_number);
					$("#hashed_password").val(res[i].hashed_password);
					$("#dormitory").val(res[i].dormitory);
				}
			}
		});
	}
	var reqData = [];

	function get_class() {
		$.ajax({
			type : "GET",
			dataType : "text",
			async : false,
			url : "/ElectronicHomeworkSubmissionSystem/get_all_class",
			success : function(data) {
				var html = "";
				reqData = $.parseJSON(data);
				for (var i = 0; i < reqData.length; i++) {
					html += "<option value =" + reqData[i].id + ">"
							+ reqData[i].the_class + "</option>";
				}
				$("#the_class").html(html);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(textStatus);
			}
		});
	}

});