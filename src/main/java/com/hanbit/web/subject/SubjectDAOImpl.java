package com.hanbit.web.subject;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository
public class SubjectDAOImpl implements SubjectDAO{
	private SqlSessionFactory sqlSessionFactory;
	private static final String NAMESPACE = "mapper.subject.";
	private static final Logger logger = LoggerFactory.getLogger(SubjectDAOImpl.class);
	private static SubjectDAOImpl instance;
	public static SubjectDAOImpl getInstance() {
		if (instance == null) 
			logger.info("SubjectDAOImpl instance is null");
			instance = new SubjectDAOImpl();
		return instance;
	}
	private SubjectDAOImpl() {
		try{
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch(IOException e){
			logger.info("session build fail");
		}
	}
	public SubjectDAOImpl (SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public void insert(SubjectVO sub){
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("",sub);
	}
	@Override
	public SubjectVO findById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
		return session.selectOne(NAMESPACE + "findById", id);
		}finally{
			session.close();
		}
	}
}
