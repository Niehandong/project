package com.oracleoaec.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ICommentDao;
import com.oracleoaec.pojo.Comment;
import com.tools.BaseDao;


public class CommentDaoImpl extends BaseDao implements ICommentDao{
	private List<Comment> list=null;
	
	//客户留言 插入数据
	public int addComment(Comment comment) {
		
		String sql="insert into hwua_comment(hc_content,hc_create_time," +
				"hc_nick_name) values(?,?,?)";
		Object param[]={comment.getHcContent(),comment.getHcCreateTime(),comment.getHcNickName()};
		int total=update(sql, param);
		close();
		return total;
	}

	//查看所有留言
	public List<Comment> allComments() {
		
		String sql="select* from hwua_comment";
		Object param[]={};
		List<Comment> list=new ArrayList<Comment>();
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				Comment c = new Comment();
				c.setHcId(rs.getLong(1));
				c.setHcReply(rs.getString(2));
				c.setHcContent(rs.getString(3));
				c.setHcCreateTime(rs.getDate(4));
				c.setHcReplyTime(rs.getDate(5));
				c.setHcNickName(rs.getString(6));
				c.setHcState(rs.getString(7));
				list.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}

}
