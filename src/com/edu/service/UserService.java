package com.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.UserMapper;
import com.edu.entity.User;
import com.edu.entity.UserExample;
import com.edu.entity.UserExample.Criteria;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User getUser(User user) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		criteria.andUserPassEqualTo(user.getUserPass());
		try {
			return userMapper.selectByExample(userExample).get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		
		
	}
	public Boolean update(User user){
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		
		if(user.getUserPass()!=null){
			criteria.andUserPassEqualTo(user.getUserPass());
		}
		if(user.getRealName()!=null){
			criteria.andRealNameEqualTo(user.getRealName());
		}
		if(user.getLastLoginTime()!=null){
			criteria.andLastLoginTimeEqualTo(user.getLastLoginTime());
		}
		
		if(userMapper.updateByPrimaryKeySelective(user)>0){
			return true;
		}
		return false;
		
	}
	
}
