package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.Assignment;

public interface Assignment_DAO {

	public List<Assignment> query_student_submit(
			@Param(value = "student_id") int student_id,
			@Param(value = "assign_home_id") int assign_home_id);
	
	List<Assignment> getHomeWorkContent(
			@Param(value = "homeWorkID") String homeWorkID);
}
