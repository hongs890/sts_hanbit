package com.hanbit.web.member;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.util.Constants;


@Repository
public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory sqlSessionFactory = null;
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
	public MemberVO findById(String pk) {
		SqlSession session = sqlSessionFactory.openSession();
		return (MemberVO) session.selectList("",pk);
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

	public boolean login(MemberVO param) {
		boolean loginOk= false;
		if(param.getId()!=null 
				&& param.getPw()!=null 
				&& this.existId(param.getId())){
			MemberVO member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}
		
		}
		return loginOk;
	}
	@Override
	public boolean existId(String id){
		SqlSession session = sqlSessionFactory.openSession();
		int temp = session.selectOne("",id);
		return false;
	}
}