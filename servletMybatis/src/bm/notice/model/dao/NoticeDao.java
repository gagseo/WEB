
package bm.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.util.Paging;

public class NoticeDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public NoticeDao() {
	}

	public int insertNotice(SqlSession session, Notice notice) throws Exception {
	
		return session.insert("NOTICE.insertNotice", notice);
	}

	public List<Notice> selectNoticeList(SqlSession session, Paging p, String orderby) throws Exception {

		List<Notice> nlist = new ArrayList<Notice>();
		Map<String, Object> res = new HashMap<String, Object>();
		
		// 두번째 함정
		// map에 noticeMapper에 쿼리문에 넣을 값들을 넣어줘야한다.
		res.put("orderBy", orderby);
		res.put("start", p.getStart());
		res.put("end", p.getEnd());
		
		nlist = session.selectList("NOTICE.selectNoticeList", res);
		return nlist;
	}

	public int deleteNotice(Connection con, int noticeNo) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from notice " + "where notice_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			result = pstmt.executeUpdate();

		} finally {
			jdt.close(pstmt);
		}

		return result;
	}

	public Map<String, Object> noticeDetail(SqlSession session, int noticeNo) throws Exception{
		
		return session.selectOne("NOTICE.noticeDetail", noticeNo);
	}

	public int contentCnt(SqlSession session) throws Exception {
		
		return session.selectOne("NOTICE.contentCnt");
	}
}
