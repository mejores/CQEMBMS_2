package com.edu.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoContentMapper;
import com.edu.dao.InfoSlaveMapper;
import com.edu.dao.InfoSlideMapper;
import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import com.edu.entity.InfoSlideExample;
import com.edu.entity.InfoContentExample.Criteria;
import com.edu.util.Office2Html;

@Service
public class InfoContentService {
	
	@Autowired
	private InfoContentMapper infoContentMapper;
	
	@Autowired
	private InfoSlaveMapper infoSlaveMapper;
	
	@Autowired
	private InfoSlideMapper infoSlideMapper;
	
	public List<InfoContent> getAll(InfoContentExample info){
		//return infoContentMapper.selectByExampleWithSlaves(null);
		return infoContentMapper.selectByExample(info);
	}
	
	public int addContent(InfoContent content) {
		Date date=new Date();
		content.setPubTime(date);
		//content.setModifyTime(date);
		content.setConNo(UUID.randomUUID().toString());
		
		return infoContentMapper.insertSelective(content);
		
	}
	
	public boolean deleteContentbyConNo(String conNo) {
		//删除主要信息体
		//infoContentMapper.deleteByPrimaryKey()
		
		//删除关联的图片
		//InfoSlideExample slideExample=new InfoSlideExample();
		//Criteria criteria =slideExample.createCriteria();
		//criteria.andConNoEqualTo(conNo);
		//infoSlideMapper.deleteByExample(new InfoSlideExample());
		//删除关联的附件
		System.out.println("调用删除");
		//删除所有实体内容
		return true;
	}

}
