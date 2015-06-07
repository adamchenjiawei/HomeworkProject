package com.homework.service;

import com.homework.model.User;

public interface LoginService {

	public User login(String user_type, String login_user, String login_password);
}
