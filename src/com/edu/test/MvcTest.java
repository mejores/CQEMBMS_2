package com.edu.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

/**
 * 使用spring提供的测试功能
 * @author joven
 * @WebAppConfiguration用于自动装配mvc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class MvcTest {
	
	//传入springmvc的ioc
	@Autowired
	WebApplicationContext context;

	//虚拟mvc
	MockMvc mockMvc;
	@Before
	public void initMockMvc(){
		mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception{
		//模拟请求，拿到返回值
		MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/getAllInfos").param("pn", "1")).andReturn();
		MockHttpServletRequest request=result.getRequest();
		PageInfo pi= (PageInfo)request.getAttribute("pageInfo");
		System.out.println("当前页码"+pi.getPageNum());
		System.out.println("总页码"+pi.getPages());
		System.out.println("总记录数"+pi.getTotal());
	
		
		
	}
}
