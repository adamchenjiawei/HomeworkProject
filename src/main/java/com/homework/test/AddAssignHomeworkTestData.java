package com.homework.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.dao.AssignHomework_DAO;

public class AddAssignHomeworkTestData {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		AssignHomework_DAO AssignHomeworkMapper = (AssignHomework_DAO) ctx
				.getBean("AssignHomeworkMapper");
		for (int i = 0; i < 51; i++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());
			System.out.println("ceshi");
			System.out.println("ceshi2");
//			AssignHomeworkMapper.add_data(1,6, "作业"+i, "抄书"+(i*10)+"遍", 1, date, date, date);
		}
	}
}
