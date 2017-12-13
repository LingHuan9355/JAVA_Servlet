package com.cshr.test.test;

import java.util.List;

import org.junit.Test;

import com.cshr.test.dao.XMLDao;
import com.cshr.test.entity.Role;


public class TestDom2 {

	
	@SuppressWarnings("unchecked")
	@Test
	public void TestMian() throws Exception{
		XMLDao xmlDao = new XMLDao();
		
		//Ìí¼Ó
		/*Role r = new Role("1003", "1003");
		xmlDao.addRole(r);*/
		
		//ÐÞ¸Ä
		//xmlDao.updateRoleById("1003");
		
		//É¾³ý
		//xmlDao.deleteRoleById("1003");
		
		//²éÑ¯
		List<Role> list = xmlDao.findAll();
		for (Role role : list) {
			System.out.println("±àºÅ=" + role.getId()+",ÐÕÃû£º" +role.getName());
		}
		
		
	}
}
