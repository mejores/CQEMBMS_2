package com.edu.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.InfoContent;
import com.edu.entity.InfoContentExample;
import com.edu.entity.InfoContentExample.Criteria;
import com.edu.entity.User;
import com.edu.function.UploadBean;
import com.edu.service.FileService;
import com.edu.service.InfoContentService;
import com.edu.service.InfoPlateService;
import com.edu.util.JsonWithMsg;
import com.edu.util.Office2Html;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/content")
@Controller
public class InfoContentController {

	@Autowired
	InfoContentService infoContentService;
	
	@Autowired
	InfoPlateService infoPlateService;
	
	@Autowired
	FileService fileService;
	
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
	public JsonWithMsg uploadWebFile(HttpServletRequest request){
		 UploadBean up= fileService.uploadFIle(request, "webFiles").get(0);
		return JsonWithMsg.success().add("res", up);
	}
	
	//添加消息
	@RequestMapping("/addContent")
	@ResponseBody
	public JsonWithMsg addContent(HttpServletRequest request,HttpSession session,InfoContent content){
		
		
		//开始word转换成html
		String basePath=request.getServletContext()
				.getRealPath("/")+"upload/";
				System.out.println("对象信息为："+content);
				String conHtml= new Office2Html().wordToHtml(basePath+"webFiles/"+content.getConPath(), basePath+"htmlFiles/");
				if(conHtml!=null){
					
					User user= (User)session.getAttribute("user");
					if(user!=null){
						content.setPublisher(user.getRealName());
					}
					
					content.setConHtml(conHtml);
					if(infoContentService.addContent(content)>0){
						return JsonWithMsg.success();
					}
					
				}
				return JsonWithMsg.fail();
	}
	
	//删除消息
	@ResponseBody
	@RequestMapping(value="/deleteContent/{conNo}",method=RequestMethod.DELETE)
	public JsonWithMsg deleteContent(@PathVariable("conNo")String conNo){
		if(infoContentService.deleteContentbyConNo(conNo)){
			return JsonWithMsg.success();
		}
		return JsonWithMsg.fail();
	}
	
}
