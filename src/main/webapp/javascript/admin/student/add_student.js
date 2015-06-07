$(function(){
	
	get_class();
	
});
var reqData = [];

function get_class(){
    $.ajax({
        type: "GET",
        dataType: "text",
        async: false,
        url: "/ElectronicHomeworkSubmissionSystem/get_all_class",
        success: function (data) {
            var html = "";
            reqData = $.parseJSON(data);
            for (var i = 0; i < reqData.length; i++) {
                html += "<option value ="+reqData[i].id +">"
                    + reqData[i].the_class + "</option>";
            }
            $("#the_class").html(html);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(textStatus);
        }

    });
}