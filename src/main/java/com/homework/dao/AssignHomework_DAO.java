package com.homework.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.AssignHomework;

public interface AssignHomework_DAO {

	public List<AssignHomework> query(@Param(value = "page_m") String page_m,
			@Param(value = "the_class_id") int the_class_id);

	public void add_data(
			@Param(value = "account") String account,
			@Param(value = "className") String className,
			@Param(value = "title") String title,
			@Param(value = "content") String content,
			@Param(value = "url") String url,
			@Param(value = "type") int type,
			@Param(value = "submit_at") String submit_at);

	public int get_data_length(@Param(value = "the_class_id") int the_class_id);
	
	public List<AssignHomework> getDataByDate(
			@Param(value = "beginDate")Date beginDate,
			@Param(value = "endDate")Date endDate,
			@Param(value = "teacherId")String teacherId
	);
	
	public AssignHomework query_home_work(@Param(value = "id")int id);
}
