package bm.notice.model.service;

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
import org.apache.ibatis.session.SqlSessionFactory;
import org.openqa.selenium.remote.Command;

import bm.notice.model.dao.NoticeDao;
import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.db.SqlMapConfig;
import common.exception.BMException;
import common.frontcontroller.ModelAndView;
import common.util.Paging;

public class NoticeService {

	SqlSessionFactory factory = SqlMapConfig.getInstance();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	NoticeDao ndao = new NoticeDao();

	public NoticeService() {
	}

	public int insertNotice(Notice notice) {
		SqlSession session = factory.openSession(false);
		int result = 0;
		try {
			result = ndao.insertNotice(session, notice);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return result;
	}

	public int deleteNotice(int noticeNo) {

		Connection conn = jdt.getConnection();
		int result = 0;
		try {
			result = ndao.deleteNotice(conn, noticeNo);
			jdt.commit(conn);
		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			jdt.close(conn);
		}

		return result;
	}

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage) throws BMException {

		Map<String, Object> res = new HashMap<String, Object>();
		List<Notice> nlist = null;
		SqlSession session = factory.openSession(false);
		Paging p = null;

		try {
			System.out.println("selectNoticeList : " + ndao.contentCnt(session));
			p = new Paging(ndao.contentCnt(session), currentPage, cntPerPage);
			nlist = ndao.selectNoticeList(session, p, orderby);

			res.put("paging", p);
			res.put("nlist", nlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return res;
	}

	public Map<String, Object> noticeDetail(int noticeNo) throws BMException {
		//Map말고 Notice로 하면 noticeMapper가 좀더 간단해진다.

		Map<String, Object> res = new HashMap<String, Object>();
		SqlSession session = factory.openSession(false);

		try {
			res = ndao.noticeDetail(session, noticeNo);
		} catch (Exception e) {
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return res;

	}
}
