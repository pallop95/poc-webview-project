package com.ktb.app.pms.commonlibrary.config.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbcInsertTemplate extends SimpleJdbcInsert{

	 public SimpleJdbcInsertTemplate(DataSource dataSource) {
	        super(dataSource);
	    }
}
