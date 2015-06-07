package com.homework.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.ClassAndGrade;

public interface TheClassService {

	public String GetGrade();
	
	public String GetClass(String grade);
	
	public String GetAllClass();
	
	public String GetTheClassPage(int page_start);

	public int GetClassCher();

	public void GetTheClassDelete(String id);

	public void add_teacher(String grade, String the_class_info,
			String counselors, String age, String sex, String e_mail,
			String phone);

	public String GetTherClassQuery(int id);

	public void Get_The_Class_Update(int id, String grade,
			String the_class_info, String counselors, String age,
			String e_mail, String phone, String sex);
}
