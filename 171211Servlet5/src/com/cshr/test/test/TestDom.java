package com.cshr.test.test;

import java.util.List;

import org.junit.Test;

import com.cshr.test.dao.DomDao;
import com.cshr.test.entity.User;


public class TestDom {

     @Test
     public void TestMain() throws Exception{
    	 DomDao dao = new DomDao();
    	 
    	 //���
    	 //User us = new User("1003", "��", "jack", "1998-1-1");
    	 //dao.insert(us);
    	 
    	 //�޸�
    	 //User us = new User("1003", "Carl", "1993-05-05");
    	 //dao.modify(us);
    	 
    	 //ɾ��
    	 //dao.delete("1003");
    	 
    	 //��ѯ
    	 List<User> list = dao.queryList();
    	   for (User user : list) {
			  System.out.println("��ţ�"+user.getId() + ",������" +user.getName()+
					 ",�Ա�"+ user.getSex()+",���գ�"+user.getBrith());
		}
     }
}
