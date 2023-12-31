package com.web.util;

import java.sql.ResultSet;

/**
 * 数据库表与实体类映射接口
 */
public interface RowMapper {

    public Object mapRow(ResultSet rs) throws Exception;

}
