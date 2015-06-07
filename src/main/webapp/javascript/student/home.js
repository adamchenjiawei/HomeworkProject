$(function(){
    var student_id = $("#student_id").text();
	getData(student_id,0);
});

// 请求数据
function getData(student_id, page_m) {
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/GetAllHomework",
		data : "student_id=" + student_id + "&page_m=" + page_m,
		dataType : "json",
		async : false,
		success : function(res) {
			reqData = res;
			$("#work").empty();
			for (var j = 0; j < 5; j++) {
				if (reqData[j] != null) {
					$("#myTemplate").tmpl(reqData[j]).appendTo(
							"#work");
				} else {
					return false;
				}
			}
		}
	});
}