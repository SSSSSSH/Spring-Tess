package com.sh.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface test {


    @Select(value = "select id from test where name = #{name}")
    String getId(@Param("name")String name);

}



