/**
 * @PackageName: bm.book.model.dao
 * @FileName : BookDao.java
 * @Date : 2020. 4. 17.
 * @���α׷� ���� : 
 * @author 
 */
package bm.book.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bm.book.model.vo.Book;

/**
 * @PackageName: bm.book.model.dao
 * @FileName : BookDao.java
 * @Date : 2020. 4. 17.
 * @프로그램 설명 : 
 * @author 
 */
public class BookDao {

	public List<Book> selectBookList(SqlSession session, String title) throws Exception {

		return session.selectList("BOOK.selectBookList", title);
	}

	public Map<String, String> selectBook(SqlSession session, int b_bno) throws Exception {

		Map<String, String> res = new HashMap<String, String>();
		res = session.selectOne("BOOK.selectBook", b_bno);
		
		return res;
	}
	
	public List<Book> selectInnerBookSearchList(SqlSession session, Map<String, Object> commandMap) throws Exception{
		
		List<Book> res = null;
		
		res = session.selectList("BOOK.selectInnerBookSearchList", commandMap);
		
		return res;
		
	}
	
	

}
