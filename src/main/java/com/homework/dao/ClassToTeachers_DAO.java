package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClassToTeachers_DAO {

	public void add_to(@Param(value = "teacher_id") int teacher_id,
			@Param(value = "class_id") int class_id);

	public void delete(@Param(value = "teacher_id") int teacher_id,
			@Param(value = "class_id") int class_id);
	
	public void update(@Param(value = "id") int id);
	
	public List<String> query_to_class(@Param(value = "teacher_id") int teacher_id);
	
	public List<String> query_to_teacher(@Param(value = "class_id") int class_id);
}
