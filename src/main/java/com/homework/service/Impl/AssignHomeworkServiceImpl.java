package com.homework.service.Impl;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.homework.dao.AssignHomework_DAO;
import com.homework.dao.Assignment_DAO;
import com.homework.dao.FilePath_DAO;
import com.homework.dao.Students_DAO;
import com.homework.dao.Teachers_DAO;
import com.homework.model.AssignHomework;
import com.homework.model.Assignment;
import com.homework.service.AssignHomeworkService;

public class AssignHomeworkServiceImpl implements AssignHomeworkService {

	private AssignHomework_DAO assign_homework;
	private Teachers_DAO teacher;
	private Students_DAO student;
	private Assignment_DAO assignDao;
	private FilePath_DAO filePathDao;

	public void setAssignDao(Assignment_DAO assignDao) {
		this.assignDao = assignDao;
	}

	public void setFilePathDao(FilePath_DAO filePathDao) {
		this.filePathDao = filePathDao;
	}

	public void setStudent(Students_DAO student) {
		this.student = student;
	}

	public void setTeacher(Teachers_DAO teacher) {
		this.teacher = teacher;
	}

	public void setAssign_homework(AssignHomework_DAO assign_homework) {
		this.assign_homework = assign_homework;
	}

	public String GetAllData(String page_m, String student_id) {
		// TODO Auto-generated method stub
		int student_id_i = Integer.parseInt(student_id);
		int class_id = student.student_class_id(student_id_i);
		List<AssignHomework> homeworks = assign_homework
				.query(page_m, class_id);
		if (homeworks.size() == 0) {
			return "null";
		} else {
			JSONArray json_array = new JSONArray();
			for (AssignHomework ass : homeworks) {
				String teacher_name = teacher.teacher_name(ass.getTeacher_id());
				JSONObject json_object = new JSONObject();
				json_object.put("id", ass.getId());
				json_object.put("teacher", teacher_name);
				json_object.put("title", ass.getTitle());
				json_object.put("content", ass.getContent());
				json_object.put("submit_at", ass.getSubmit_at());
				json_array.element(json_object);
			}
			return json_array.toString();
		}
	}

	public String GetCount(String student_id) {
		// TODO Auto-generated method stub
		int student_id_i = Integer.parseInt(student_id);
		int class_id = student.student_class_id(student_id_i);
		int count = assign_homework.get_data_length(class_id);
		return String.valueOf(count);
	}

	public String GetDataByDate(String beginDate, String endDate,
			String teacherId) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<AssignHomework> homeworks = assign_homework.getDataByDate(
				sdf.parse(beginDate), sdf.parse(endDate), teacherId);
		return JSONArray.fromObject(homeworks).toString();
	}

	public List<Assignment> getHomeWorkContent(String homeWorkID) {
		List<Assignment> assignment = assignDao.getHomeWorkContent(homeWorkID);
		return assignment;
	}

	public String setHomeWork(String className, String title, String content,
			String url, String type, String submitDate, String account) {
		className = className.substring(6);
		String urlId = filePathDao.queryURL(url);
		if (("").equals(urlId) || urlId == null) {
			filePathDao.saveURL(url, account);
		}
		if (type != null && ("文件").equals(type)) {
			type = "1";
		}
		if (type != null && ("文本").equals(type)) {
			type = "2";
		}
		try {
			assign_homework.add_data(account, className, title, content, url,
					Integer.parseInt(type), submitDate);
			return "添加成功！";
		} catch (Exception e) {
			return "添加失败！";
		}
	}

}
