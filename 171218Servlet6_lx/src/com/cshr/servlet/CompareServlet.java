package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cshr.dao.PaperDao;
import com.cshr.dao.ScoreDao;
import com.cshr.entity.Paper;
import com.cshr.entity.Score;

/**
 * 
 *<p>Title:CompareServlet </p>
 *Description: 
 *4.�������ѡ���ʱ��ʹ��ajax����,���𰸷��͵�һ�������jsp���ó������Ĵ𰸽��жԱ�
  �������ȷ���޸����ֱ�������û���scroe�ֶε�����
 *@author LH
 *@date 2017-12-19����11:12:51
 *@version V1.0
 */
@SuppressWarnings("serial")
public class CompareServlet extends HttpServlet {

	
	   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            // request.setCharacterEncoding("utf-8");
             HttpSession session = request.getSession();
             
             String userName = (String) session.getAttribute("uname");
             String answer = request.getParameter("answer");
             String content = request.getParameter("content");
             
             if(answer != null){
            	 answer = new String(answer.getBytes("iso-8859-1"),"utf-8");
             }
             if(content !=null){
            	 content = new String(content.getBytes("iso-8859-1"),"utf-8");
             }
             
             //System.out.println("�û���="+userName);
             //System.out.println("answer=" +answer+",content="+content);
             
             //������Ŀ���ݲ�ѯ�Ծ���Ϣ
             Paper paper = PaperDao.queryByContent(content);
             //�����û�����ѯ�û�������Ϣ
             Score score = ScoreDao.showScoreByName(userName);

             //�ܷ�
             int scoreSum =0;
             if(paper.getAnswer().equals(answer)){
					//System.out.println("+5��");
					//��ӷ���
				   ScoreDao.editAddScore(userName);
				   score = ScoreDao.showScoreByName(userName);
				   scoreSum = score.getScore();
			 }else{
					//System.out.println("-5��");
					//�жϷ����Ƿ����0,������ɼ��֣����򲻼�������
				  	scoreSum = score.getScore();
					if(scoreSum >0){
						//����
					    ScoreDao.editPointsScore(userName);
					}else{
						System.out.println("�÷�Ϊ0�������ڼ��ˣ�����");
					}
					
					score = ScoreDao.showScoreByName(userName);
					scoreSum = score.getScore();
						
			 }
             
             //�ܷ�
             session.setAttribute("sum", scoreSum);
             request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
             
	   }
	   
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   
		   doGet(req, resp);
	}
}
