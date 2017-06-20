package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import com.edu.entity.InfoContentExample.Criteria;
import com.edu.function.UploadBean;
import com.edu.entity.InfoSlide;
import com.edu.service.FileService;
import com.edu.service.InfoSlideService;
import com.edu.util.JsonWithMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/slide")
public class InfoSlideController {
	
	@Autowired
	InfoSlideService infoSlideService;
	
	@Autowired
	FileService fileService;

	//添加轮播图片
	@ResponseBody
	@RequestMapping(value="/addSlide",method=RequestMethod.POST)
	public JsonWithMsg addSlide(HttpServletRequest request){
		if(infoSlideService.addSlide(request)){
			return JsonWithMsg.success();
		}
		
		return JsonWithMsg.fail();
	}
	
	
	@ResponseBody
	@RequestMapping("/getAll")
	public JsonWithMsg getAlllSlides(@RequestParam(value="pn",defaultValue="1") Integer pn) {
		
		PageHelper.startPage(pn,5);//页码以及每页的数据量
		//startPage	后面紧跟的查询就是一个分页查询
		//将数据进行页面信息包装
		List<InfoSlide> slides=infoSlideService.getAll();
		PageInfo page=new PageInfo(slides,5);//第二个参数为连续显示多少页
		
		return JsonWithMsg.success().add("pageInfo", page);
	}
	
	//删除消息
	@ResponseBody
	@RequestMapping(value="/deleteBySlideId/{slideId}",method=RequestMethod.DELETE)
	public JsonWithMsg deleteByConNo(@PathVariable("slideId")Integer slideId) {
		if(infoSlideService.deleteBySlideId(slideId)){
			return JsonWithMsg.success();
		}
		return JsonWithMsg.fail();
	}
}
