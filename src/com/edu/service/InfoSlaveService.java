package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoSlaveMapper;
import com.edu.entity.InfoSlave;
import com.edu.entity.InfoSlaveExample;
import com.edu.entity.InfoSlaveExample.Criteria;
import com.edu.function.ContextPath;
import com.edu.util.DeleteFile;

@Service
public class InfoSlaveService {

	@Autowired
	InfoSlaveMapper infoSlaveMapper;
	
	public boolean deleteByConNo(String conNo) {
		InfoSlaveExample slaveExample=new InfoSlaveExample();
		Criteria criteria=slaveExample.createCriteria();
		criteria.andConNoEqualTo(conNo);
		if(infoSlaveMapper.deleteByExample(slaveExample)<1){
			return false;
		}
		try {
			List<InfoSlave> slaveList=infoSlaveMapper.selectByExample(slaveExample);
			//删除实体文件
			for(InfoSlave sla:slaveList){
				if(sla.getPhyName().trim().length()>0){
					new DeleteFile().delete(ContextPath.path+"slaves/"+sla.getPhyName());
				}
			}
			
				
		} catch (NullPointerException ne) {
			
		}
		
		
		return true;
	}
	
	public int deletebyConNosBatch(List<String> conNosList){
		
		InfoSlaveExample slaveExample=new InfoSlaveExample();
		Criteria criteria=slaveExample.createCriteria();
		criteria.andConNoIn(conNosList);
		int affected= infoSlaveMapper.deleteByExample(slaveExample);
		
		try {
			List<InfoSlave> slaveList=infoSlaveMapper.selectByExample(slaveExample);
			//删除实体文件
			for(InfoSlave sla:slaveList){
				if(sla.getPhyName().trim().length()>0){
					new DeleteFile().delete(ContextPath.path+"slaves/"+sla.getPhyName());
				}
			}
			
				
		} catch (NullPointerException ne) {
			System.out.println("批量删除附件实体文件失败！");
		}
		
		return affected;
	}
		
	
	
	//根据conNo查询附件
	public List<InfoSlave> getByConNo(String conNo) {
		return infoSlaveMapper.selectByConNo(conNo);
	}
}
