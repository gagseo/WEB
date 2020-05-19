/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @���α׷� ���� : 
 * @author 
 */
package bm.book.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bm.book.model.dao.BookDao;
import bm.book.model.vo.Book;
import common.db.SqlMapConfig;
import common.exception.BMException;

/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @���α׷� ���� : 
 * @author 
 */
public class BookService {

	BookDao bd = new BookDao();
	SqlSessionFactory factory = SqlMapConfig.getInstance();

	public List<Book> selectBookList(String title) throws BMException {

		List<Book> res = null;
		//openSession의 매개변수로 false를 넣어야
		//auto commit이 안된다.
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectBookList(session, title);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BMException("도서 검색 중 에러가 발생했습니다.");
		} finally {
			session.close();
		}

		return res;
	}

	public Map<String, String> selectBook(int b_bno) throws BMException {

		Map<String, String> res = new HashMap<String, String>();
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectBook(session, b_bno);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BMException("도서 검색 중 에러가 발생했습니다.");
		} finally {
			session.close();
		}

		return res;
	}

	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap) throws BMException {

		List<Book> res = null;
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectInnerBookSearchList(session, commandMap);
		} catch (Exception e) {
			e.printStackTrace();
			new BMException("도서 검색 도중 에러가 발생하였습니다.");
		} finally {
			session.close();
		}

		return res;

	}

}
