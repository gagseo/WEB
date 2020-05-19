package bm.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.Statement;

import com.sun.mail.handlers.message_rfc822;

import bm.member.model.vo.Member;
import common.JDBCTemplate;

public class MemberDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	/**
	 * 1.MethodName : 
	 * 2.ClassName :MemberDao.java 
	 * 3.Comment : 
	 * 4.작성자 : 서호영 
	 * 5.작성일 : 2020. 4. 17.
	 * @throws SQLException 
	 */
	public String idCheck(Connection conn, String id) throws SQLException {

		String res = "";
		String sql = "select m_id from tb_member where m_id = '" + id + "'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	public int insertMember(Connection conn, Member m) throws SQLException {

		int res = 0;
		String sql = "insert into tb_member values(?,?,?,1001,?,sysdate,sysdate,'N')";
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getM_id());
			pstm.setString(2, m.getM_password());
			pstm.setString(3, m.getM_email());
			pstm.setString(4, m.getM_tell());
			res = pstm.executeUpdate();

		} finally {
			jdt.close(pstm);
		}

		return res;
	}

	public Member loginImple(Connection conn, String id, String pw) throws SQLException {
		Member res = null;
		String sql = "select m_id, c_info, m_tell, m_reg_date, m_rentable_date";
		sql += " from tb_member inner join tb_code on";
		sql += " m_grade = c_code ";
		sql += " where m_id = ? and m_password = ? ";

		System.out.println(sql);
		
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();

			while (rs.next()) {
				res = new Member();

				res.setM_id(rs.getString(1));
				res.setM_grade(rs.getString(2));
				res.setM_tell(rs.getString(3));
				res.setM_reg_date(rs.getDate(4));
				res.setM_rentable_date(rs.getDate(5));

			}
			System.out.println(res);

		} finally {
			jdt.close(pstm);
		}

		return res;
	}
	
	public int modifyPw(Connection conn, String id, String newPwd) throws SQLException {
		
		int res = 0;
		String sql = "UPDATE TB_MEMBER SET M_PASSWORD = ? WHERE M_ID = ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newPwd);
			pstm.setString(2, id);
			res = pstm.executeUpdate();
		}finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
