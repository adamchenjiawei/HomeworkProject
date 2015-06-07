$(function(){
	var homework_id = $("#homework_id").val();
	var student_id =  $("#student_id").val();
	get_data(homework_id,student_id);
});

function get_data(homework_id,student_id){
	var str = '';
	$.ajax({
		contentType : "application/json;charset=utf-8",
		type : "GET",
		url : "/ElectronicHomeworkSubmissionSystem/EditorHomework",
		data : "student_id=" + student_id + "&homework_id=" + homework_id,
		dataType : "json",
		async : false,
		success : function(res) {
			str = "<div class='title'>" + 
			res.title + "<span class='teacher'>" +res.teacher_name+"</span></div>" +
			"<div class='the_class'>"+res.class_name + "：</div>" +
			"<p class='content'>"+res.content + "</p><div class='time'>" +
			"<span class='submit_at'>提交作业时间 ："+res.submit_at +"</span>" + 
			"<span class='created_at'>布置作业时间 ："+res.created_at + "</span></div>"
			$("#homework_infos").empty();
		    $("#homework_infos").html(str);
		}
	});
}
