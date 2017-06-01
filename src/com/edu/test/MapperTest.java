package com.edu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.dao.InfoContentMapper;
import com.edu.entity.InfoContent;

/**
 * @ContextConfiguration指定配置配置文件的位置。
 * @RunWith指定用什么来运行
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	InfoContentMapper infoContentMapper;

	@Test
	public void TestCRUD(){
		//通常情况下如下：
		/*//1、创建IOC 
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获得mapper
		   //selectByPrimaryKeyWithSlave 
		ioc.getBean(InfoContentMapper.class);*/
		//--但是spring的项目最好用spring的单元测试
		System.out.println(infoContentMapper);
		InfoContent info=new InfoContent();
		info.setConTitle("渝北区考察");
		info.setAuthor("朱逸群");
		info.setConNo("45345");
		info.setPlateNo("23s");
		int s= infoContentMapper.insertSelective(info);
		System.out.println(s);
	}
}
