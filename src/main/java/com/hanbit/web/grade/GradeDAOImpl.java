package com.hanbit.web.grade;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

@Repository
public class GradeDAOImpl implements GradeDAO {
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory;
	private static final String NAMESPACE = "mapper.grade.";
	private static GradeDAOImpl instance;
	private GradeDAOImpl() {
		try{
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch(IOException e){
			logger.info("session build fail");
		}
	}
	public static GradeDAOImpl getInstance() {
		if (instance == null) 
			logger.info("GradeDAOImpl instance is null");
			instance = new GradeDAOImpl();
		return instance;
	}
	public GradeDAOImpl (SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public int insert(GradeVO grade) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",grade);
	}
	@Override
	public int update(GradeVO grade){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",grade);
	}
	@Override
	public int delete(String delete) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",delete);
	}
	@Override
	public List<?> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public GradeVO findBySeq(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
		return session.selectOne(NAMESPACE + "findBySeq",seq);
		}finally{
			session.close();
		}
	
		
	}
	@Override
	public List<?> findByID(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",id);
	}
	@Override
	public int count(String findByDate){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
}