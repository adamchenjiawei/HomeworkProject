package com.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homework.model.FilePath;

public interface FilePath_DAO {


List<FilePath> getURL();
	
	String queryURL(@Param(value = "urlName")String urlName);
	
	void saveURL(
			@Param(value = "urlName")String urlName,
			@Param(value = "teacherId")String teacherId);
}
