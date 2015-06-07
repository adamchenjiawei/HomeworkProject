package com.homework.service;

import java.util.List;

import com.homework.model.Assignment;
import com.homework.model.ClassAndGrade;
import com.homework.model.Student;

public interface StudentService {

	public String Get_Students(String m ,String grade, String the_class);
	
	public String Get_Students_count(String grade, String the_class_name);
	
	public  void Delete_student(String id);
	
	public String search_Students(String m ,String grade, String the_class,String name);
	
	public String search_Students_count(String grade, String the_class_name,String name);
	
	
	public void add_student(String name,String age,String sex,String e_mail,String phone,String qq,String dormitory,
			                String the_class,String hashpassword,String student_numberv);
    
	public String editor_homework_info(String homework_id ,String student_id);

	List<Assignment> getStudent(String homeWorkName, String className, String account);

	List<Student> getStudentNO(String homeWorkName_NO, String className_NO,
			String account);

	List<ClassAndGrade> getClassName(String account);
	
	public String Query_Student(int id);

	public void updata_student(int id, String name, String age, String sex,
			String e_mail, String phone, String qq, String dormitory,
			String the_class, String hashpassword, String student_number);
}
