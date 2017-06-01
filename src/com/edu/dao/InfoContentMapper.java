package com.edu.dao;

import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoContentMapper {
    long countByExample(InfoContentExample example);

    int deleteByExample(InfoContentExample example);

    int deleteByPrimaryKey(Integer conId);

    int insert(InfoContent record);

    int insertSelective(InfoContent record);

    List<InfoContent> selectByExample(InfoContentExample example);

    InfoContent selectByPrimaryKey(Integer conId);
    
    List<InfoContent> selectByExampleWithSlaves(InfoContentExample example);

    InfoContent selectByPrimaryKeyWithSlave(Integer conId);

    int updateByExampleSelective(@Param("record") InfoContent record, @Param("example") InfoContentExample example);

    int updateByExample(@Param("record") InfoContent record, @Param("example") InfoContentExample example);

    int updateByPrimaryKeySelective(InfoContent record);

    int updateByPrimaryKey(InfoContent record);
}