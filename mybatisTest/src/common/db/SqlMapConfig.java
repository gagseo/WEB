package common.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	// singleton 방식
	// 단 하나의 인스턴스만 만들어서 사용하는 디자인패턴
	// 인스턴스가 필요할 때 마다 매번 같은 인스턴스를 사용
	// 생성자를 private으로 선언해 생성이 불가하게 하고
	// 인스턴스를 반환해주는 getInstance()메서드를 만든다.

	// 객체의 주기를 싱글톤으로 만드는것이다.

	// Initialization on demand holder idiom
	// (holder에 의한 초기화 방식)

	// 내부클래스를 생성하고, 내부클래스의 상수 필드변수에 
	// 인스턴스를 담는다.
	// 필요할 때 마다 상수 필드변수에 담긴 객체를 반환해준다.

	// 장점
	// 1. 사용자가 필요한 시점에 생성된다.
	// 2. 다른 값이 담길 위험이 없다.(상수선언했기때문에)

	private static class SqlSessionFactoryHolder {

		private static final SqlSessionFactory INSTANCE = createSqlSessionFactory();

	}

	private static SqlSessionFactory createSqlSessionFactory() {

		System.out.println("createSqlSessionFactory?");
		String resource = "common/db/mybatis-config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSessionFactory;

	}

	//위에서 상수선언한 인스턴스를 꺼내온다
	public static SqlSessionFactory getInstance() {

		return SqlSessionFactoryHolder.INSTANCE;

	}

}
