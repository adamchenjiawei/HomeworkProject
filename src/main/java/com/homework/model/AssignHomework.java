package com.homework.model;

public class AssignHomework {

	public int id;
	public int teacher_id;
	public int the_class_id;
	public String title;
	public String content;
	public int path_id;
	public String submit_at;
	public String created_at;
	public String updated_at;
	// 1、文件 2、文本
	public int assignment_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getThe_class_id() {
		return the_class_id;
	}

	public void setThe_class_id(int the_class_id) {
		this.the_class_id = the_class_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPath_id() {
		return path_id;
	}

	public void setPath_id(int path_id) {
		this.path_id = path_id;
	}

	public String getSubmit_at() {
		return submit_at;
	}

	public void setSubmit_at(String submit_at) {
		this.submit_at = submit_at;
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

	public int getAssignment_type() {
		return assignment_type;
	}

	public void setAssignment_type(int assignment_type) {
		this.assignment_type = assignment_type;
	}
	

}
