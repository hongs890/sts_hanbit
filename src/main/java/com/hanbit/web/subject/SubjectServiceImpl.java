package com.hanbit.web.subject;

import org.springframework.stereotype.Service;


@Service
public class SubjectServiceImpl implements SubjectService{

	SubjectDAOImpl dao = SubjectDAOImpl.getInstance();
	
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {}
	
	public void insert(SubjectVO bean) {
		dao.insert(bean);
	}
	@Override
	public SubjectVO findById(String id) {
		return dao.findById(id);
	}

}
