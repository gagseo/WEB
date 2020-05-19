package com.kh.jspPrac.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.jspPrac.member.model.vo.Member;

import common.JDBCTemplate;

public class MemberDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public void insertMember(Connection conn, Member m) throws SQLException {

		// SQL문 부터 작성
		String sql = "insert into tb_member values(?,?,1001,?,sysdate,'N')";
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getmId());
			pstm.setString(2, m.getmPassword());
			pstm.setString(3, m.getmTell());

			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}

	}

}
