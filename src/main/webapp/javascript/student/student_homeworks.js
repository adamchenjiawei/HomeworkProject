$(function() {
    var student_id = $("#student_id").text();
	getDataCount(student_id);
	getData(student_id, 0);
	
//	function page(count_page,display_page) {
//		$("#demo").paginate(
//				{
//					count : count_page,
//					start : 1,
//					display : display_page,
//					border : true,
//					bord_color : '#d3d3d3',
//					text_color : '#228fbd',
//					background_color : '#f7f7f7',
//					border_hover_color : '#005687',
//					text_hover_color : '#0079BA',
//					background_hover_color : '#7bbfea',
//					images : false,
//					mouse : 'press',
//					onChange : function(page) {
//						$("#content_ul").empty();
//						$("<b style='text-align:center'>数据加载中...</b>")
//								.appendTo("#content_ul");
//						$(".jPag-pages").css("width","100%");
//						getData(student_id, (page - 1) * 10);
//					}
//				})
//
//	}
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
				$("#content_ul").empty();
				for (var j = 0; j < reqData.length; j++) {
					if (reqData[j] != null) {
						$("#myTemplate").tmpl(reqData[j]).appendTo(
								"#content_ul");
					} else {
						return false;
					}
				}
			}
		});
	}
	function page(count_page, display_page) {
		$(".paginate").jBootstrapPage({
			pageSize : 20,
			total : display_page,
			maxPageButton : count_page,
			onPageClicked : function(obj, pageIndex) {
				$("#content_ul").empty();
				$("<b style='text-align:center'>数据加载中...</b>")
						.appendTo("#content_ul");
				getData(student_id, (pageIndex - 1) * 10);
			}
		});
	}
	
	// 请求数据
	function getDataCount(student_id) {
		$.ajax({
			contentType : "application/json;charset=utf-8",
			type : "GET",
			url : "/ElectronicHomeworkSubmissionSystem/GetAllHomeworkCount",
			data : "student_id=" + student_id,
			dataType : "json",
			async : false,
			success : function(res) {
				var count_page = Math.ceil(res/10);
				var display_page = 10;
				if(count_page < display_page){
					display_page = count_page;
				}
				page(count_page,display_page);
				$(".jPag-pages").css("width","100%");
			}
		});
	}
	
	
});