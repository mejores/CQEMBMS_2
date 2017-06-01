package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoPlateMapper;
import com.edu.entity.InfoPlate;

@Service
public class InfoPlateService {

	@Autowired
	private InfoPlateMapper infoPlateMapper;
	
	public List<InfoPlate> getPlate(){
		return infoPlateMapper.selectByExample(null);
	}
}
