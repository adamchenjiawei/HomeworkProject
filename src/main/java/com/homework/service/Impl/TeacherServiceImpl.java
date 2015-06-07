package com.homework.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;

import com.homework.dao.Class_DAO;
import com.homework.dao.Teachers_DAO;
import com.homework.model.Student;
import com.homework.model.Teacher;
import com.homework.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private Teachers_DAO teacherDao;
	private Class_DAO the_classDao;

	public void setTeacherDao(Teachers_DAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setThe_classDao(Class_DAO the_classDao) {
		this.the_classDao = the_classDao;
	}

	public String GetTeacherPage(int page_start) {
		List<Teacher> teacher = teacherDao.query_teacher(page_start);
		return teacher != null ? JSONArray.fromObject(teacher).toString()
				: null;
	}

	public int GetTearCher() {
		int teacherCount = teacherDao.getTeacherCount();
		return teacherCount;
	}

	public void add_teacher(String name, String age, String sex, String e_mail,
			String phone, String qq, String office, String hashpassword,
			String login_user) {
		int age_i = Integer.parseInt(age);
		String salt = "1";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String created_at = df.format(new Date());
		String updated_at = df.format(new Date());
		String hashed_password = DigestUtils.md5Hex(hashpassword);
		teacherDao.add_teacher(name, age_i, sex, e_mail, phone, qq, office,
				login_user, hashed_password, salt, created_at, updated_at);
	}

	public void Delete_teacher(String id) {
		int id_i = Integer.parseInt(id);
		teacherDao.delete_teacher(id_i);
	}

	public String search_teacher_count(String name) {
		int i = teacherDao.search_teacher_count(name);
		return String.valueOf(i);
	}

	public String search_Teachers(String page, String name) {
		List<Teacher> searc_teacher = teacherDao.search_teachers(page, name);
		JSONArray json_array = new JSONArray();
		for (int i = 0; i < searc_teacher.size(); i++) {
			Teacher s = searc_teacher.get(i);
			JSONObject teacher_object = new JSONObject();
			teacher_object.put("id", s.getId());
			teacher_object.put("name", s.getName());
			teacher_object.put("sex", s.getSex());
			teacher_object.put("age", s.getAge());
			teacher_object.put("phone", s.getPhone());
			teacher_object.put("qq", s.getQq());
			teacher_object.put("office", s.getOffice());
			teacher_object.put("e_mail", s.getE_mail());
			teacher_object.put("created_at", s.getCreated_at());
			teacher_object.put("updated_at", s.getUpdated_at());
			json_array.element(teacher_object);
		}
		return json_array.toString();
	}

	public String query_teacher(int id) {
		List<Teacher> teacher_query = teacherDao.query_teacher_one(id);
		return teacher_query != null ? JSONArray.fromObject(teacher_query)
				.toString() : null;
	}

	public void updata_teacher(int id, String name, String sex, String age,
			String e_mail, String phone, String office, String qq,
			String login_user, String hashpassword) {
		int age_i = Integer.parseInt(age);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String updated_at = df.format(new Date());
		String hashed_password = DigestUtils.md5Hex(hashpassword);
		teacherDao.update_teachers(id, name, age_i, sex, e_mail, phone, qq,
				office, login_user, hashed_password, updated_at);
	}
}
