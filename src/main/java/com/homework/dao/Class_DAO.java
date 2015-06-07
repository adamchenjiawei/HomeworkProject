package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.ClassAndGrade;
import com.homework.model.TheClassSelect;

public interface Class_DAO {

	public void add_class(@Param(value = "grade") String grade,
			@Param(value = "the_class") String the_class,
			@Param(value = "counselors") String counselors,
			@Param(value = "age") int age, @Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "phone") String phone,
			@Param(value = "created_at") String created_at,
			@Param(value = "updated_at") String updated_at);

	public void update_class(@Param(value = "id") int id,
			@Param(value = "grade") String grade,
			@Param(value = "the_class") String the_class,
			@Param(value = "counselors") String counselors,
			@Param(value = "age") int age, @Param(value = "sex") String sex,
			@Param(value = "e_mail") String e_mail,
			@Param(value = "phone") String phone,
			@Param(value = "updated_at") String updated_at);

	public void delete_class(@Param(value = "id") int id);

	public List<ClassAndGrade> query_class(@Param(value = "id") int id);

	public List<String> get_grade();

	public List<String> get_the_class(@Param(value = "grade") String grade);

	public Integer query_class_id(@Param(value = "grade") String grade,
			@Param(value = "the_class") String the_class);

	public List<TheClassSelect> query_class_all();

	public List<ClassAndGrade> getClassName(
			@Param(value = "account") String account);

	public List<ClassAndGrade> query_che_class(
			@Param(value = "page_start") int page_start);

	public int getClassCount();
}
