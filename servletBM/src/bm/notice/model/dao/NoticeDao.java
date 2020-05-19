package bm.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.util.Paging;

public class NoticeDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public List<Notice> selectNoticeList(Connection conn, Paging p, String orderby) throws SQLException {

		List<Notice> nList = new ArrayList<Notice>();

		//SELECT * FROM (select ROWNUM rnum, n1.* from(select * from tb_notice order by noticeno DESC)n1)WHERE rnum BETWEEN 5 and 10;
		String sql = "SELECT * FROM (select ROWNUM rnum, n1.* from(select * from tb_notice order by " + orderby
				+ " DESC)n1)WHERE rnum BETWEEN ? and ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		System.out.println( p.getStart());
		System.out.println( p.getEnd());
		
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, p.getStart());
		pstm.setInt(2, p.getEnd());

		rs = pstm.executeQuery();
		try {

			while (rs.next()) {

				Notice notice = new Notice();

				notice.setNoticeNo(rs.getInt(2));
				notice.setNoticeTitle(rs.getString(3));
				notice.setNoticeDate(rs.getDate(4));
				notice.setNoticeContent(rs.getString(5));
				nList.add(notice);
			}
		} finally {
			jdt.close(rs, pstm);
		}
		System.out.println(nList);
		return nList;
	}

	public int contentCnt(Connection conn) throws SQLException {
		int res = 0;
		String sql = "select count(*) from tb_notice";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} finally {
			jdt.close(rs,stmt);
		}

		return res;

	}

	public int noticeUpload(Connection conn, Notice n) throws SQLException {

		int res = 0;

		String sql = "insert into tb_notice values(s_notice.nextval,?,sysdate,?,?,?,?)";
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, n.getNoticeTitle());
			pstm.setString(2, n.getNoticeWriter());
			pstm.setString(3, n.getNoticeContent());
			pstm.setString(4, n.getOriginal_filepath());
			pstm.setString(5, n.getRename_filepath());

			res = pstm.executeUpdate();

		} finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	public Notice selectNotice(Connection conn, int noticeNo) throws SQLException {
		
		Notice notice = null;
		
		PreparedStatement pstm = null;
		String sql ="select * from tb_notice where noticeno = ?";
		ResultSet rs = null;
		
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, noticeNo);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				
				notice = new Notice();
				notice.setNoticeNo(rs.getInt(1));
				notice.setNoticeTitle(rs.getString(2));
				notice.setNoticeDate(rs.getDate(3));
				notice.setNoticeWriter(rs.getString(4));
				notice.setNoticeContent(rs.getString(5));
				notice.setOriginal_filepath(rs.getString(6));
				notice.setRename_filepath(rs.getString(7));
			}
			
		} finally {
			jdt.close(conn);
		}
		
		return notice;
		
		
	}
}
