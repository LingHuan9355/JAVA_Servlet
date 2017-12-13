package com.cshr.test.test;

import java.util.List;

import org.junit.Test;

import com.cshr.test.dao.DomDao;
import com.cshr.test.entity.User;


public class TestDom {

     @Test
     public void TestMain() throws Exception{
    	 DomDao dao = new DomDao();
    	 
    	 //添加
    	 //User us = new User("1003", "男", "jack", "1998-1-1");
    	 //dao.insert(us);
    	 
    	 //修改
    	 //User us = new User("1003", "Carl", "1993-05-05");
    	 //dao.modify(us);
    	 
    	 //删除
    	 //dao.delete("1003");
    	 
    	 //查询
    	 List<User> list = dao.queryList();
    	   for (User user : list) {
			  System.out.println("编号："+user.getId() + ",姓名：" +user.getName()+
					 ",性别："+ user.getSex()+",生日："+user.getBrith());
		}
     }
}
