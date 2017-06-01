package com.edu.dao;

import com.edu.entity.InfoSlave;
import com.edu.entity.InfoSlaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoSlaveMapper {
    long countByExample(InfoSlaveExample example);

    int deleteByExample(InfoSlaveExample example);

    int deleteByPrimaryKey(Integer slaveId);

    int insert(InfoSlave record);

    int insertSelective(InfoSlave record);

    List<InfoSlave> selectByExample(InfoSlaveExample example);

    InfoSlave selectByPrimaryKey(Integer slaveId);

    int updateByExampleSelective(@Param("record") InfoSlave record, @Param("example") InfoSlaveExample example);

    int updateByExample(@Param("record") InfoSlave record, @Param("example") InfoSlaveExample example);

    int updateByPrimaryKeySelective(InfoSlave record);

    int updateByPrimaryKey(InfoSlave record);
}