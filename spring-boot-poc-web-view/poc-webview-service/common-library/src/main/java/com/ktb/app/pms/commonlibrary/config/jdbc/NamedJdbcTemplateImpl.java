package com.ktb.app.pms.commonlibrary.config.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class NamedJdbcTemplateImpl extends AbstractNamedJdbcTemplate implements NamedJdbcTemplate {

    private static final String PRE_COUNT_SQL = "select count(1) as total_row from (";
    private static final String SUF_COUNT_SQL = ") c ";

    public NamedJdbcTemplateImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public <T> T query2Object(String sql, Map<String, ?> params, RowMapper<T> rowMapper) {
        List<T> lists = query(sql, params, rowMapper);
        if (lists == null || lists.size() <= 0) {
            return null;
        }

        return lists.get(0);
    }

    @Override
    public Long getSequence(String seqName) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder bf = new StringBuilder();

        seqName = seqName.toUpperCase().replace(".NEXTVAL", "");

        bf.append("select ").append(seqName).append(".nextval as next_val from dual ");
        List<Long> nextVal = query(bf.toString(), param, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getLong("next_val");
            }
        });

        return (nextVal != null && !nextVal.isEmpty()) ? nextVal.get(0) : null;
    }

    @Override
    public String toPaginationSQL(String sql, long pageIndex, long pageSize) {
        long startRow = getStartRow(pageIndex, pageSize);
        long endRow = (pageIndex) * pageSize;

        StringBuilder bf = new StringBuilder();
        bf.append(" SELECT T3.* FROM (");
        bf.append(" SELECT T2.*,  rownum row_No FROM (");
        bf.append(" SELECT T1.* FROM (");
        bf.append(sql);
        bf.append(" ) T1 ) T2 ) T3 WHERE T3.row_No BETWEEN ").append(startRow).append(" and ").append(endRow);

        return bf.toString();
    }

    @Override
    public long getStartRow(long pageIndex, long pageSize) {
        return ((pageIndex - 1) * pageSize) + 1;
    }

    @Override
    public Long countTotal(String sql, Map<String, ?> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(PRE_COUNT_SQL);
        sb.append(sql);
        sb.append(SUF_COUNT_SQL);

        return this.queryForObject(sb.toString(), params, Long.class);
    }

    @Override
    public <T> List<T> querySetMaxRows(String sql, Long maxRows, Map<String, ?> params, RowMapper<T> rowMapper) {

        StringBuilder bf = new StringBuilder();
        bf.append(" SELECT * FROM (");
        bf.append(sql);
        bf.append(" )  WHERE ROWNUM <= ").append(maxRows);

        return query(bf.toString(), params, rowMapper);
    }
}
