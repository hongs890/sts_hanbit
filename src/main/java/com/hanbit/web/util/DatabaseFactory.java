package com.hanbit.web.util;

import java.sql.Connection;

import com.hanbit.web.constants.Values;

/**
 * @date  : 2016. 7. 5.
 * @author: 배근홍
 * @file  : DatabaseFactory.java
 * @story  :
 */
public class DatabaseFactory {
	public static Database createDatabase(Vendor vendor, String id, String pw){
		String driver = "", url = "";
		switch (vendor) {
		case ORACLE:
			driver = Values.ORACLE_DRIVER;
			url = Values.ORACLE_URL;
			break;
		case MYSQL:
			driver = Values.MYSQL_DRIVER;
			url = Values.MYSQL_URL;
			break;
		case MSSQL:break;
		case MARIADB:break;
		default:
			break;
		}
		return new Database(driver,url,id,pw);
	}
}
