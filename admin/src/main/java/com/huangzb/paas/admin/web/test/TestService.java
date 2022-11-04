package com.huangzb.paas.admin.web.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestService {

    @Select("${sql}")
    Object testSQL(String sql);
}
