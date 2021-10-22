package com.oracleoaec.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.biz.ICommentBiz;
import com.oracleoaec.bizimpl.CommentBizImpl;
import com.oracleoaec.pojo.Comment;

public class CommentServlet extends HttpServlet{
	
	ICommentBiz commentBiz=new CommentBizImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String hcNickName = req.getParameter("guestName");
		String hcContent = req.getParameter("guestContent");
		System.out.println("guestName="+hcNickName+"guestContent"+hcContent);
		
		Comment comment = new Comment(hcContent, new Date(new java.util.Date().getTime()), hcNickName);
		
		int addComment = commentBiz.addComment(comment);
		
		if(addComment>0){
			resp.sendRedirect("guestbook.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
	
}
