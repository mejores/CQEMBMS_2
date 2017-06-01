package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import com.edu.entity.InfoContentExample.Criteria;
import com.edu.service.InfoContentService;
import com.edu.service.InfoPlateService;
import com.edu.util.JsonWithMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/content")
@Controller
public class InfoContentController {

	@Autowired
	InfoContentService infoContentService;
	
	@Autowired
	InfoPlateService infoPlateService;
	
	//@RequestMapping("/getAllInfos")
	//public String getAllInfos(@RequestParam(value="pn",defaultValue="1") Integer pn,
			//Model model){
		//PageHelper.startPage(pn,5);//页码以及每页的数据量
		//startPage	后面紧跟的查询就是一个分页查询
		//将数据进行页面信息包装
		//List<InfoContent> infos=infoContentService.getAll();
		//PageInfo page=new PageInfo(infos,5);//第二个参数为连续显示多少页
		//model.addAttribute("pageInfo",page);
		//System.out.println("查询结果："+infos);
		//return "manage";
	//}
	
	@RequestMapping("/getAllInfos")
	@ResponseBody
	public JsonWithMsg getAll(@RequestParam(value="pn",defaultValue="1") Integer pn,
			@RequestParam(value="type",defaultValue="all") String type){
		PageHelper.startPage(pn,5);//页码以及每页的数据量
		//startPage	后面紧跟的查询就是一个分页查询
		//将数据进行页面信息包装
		InfoContentExample info=new InfoContentExample();
		Criteria criteria =info.createCriteria();
		if(type!=null&&!type.equals("all")){
			criteria.andPlateNoEqualTo(type);
		}
		
		List<InfoContent> infos=infoContentService.getAll(info);
		PageInfo page=new PageInfo(infos,5);//第二个参数为连续显示多少页
	
		return JsonWithMsg.success().add("pageInfo", page).add("plate", infoPlateService.getPlate());
	}
	
	//上传word文件
	@RequestMapping("/uploadWebFile")
	@ResponseBody
	public JsonWithMsg uploadWebFile(){
		return JsonWithMsg.success();
	}
	
	
}
