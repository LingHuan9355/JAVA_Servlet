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
 *4.当点击单选框的时候，使用ajax技术,将答案发送到一个判题的jsp，拿出这个题的答案进行对比
  ，如果正确，修改评分表中这个用户的scroe字段的数据
 *@author LH
 *@date 2017-12-19上午11:12:51
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
             
             //System.out.println("用户名="+userName);
             //System.out.println("answer=" +answer+",content="+content);
             
             //根据题目内容查询试卷信息
             Paper paper = PaperDao.queryByContent(content);
             //根据用户名查询用户分数信息
             Score score = ScoreDao.showScoreByName(userName);

             //总分
             int scoreSum =0;
             if(paper.getAnswer().equals(answer)){
					//System.out.println("+5分");
					//添加分数
				   ScoreDao.editAddScore(userName);
				   score = ScoreDao.showScoreByName(userName);
				   scoreSum = score.getScore();
			 }else{
					//System.out.println("-5分");
					//判断分数是否大于0,大于则可减分，否则不减分数。
				  	scoreSum = score.getScore();
					if(scoreSum >0){
						//减分
					    ScoreDao.editPointsScore(userName);
					}else{
						System.out.println("得分为0，不能在减了！！！");
					}
					
					score = ScoreDao.showScoreByName(userName);
					scoreSum = score.getScore();
						
			 }
             
             //总分
             session.setAttribute("sum", scoreSum);
             request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
             
	   }
	   
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   
		   doGet(req, resp);
	}
}
