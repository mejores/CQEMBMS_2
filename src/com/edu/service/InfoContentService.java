package com.edu.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoContentMapper;
import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import com.edu.entity.InfoContentExample.Criteria;

@Service
public class InfoContentService {
	
	@Autowired
	private InfoContentMapper infoContentMapper;
	
	@Autowired
	private InfoSlaveService infoSlaveService;
	
	@Autowired
	private InfoSlideService infoSlideService;
	
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
		Criteria criteria;
		//删除主要信息体
		InfoContentExample contentExample=new InfoContentExample();
		criteria=contentExample.createCriteria();
		criteria.andConNoEqualTo(conNo);
		if(infoContentMapper.deleteByExample(contentExample)<1){
			return false;
		}
		
		infoSlaveService.deleteByConNo(conNo);
		infoSlideService.deleteByConNo(conNo);
		return true;
	}

}
