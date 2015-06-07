package com.homework.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.Param;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.homework.dao.AssignHomework_DAO;
import com.homework.dao.Assignment_DAO;
import com.homework.dao.Class_DAO;
import com.homework.dao.Students_DAO;
import com.homework.dao.Teachers_DAO;
import com.homework.model.AssignHomework;
import com.homework.model.Assignment;
import com.homework.model.ClassAndGrade;
import com.homework.model.Student;
import com.homework.model.Teacher;
import com.homework.service.StudentService;

public class StudentServiceImpl implements StudentService {

	Students_DAO sutdent;
	Class_DAO the_class;
	AssignHomework_DAO homework;
	Teachers_DAO teacher;
	Assignment_DAO assign;

	public void setAssign(Assignment_DAO assign) {
		this.assign = assign;
	}

	public void setTeacher(Teachers_DAO teacher) {
		this.teacher = teacher;
	}

	public void setHomework(AssignHomework_DAO homework) {
		this.homework = homework;
	}

	public Students_DAO getSutdent() {
		return sutdent;
	}

	public void setSutdent(Students_DAO sutdent) {
		this.sutdent = sutdent;
	}

	public Class_DAO getThe_class() {
		return the_class;
	}

	public void setThe_class(Class_DAO the_class) {
		this.the_class = the_class;
	}

	public String Get_Students(String m, String grade, String the_class_name) {
		// TODO Auto-generated method stub
		int class_id = the_class.query_class_id(grade, the_class_name);
		List<Student> s_list = sutdent.query_students(m, class_id);

		JSONArray json_array = new JSONArray();
		for (int i = 0; i < s_list.size(); i++) {
			Student s = s_list.get(i);
			JSONObject student_object = new JSONObject();
			student_object.put("id", s.getId());
			student_object.put("name", s.getName());
			student_object.put("sex", s.getSex());
			student_object.put("age", s.getAge());
			student_object.put("phone", s.getPhone());
			student_object.put("qq", s.getQq());
			student_object.put("e_mail", s.getE_mail());
			student_object.put("the_class", grade + the_class_name);
			student_object.put("student_number", s.getStudent_number());
			student_object.put("dormitory", s.getDormitory());
			student_object.put("created_at", s.getCreated_at());
			student_object.put("updated_at", s.getUpdated_at());
			json_array.element(student_object);
		}
		return json_array.toString();
	}

	public String Get_Students_count(String grade, String the_class_name) {
		// TODO Auto-generated method stub
		int class_id = the_class.query_class_id(grade, the_class_name);
		int counts = sutdent.query_students_count(class_id);
		return String.valueOf(counts);
	}

	public void Delete_student(String id) {
		// TODO Auto-generated method stub
		int id_i = Integer.parseInt(id);
		sutdent.delete_student(id_i);
	}

	public String search_Students(String m, String grade,
			String the_class_name, String name) {
		// TODO Auto-generated method stub
		int class_id = the_class.query_class_id(grade, the_class_name);
		List<Student> s_list = sutdent.search_students(m, class_id, name);

		JSONArray json_array = new JSONArray();
		for (int i = 0; i < s_list.size(); i++) {
			Student s = s_list.get(i);
			JSONObject student_object = new JSONObject();
			student_object.put("id", s.getId());
			student_object.put("name", s.getName());
			student_object.put("sex", s.getSex());
			student_object.put("age", s.getAge());
			student_object.put("phone", s.getPhone());
			student_object.put("qq", s.getQq());
			student_object.put("e_mail", s.getE_mail());
			student_object.put("the_class", grade + the_class_name);
			student_object.put("student_number", s.getStudent_number());
			student_object.put("dormitory", s.getDormitory());
			student_object.put("created_at", s.getCreated_at());
			student_object.put("updated_at", s.getUpdated_at());
			json_array.element(student_object);
		}
		return json_array.toString();
	}

	public String search_Students_count(String grade, String the_class_name,
			String name) {
		// TODO Auto-generated method stub
		int class_id = the_class.query_class_id(grade, the_class_name);
		int counts = sutdent.search_students_count(class_id, name);
		return String.valueOf(counts);
	}

	public void add_student(String name, String age, String sex, String e_mail,
			String phone, String qq, String dormitory, String the_class,
			String hashpassword, String student_number) {
		int age_i = Integer.parseInt(age);
		int phone_i = Integer.parseInt(phone);
		int the_class_i = Integer.parseInt(the_class);
		String salt = "1";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String created_at = df.format(new Date());
		String updated_at = df.format(new Date());
		String hashed_password = DigestUtils.md5Hex(hashpassword);
		sutdent.add_student(name, age_i, sex, e_mail, phone_i, qq, dormitory,
				the_class_i, hashed_password, salt, created_at, updated_at,
				student_number);
		// TODO Auto-generated method stub

	}

	public String editor_homework_info(String homework_id, String student_id) {
		// TODO Auto-generated method stub
		int student_id_i = Integer.parseInt(student_id);
		AssignHomework homework_info = homework.query_home_work(Integer
				.parseInt(homework_id));
		int the_class_id = homework_info.the_class_id;
		int teacher_id = homework_info.teacher_id;
		Teacher teacher_info = teacher.query_teacher_info(teacher_id);
		ClassAndGrade class_and_grade = the_class.query_class(the_class_id).get(0);
		String class_name = class_and_grade.grade + class_and_grade.the_class;
		List<Assignment> list_assign_infos = assign.query_student_submit(
				student_id_i, homework_info.id);

		String submit_state = "false";
		if (list_assign_infos.size() != 0) {
			submit_state = "true";
		}

		JSONObject json_object = new JSONObject();
		json_object.put("title", homework_info.title);
		json_object.put("content", homework_info.content);
		json_object.put("submit_at", homework_info.submit_at);
		json_object.put("created_at", homework_info.created_at);
		json_object.put("submit_state", submit_state);
		json_object.put("class_name", class_name);
		json_object.put("teacher_name", teacher_info.name);

		return json_object.toString();
	}

	public List<Assignment> getStudent(String homeWorkName, String className,
			String account) {
		List<Assignment> assignmentList = sutdent.getAssignMent(homeWorkName,
				className, account);
		for (Assignment assignment : assignmentList) {
			assignment.setStudent_id(sutdent.query_student(assignment.getId())
					.getName());
		}
		return assignmentList;
	}

	public List<Student> getStudentNO(String homeWorkName_NO,
			String className_NO, String account) {
		List<Student> student = sutdent.getStudentNO(homeWorkName_NO,
				className_NO, account);
		return student;
	}

	public List<ClassAndGrade> getClassName(String account) {
		List<ClassAndGrade> classAndGrade = the_class.getClassName(account);
		return classAndGrade;
	}

	public String Query_Student(int id) {
		List<Student> sutdent_query = sutdent.query_students_one(id);
		return sutdent_query != null ? JSONArray.fromObject(sutdent_query)
				.toString() : null;
	}

	public void updata_student(int id, String name, String age, String sex,
			String e_mail, String phone, String qq, String dormitory,
			String the_class, String hashpassword, String student_number) {
		int age_i = Integer.parseInt(age);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String updated_at = df.format(new Date());
		String hashed_password = DigestUtils.md5Hex(hashpassword);
		sutdent.update_student(id, name, age_i, sex, e_mail, qq, phone,
				dormitory, hashed_password, student_number, the_class,
				updated_at);
	}

}
