package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.AssignHomework;
import com.homework.model.Assignment;
import com.homework.model.Student;
import com.homework.model.User;

public interface Students_DAO {

	public void add_student(@Param(value = "name") String name,
			@Param(value = "age") int age, @Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "phone") int phone, @Param(value = "qq") String qq,
			@Param(value = "dormitory") String dormitory,
			@Param(value = "class_id") int class_id,
			@Param(value = "hashpassword") String hashpassword,
			@Param(value = "salt") String salt,
			@Param(value = "created_at") String created_at,
			@Param(value = "updated_at") String updated_at,
			@Param(value = "student_number") String student_number);

	public User login(@Param(value = "student_number") String student_number,
			@Param(value = "hashed_password") String hashed_password);

	public void delete_student(@Param(value = "id") int id);

	public void update_student(@Param(value = "id") int id,
			@Param(value = "name") String name,
			@Param(value = "age") int age,
			@Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "qq") String qq, 
			@Param(value = "phone") String phone,
			@Param(value = "dormitory") String dormitory,
			@Param(value = "hashpassword") String hashpassword,
			@Param(value = "student_number") String student_number,
			@Param(value = "class_id") String class_id,
			@Param(value = "updated_at") String updated_at);

	public List<Student> query_students(@Param(value = "page_m") String page_m,
			@Param(value = "the_class_id") int the_class_id);

	public Integer query_students_count(
			@Param(value = "the_class_id") int the_class_id);

	public List<Student> search_students(
			@Param(value = "page_m") String page_m,
			@Param(value = "the_class_id") int the_class_id,
			@Param(value = "name") String name);

	public Integer search_students_count(
			@Param(value = "the_class_id") int the_class_id,
			@Param(value = "name") String name);

	public Integer student_class_id(@Param(value = "id") int id);
	
	public Student query_student(
			@Param(value = "id") int id
	);

	public List<Assignment> getAssignMent(
			@Param(value = "homeWorkName")String homeWorkName, 
			@Param(value = "className")String className,
			@Param(value = "account")String account);

	public List<Student> getStudentNO(
			@Param(value = "homeWorkName_NO")String homeWorkName_NO,
			@Param(value = "className_NO")String className_NO, 
			@Param(value = "account")String account);

	public List<Student> query_students_one(@Param(value = "id") int id);
}
