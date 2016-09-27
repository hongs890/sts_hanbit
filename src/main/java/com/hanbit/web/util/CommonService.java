package com.hanbit.web.util;

import java.util.List;
import java.util.Map;

import com.hanbit.web.domains.Retval;

/**
 * @date  : 2016. 7. 8.
 * @author: 배근홍
 * @file  : CommandService.java
 * @story  :
 */
public interface CommonService {
	public List<?> findBy(String keyword);

	public Map<?,?> map();
	
	
}
