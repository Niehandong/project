package com.oracleoaec.test;


import java.util.Date;
import java.util.List;

import com.oracleoaec.biz.ICommentBiz;
import com.oracleoaec.bizimpl.CommentBizImpl;
import com.oracleoaec.pojo.Comment;

public class TestComment {
	public static void main(String[] args) {
		ICommentBiz commentBiz=new CommentBizImpl();
		
//		System.out.println("--客户留言 插入数据--");
//		Comment comment=new Comment();
//		comment.setHcContent("我的留言");
//		comment.setHcCreateTime(new Date());
//		comment.setHcNickName("yang");
//		comment.setHcReply("留言回复");
//		comment.setHcState("已回复");
//		int total=commentBiz.addComment(comment);
//		System.out.println("插入留言成功"+total);
		
//		System.out.println("---查看所有留言---");
//		List<Comment> list=commentBiz.allComments();
//		for(Comment comment:list){
//			System.out.println(comment);
//		}
	}
}
