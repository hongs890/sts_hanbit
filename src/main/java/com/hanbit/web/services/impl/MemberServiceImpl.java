package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private SqlSession sqlSession;

	@Override
	public String regist(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		if (mapper.insert(mem)==1) {
			msg = mapper.findById(mem.getId()).getName();
		}
		return msg;
	}
	@Override
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}
	@Override
	public MemberDTO findById(String mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		System.out.println("find by id : "+mem);
		return mapper.findById(mem);
	}
	@Override
	public List<?> list() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list();
	}
	@Override
	public List<?> findByName(String findName) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findByName(findName);
	}
	@Override
	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	@Override
	public Map<?, ?> map() {
		return null;
	}
	
	@Override
	public MemberDTO login(MemberDTO member) {
		MemberDTO mem = new MemberDTO();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			if (member.getId() != null && member.getPw() != null && mapper.findById(member.getId()) != null) {
			mem = mapper.findById(member.getId());
			if (member.getPw().equals(mem.getPw())) {
				return mem;
			}else{
				mem.setId("fail");
			}
		}else{
			mem.setId("fail");
		}
		return mem;
	}
	@Override
	public void update(MemberDTO mem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(MemberDTO mem) {
		// TODO Auto-generated method stub
		
	}

}