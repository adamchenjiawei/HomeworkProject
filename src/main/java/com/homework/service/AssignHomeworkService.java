package com.homework.service;

import java.util.List;

import com.homework.model.Assignment;

public interface AssignHomeworkService {

	public String GetAllData(String page_m, String student_id);

	public String GetCount(String student_id);

	public String GetDataByDate(String beginDate, String endDate,
			String teacherId) throws Exception;
	
	public List<Assignment> getHomeWorkContent(String homeWorkID);

	public String setHomeWork(String className, String title, String content,
			String url, String type, String submitDate, String account);
}
