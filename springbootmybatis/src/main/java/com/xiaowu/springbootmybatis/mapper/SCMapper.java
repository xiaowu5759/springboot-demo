package com.xiaowu.springbootmybatis.mapper;

import com.xiaowu.springbootmybatis.dao.SC;
import com.xiaowu.springbootmybatis.dao.SCExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

//@Component("scMapper")
//@Mapper
public interface SCMapper {
    long countByExample(SCExample example);

    int deleteByExample(SCExample example);

    int deleteByPrimaryKey(Long scId);

    int insert(SC record);

    int insertSelective(SC record);

    List<SC> selectByExample(SCExample example);

    SC selectByPrimaryKey(Long scId);

    int updateByExampleSelective(@Param("record") SC record, @Param("example") SCExample example);

    int updateByExample(@Param("record") SC record, @Param("example") SCExample example);

    int updateByPrimaryKeySelective(SC record);

    int updateByPrimaryKey(SC record);
}