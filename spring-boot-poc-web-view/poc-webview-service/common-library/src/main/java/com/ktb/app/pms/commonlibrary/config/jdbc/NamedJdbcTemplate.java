package com.ktb.app.pms.commonlibrary.config.jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public interface NamedJdbcTemplate extends NamedParameterJdbcOperations {

    public <T> T query2Object(String sql, Map<String, ?> params, RowMapper<T> rowMapper) throws DataAccessException, Exception;

    public Connection getConnection() throws Exception;

    Long getSequence(String seqName) throws Exception;

    String toPaginationSQL(String sql, long pageNumber, long pageSize);

    long getStartRow(long pageIndex, long pageSize);

    public Long countTotal(String sql, Map<String, ?> params);

    <T> List<T> querySetMaxRows(String sql, Long maxRows, Map<String, ?> params, RowMapper<T> rowMapper);
}
