package com.homework.service.Impl;

import java.util.List;

import com.homework.dao.FilePath_DAO;
import com.homework.model.FilePath;
import com.homework.service.FileService;

public class FileServiceImpl implements FileService {

	private FilePath_DAO filePathDao;

	public void setFilePathDao(FilePath_DAO filePathDao) {
		this.filePathDao = filePathDao;
	}

	public List<FilePath> getURL() {
		List<FilePath> filePath = filePathDao.getURL();
		return filePath;
	}
}
