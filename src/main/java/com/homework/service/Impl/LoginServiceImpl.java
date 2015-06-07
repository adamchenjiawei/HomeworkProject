package com.homework.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;

import com.homework.dao.Admin_DAO;
import com.homework.dao.Students_DAO;
import com.homework.dao.Teachers_DAO;
import com.homework.model.Student;
import com.homework.model.User;
import com.homework.service.LoginService;

public class LoginServiceImpl implements LoginService{

	private Students_DAO student;
	private Teachers_DAO teacher;
	private Admin_DAO admin;

	public void setStudent(Students_DAO student) {
		this.student = student;
	}
	public void setTeacher(Teachers_DAO teacher) {
		this.teacher = teacher;
	}
	public void setAdmin(Admin_DAO admin) {
		this.admin = admin;
	}
	// user_type : 1、admin 2、student 3、teacher
	public User login(String user_type, String login_user,
			String login_password) {
        String hashed_password = DigestUtils.md5Hex(login_password);
    	User user = null;
    	int user_type_id = Integer.parseInt(user_type);
		switch (user_type_id) {
		case 1:
			user = admin.login(login_user, hashed_password);
			break;
		case 2:
			user  =  student.login(login_user, hashed_password);
			break;
		case 3:
			user = teacher.login(login_user, hashed_password);
			break;
		}
		return user;
	}

}
