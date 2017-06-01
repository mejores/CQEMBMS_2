package com.edu.dao;

import com.edu.entity.InfoPlate;
import com.edu.entity.InfoPlateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoPlateMapper {
    long countByExample(InfoPlateExample example);

    int deleteByExample(InfoPlateExample example);

    int deleteByPrimaryKey(Integer plateId);

    int insert(InfoPlate record);

    int insertSelective(InfoPlate record);

    List<InfoPlate> selectByExample(InfoPlateExample example);

    InfoPlate selectByPrimaryKey(Integer plateId);

    int updateByExampleSelective(@Param("record") InfoPlate record, @Param("example") InfoPlateExample example);

    int updateByExample(@Param("record") InfoPlate record, @Param("example") InfoPlateExample example);

    int updateByPrimaryKeySelective(InfoPlate record);

    int updateByPrimaryKey(InfoPlate record);
}