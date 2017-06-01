package com.edu.dao;

import com.edu.entity.InfoSlide;
import com.edu.entity.InfoSlideExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoSlideMapper {
    long countByExample(InfoSlideExample example);

    int deleteByExample(InfoSlideExample example);

    int deleteByPrimaryKey(Integer slideId);

    int insert(InfoSlide record);

    int insertSelective(InfoSlide record);

    List<InfoSlide> selectByExample(InfoSlideExample example);

    InfoSlide selectByPrimaryKey(Integer slideId);

    int updateByExampleSelective(@Param("record") InfoSlide record, @Param("example") InfoSlideExample example);

    int updateByExample(@Param("record") InfoSlide record, @Param("example") InfoSlideExample example);

    int updateByPrimaryKeySelective(InfoSlide record);

    int updateByPrimaryKey(InfoSlide record);
}