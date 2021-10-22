package com.oracleoaec.bizimpl;

import java.util.List;

import com.oracleoaec.biz.ICommentBiz;
import com.oracleoaec.dao.ICommentDao;
import com.oracleoaec.daoimpl.CommentDaoImpl;
import com.oracleoaec.pojo.Comment;

public class CommentBizImpl implements ICommentBiz{
	
	ICommentDao icd= new CommentDaoImpl();
	
	//客户留言 插入数据
	public int addComment(Comment comment) {
		
		return icd.addComment(comment);
	}

	//查看所有留言
	public List<Comment> allComments() {
		
		return icd.allComments();
	}

}
