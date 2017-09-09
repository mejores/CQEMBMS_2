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
	
	/**
	 * 
	 * @param content
	 * @return
	 */
	public InfoContent getContentById(Integer conId) {
		
		return infoContentMapper.selectByPrimaryKeyWithSlaves(conId);
	}
	
	
	public int addContent(InfoContent content) {
		Date date=new Date();
		content.setPubTime(date);
		//content.setModifyTime(date);
		content.setConNo(UUID.randomUUID().toString());
		
		return infoContentMapper.insertSelective(content);
		
	}
	/**
	 * 删除单个
	 * @param conNo
	 * @return
	 */
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
	
	/**
	 * 批量删除
	 * @return 受影响的行数
	 */
	public int deleteByConNosBatch(List<String> conNosList){
		Criteria criteria;
		//删除主要信息体
		InfoContentExample contentExample=new InfoContentExample();
		criteria=contentExample.createCriteria();
		criteria.andConNoIn(conNosList);
		
		int affected= infoContentMapper.deleteByExample(contentExample);
		
		//删除附件及轮播图
		infoSlaveService.deletebyConNosBatch(conNosList);
		infoSlideService.deletebyConNosBatch(conNosList);
		return affected;
	}
	
	//更新消息
	public boolean updateContent(InfoContent info) {
		info.setModifyTime(new Date());
		if(infoContentMapper.updateByConNoSelective(info)>0){
			return true;
		}
		return false;
		
	}

}
