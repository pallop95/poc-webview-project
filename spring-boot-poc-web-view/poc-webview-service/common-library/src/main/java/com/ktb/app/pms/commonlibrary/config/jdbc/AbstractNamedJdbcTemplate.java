package com.ktb.app.pms.commonlibrary.config.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractNamedJdbcTemplate extends NamedParameterJdbcTemplate {

  public AbstractNamedJdbcTemplate(DataSource dataSource) {
    super(dataSource);
  }

  public Connection getConnection() throws Exception {

    return super.getJdbcTemplate().getDataSource().getConnection();
  }
}
