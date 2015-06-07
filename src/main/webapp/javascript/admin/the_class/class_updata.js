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
			the_class_Query(para);
		} else {
			document.write("没有参数!");
		}
	}
	function the_class_Query(id) {
		$.ajax({
			contentType : "application/json;charset=utf-8",
			type : "GET",
			url : "/ElectronicHomeworkSubmissionSystem/Get_TheClass_Query",
			data : "id=" + id,
			dataType : "json",
			async : false,
			success : function(res) {
				for (var i = 0; i < res.length; i++) {
					$("#id").val(res[i].id);
					$("#grade").val(res[i].grade);
					$("#the_class_info").val(res[i].the_class);
					$("#counselors").val(res[i].counselors);
					$("#age").val(res[i].age);
					$("#sex").val(res[i].sex);
					$("#e_mail").val(res[i].e_mail);
					$("#phone").val(res[i].phone);
				}
			}
		});
	}
});