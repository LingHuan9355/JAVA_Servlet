package com.cshr.test;

import java.util.List;

import org.junit.Test;

import com.cshr.dao.DOMDao;
import com.cshr.entity.Student;


public class TestDao {

	@Test
	public void TestMain() throws Exception{
		DOMDao domDao = new DOMDao();
		
		//���
		/*Student stu = new Student("1007", "���");
	    domDao.insert(stu);*/
		
	    //�޸�
		/*Student stu = new Student("1007", "����");
	    domDao.modify(stu);*/
		
		//ɾ��
	   // domDao.delete("1007");
		
		//1.��ѯ
		List<Student> list = domDao.queryList();
		 for (Student student : list) {
			   System.out.println("id:" + student.getId() + ",name:" +student.getName());
		}
	}
}
