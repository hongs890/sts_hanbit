package com.hanbit.web.member;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.subject.SubjectMemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance;
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "mapper.member.";
	private SqlSessionFactory sqlSessionFactory;
	private MemberDAOImpl(){
		try{
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch(IOException e){
			logger.info("session build fail");
		}
	}
	public static MemberDAOImpl getInstance() {
		if (instance == null) 
			logger.info("MemberDAOImpl instance is null");
			instance = new MemberDAOImpl();
		return instance;
	}
	public MemberDAOImpl (SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public int insert(MemberVO member) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",member);
	}
	
	@Override
	public int update(MemberVO member) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",member);
	}
	@Override
	public int delete(MemberVO member) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",member);
	}
	@Override
	public List<?> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public SubjectMemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
		return session.selectOne(NAMESPACE + "findById", id);
			}finally{
				session.close();
		}
	}
	@Override
	public List<?> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("",name);
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	@Override
	public boolean login(SubjectMemberVO param) {
		boolean loginOk= false;
		if(param.getId()!=null && param.getPw()!=null && this.findById(param.getId()) !=null){
			SubjectMemberVO member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}
		}
		return loginOk;
	}

}