package com.homework.dao;

import org.apache.ibatis.annotations.Param;

import com.homework.model.User;

public interface Admin_DAO {

	public User login(@Param(value = "user") String  user,
			@Param(value = "hashed_password") String hashed_password);
}
