package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.Teacher;
import com.homework.model.User;

public interface Teachers_DAO {

	public User login(@Param(value = "login_user") String  login_user,
			@Param(value = "hashed_password") String hashed_password);
	
	
	public String teacher_name(@Param(value = "id") int id);
	
	public List<Teacher> query_teacher(
			@Param(value = "page_start") int page_start);
	
	public void add_teacher(@Param(value = "name") String name,
			@Param(value = "age") int age, @Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "phone") String phone,
			@Param(value = "qq") String qq,
			@Param(value = "office") String office,
			@Param(value = "login_user") String login_user,
			@Param(value = "hashpassword") String hashpassword,
			@Param(value = "salt") String salt,
			@Param(value = "created_at") String created_at,
			@Param(value = "updated_at") String updated_at);
	
	public void delete_teacher(@Param(value = "id") int id);
	
	public Integer search_teacher_count(@Param(value = "name") String name);

	public List<Teacher> search_teachers(
			@Param(value = "page_m") String page_m,
			@Param(value = "name") String name);
	
	public List<Teacher> query_teacher_one(@Param(value = "id") int id);

	public void update_teachers(
			@Param(value = "id") int id,
			@Param(value = "name") String name,
			@Param(value = "age") int age,
			@Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "phone") String phone,
			@Param(value = "qq") String qq,
			@Param(value = "office") String office,
			@Param(value = "login_user") String login_user,
			@Param(value = "hashed_password") String hashpassword,
			@Param(value = "updated_at") String updated_at);

	public int getTeacherCount();
	
	public Teacher query_teacher_info(
			@Param(value = "id") int id);
}
