package com.cshr.test;

import java.util.List;

import org.junit.Test;

import com.cshr.dao.DOMDao;
import com.cshr.entity.Student;


public class TestDao {

	@Test
	public void TestMain() throws Exception{
		DOMDao domDao = new DOMDao();
		
		//Ìí¼Ó
		/*Student stu = new Student("1007", "Ëï¾Å");
	    domDao.insert(stu);*/
		
	    //ĞŞ¸Ä
		/*Student stu = new Student("1007", "ËïÔÚ");
	    domDao.modify(stu);*/
		
		//É¾³ı
	   // domDao.delete("1007");
		
		//1.²éÑ¯
		List<Student> list = domDao.queryList();
		 for (Student student : list) {
			   System.out.println("id:" + student.getId() + ",name:" +student.getName());
		}
	}
}
