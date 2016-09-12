package com.hanbit.web.services;

import com.hanbit.web.domains.SubjectDTO;

/**
 * @date  : 2016. 7. 26.
 * @author: 배근홍
 * @file  : SubjectService.java
 * @story  :
 */
public interface SubjectService {
	public void insert(SubjectDTO bean);
	public SubjectDTO findById(String id);
}
