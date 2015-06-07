$(function() {
	getpara();

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
			teacher_Query(para);
		} else {
			document.write("没有参数!");
		}
	}
	function teacher_Query(id) {
		$.ajax({
			contentType : "application/json;charset=utf-8",
			type : "GET",
			url : "/ElectronicHomeworkSubmissionSystem/Get_Teacher_Query",
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
					$("#office").val(res[i].office);
					$("#login_user").val(res[i].login_user);
					$("#hashed_password").val(res[i].hashed_password);
				}
			}
		});
	}

});