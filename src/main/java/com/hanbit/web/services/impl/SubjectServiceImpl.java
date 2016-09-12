package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.SubjectMapper;
import com.hanbit.web.services.SubjectService;


@Service
public class SubjectServiceImpl implements SubjectService{

	SubjectMapper dao;
	
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {}
	
	public void insert(SubjectDTO bean) {
		dao.insert(bean);
	}
	@Override
	public SubjectDTO findById(String id) {
		return dao.findById(id);
	}

}
