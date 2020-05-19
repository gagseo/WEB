package com.kh.jspPrac.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.kh.jspPrac.member.model.dao.MemberDao;
import com.kh.jspPrac.member.model.vo.Member;

import common.JDBCTemplate;
import excepstion.BookException;

public class MemberService {

	private MemberDao mDao = new MemberDao();

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public Map<String, Object> insertMember(Member m) throws BookException {

		Connection conn = jdt.getConnection();

		Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			mDao.insertMember(conn, m);
			resultMap.put("isSuccess", true);
			resultMap.put("res", "회원가입에 성공했습니다.");
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
			resultMap.put("isSuccess", false);
			resultMap.put("res", "시스템 관리자에게 문의 해주세요.");
			throw new BookException(e.getMessage());
		} finally {
			jdt.close(conn);
		}

		return resultMap;
	}

}
