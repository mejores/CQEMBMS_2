package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoContentMapper;
import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;

@Service
public class InfoContentService {
	
	@Autowired
	private InfoContentMapper infoContentMapper;
	
	public List<InfoContent> getAll(InfoContentExample info){
		//return infoContentMapper.selectByExampleWithSlaves(null);
		return infoContentMapper.selectByExample(info);
	}

}
