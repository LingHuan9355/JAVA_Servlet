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
		
		//���
		/*Role r = new Role("1003", "1003");
		xmlDao.addRole(r);*/
		
		//�޸�
		//xmlDao.updateRoleById("1003");
		
		//ɾ��
		//xmlDao.deleteRoleById("1003");
		
		//��ѯ
		List<Role> list = xmlDao.findAll();
		for (Role role : list) {
			System.out.println("���=" + role.getId()+",������" +role.getName());
		}
		
		
	}
}
