package com.homework.service;

public interface TeacherService {

	public String GetTeacherPage(int page_start);

	public int GetTearCher();

	public void add_teacher(String name, String age, String sex, String e_mail,
			String phone, String qq, String office, String hashpassword,
			String login_user);

	public void Delete_teacher(String id);

	public String search_Teachers(String page, String name);

	public String search_teacher_count(String name);

	public String query_teacher(int id);

	public void updata_teacher(int id, String name, String sex, String age,
			String e_mail, String phone, String office, String qq,
			String login_user, String hashpassword);
}
