package com.homework.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.homework.dao.Class_DAO;
import com.homework.model.ClassAndGrade;
import com.homework.model.TheClassSelect;
import com.homework.service.TheClassService;

public class TheClassServiceImpl implements TheClassService {

	Class_DAO the_class;


	public void setThe_class(Class_DAO the_class) {
		this.the_class = the_class;
	}

	public String GetGrade() {
		// TODO Auto-generated method stub
		List<String> res = the_class.get_grade();
		if (res.size() != 0) {
			return res.toString();
		}
		return null;
	}

	public String GetClass(String grade) {
		// TODO Auto-generated method stub
		List<String> res = the_class.get_the_class(grade);
		if (res.size() != 0) {
		return res.toString();
		}
		return null;
	}

	public String GetAllClass() {
		// TODO Auto-generated method stub
		List<TheClassSelect> res = the_class.query_class_all();
		JSONArray json_array = new JSONArray();
		for (int i = 0; i < res.size(); i++) {
			TheClassSelect the_class_select = res.get(i);
			JSONObject json_object = new JSONObject();
			json_object.put("id", the_class_select.id);
			json_object.put("the_class", the_class_select.grade+the_class_select.the_class);
			json_array.element(json_object);
		}
		return json_array.toString();
	}

	public String GetTheClassPage(int page_start) {
		List<ClassAndGrade> the_addgrade = the_class
				.query_che_class(page_start);
		return the_addgrade != null ? JSONArray.fromObject(the_addgrade)
				.toString() : null;
	}

	public int GetClassCher() {
		int theclassCount = the_class.getClassCount();
		return theclassCount;
	}

	public void GetTheClassDelete(String id) {
		int id_i = Integer.parseInt(id);
		the_class.delete_class(id_i);
	}

	public void add_teacher(String grade, String the_class_info,
			String counselors, String age, String sex, String e_mail,
			String phone) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String created_at = df.format(new Date());
		String updated_at = df.format(new Date());

		the_class.add_class(grade, the_class_info, counselors,
				Integer.parseInt(age), sex, e_mail, phone, created_at,
				updated_at);
	}

	public String GetTherClassQuery(int id) {
		List<ClassAndGrade> classandgrade = the_class.query_class(id);
		return classandgrade != null ? JSONArray.fromObject(classandgrade)
				.toString() : null;
	}

	public void Get_The_Class_Update(int id, String grade,
			String the_class_info, String counselors, String age,
			String e_mail, String phone, String sex) {
		int age_i = Integer.parseInt(age);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String updated_at = df.format(new Date());
		the_class.update_class(id, grade, the_class_info, counselors, age_i,
				sex, e_mail, phone, updated_at);
	}


}
