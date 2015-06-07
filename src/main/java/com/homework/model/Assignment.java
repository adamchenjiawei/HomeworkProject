package com.homework.model;

public class Assignment {

	public int id;
	public String student_id;
	public String content;
	public String created_at;
	public String updated_at;
	public int assign_home_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public int getAssign_home_id() {
		return assign_home_id;
	}
	public void setAssign_home_id(int assign_home_id) {
		this.assign_home_id = assign_home_id;
	}

	
}
