package com.ktb.app.pms.commonlibrary.config.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktb.app.pms.commonlibrary.config.jdbc.NamedJdbcTemplate;
import com.ktb.app.pms.commonlibrary.config.jdbc.SimpleJdbcInsertTemplate;
import com.ktb.app.pms.commonlibrary.util.Validate;

public class BaseRepository
{

    @Autowired
    protected NamedJdbcTemplate namedJdbcTemplate;

    @Autowired
    SimpleJdbcInsertTemplate simpleJdbcInsertTemplate;

    public void setNamedJdbcTemplate(NamedJdbcTemplate template) {
        this.namedJdbcTemplate = template;
    }

    public NamedJdbcTemplate getNamedJdbcTemplate() {
        return namedJdbcTemplate;
    }

    public SimpleJdbcInsertTemplate getSimpleJdbcInsertTemplate() {
        return simpleJdbcInsertTemplate;
    }

    public void setSimpleJdbcInsertTemplate(SimpleJdbcInsertTemplate simpleJdbcInsertTemplate) {
        this.simpleJdbcInsertTemplate = simpleJdbcInsertTemplate;
    }

    public Long getNextSeq(String keyField, String tableName) throws Exception {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("SELECT MAX(").append(keyField).append(") "
        		+ "AS ").append(keyField)
        		.append(" FROM ").append(tableName);

        List<Long> ids = getNamedJdbcTemplate().query(sbSql.toString(), (rs, rowNum) -> rs.getLong(keyField));

        if(Validate.empty(ids)) {
        	return 1L;
        }

        return ids.get(0) + 1L;
    }
}
