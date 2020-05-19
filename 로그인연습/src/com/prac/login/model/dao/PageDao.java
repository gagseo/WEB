package com.prac.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.prac.login.model.vo.Member;

import common.JDBCTemplate;

public class PageDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public int memberLogin(Connection con, Member member) throws SQLException {

		int res = 0;
		System.out.println("다오입니다." + member.getmId());
		System.out.println("다오입니다." + member.getmPwd());

		// 입력받은 ID와 PWD를 가진 데이터베이스 값이 있는지 찾는다.
		// select * from tb_member where m_id = ? and m_password= ?;
		// excuteQuery();
		String sql = "SELECT * FROM TB_MEMBER WHERE M_ID = ? AND M_PASSWORD=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, member.getmId());
			pstm.setString(2, member.getmPwd());
			rs = pstm.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}else {
				res = 0;
			}
		}finally {
			jdt.close(pstm);
		}
			return res;

	}

	public int memberJoin(Connection con, Member member) throws SQLException {

		System.out.println("다오입니다." + member.getmId());
		System.out.println("다오입니다." + member.getmPwd());
		System.out.println("다오입니다." + member.getmGender());

		String sql = "INSERT INTO TB_MEMBER VALUES(M_NO.NEXTVAL,?,?,?)";
		// 넘어온 ID, PWD, GENDER를 쿼리문에 PreparedStatment 를 이용해서 , DB에 저장.
		// INSERT INTO TB_MEMBER VALUES(M_NO.NEXTVAL,?,?,?);
		// excuteUpdate();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, member.getmId());
			pstm.setString(2, member.getmPwd());
			pstm.setString(3, member.getmGender());
			res = pstm.executeUpdate();
		
		} finally {
			jdt.close(pstm);
		}
		return res;

	}

}
