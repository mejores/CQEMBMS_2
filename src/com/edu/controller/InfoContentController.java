package com.edu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.edu.entity.InfoSlide;
import com.edu.entity.User;
import com.edu.function.UploadBean;
import com.edu.service.FileService;
import com.edu.service.InfoContentService;
import com.edu.service.InfoPlateService;
import com.edu.service.InfoSlideService;
import com.edu.util.JsonWithMsg;
import com.edu.util.Office2Html;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.net.httpserver.Authenticator.Success;

@RequestMapping("/content")
@Controller
public class InfoContentController {

	@Autowired
	InfoContentService infoContentService;
	
	@Autowired
	InfoPlateService infoPlateService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	InfoSlideService infoSlideService;
	
	@ResponseBody
	@RequestMapping("/getAllInfosForIndex")
	public JsonWithMsg getAllInfosToRequest(){
		Map<String,Object>infoMap=new HashMap<>();
		PageHelper.startPage(1,9);//页码以及每页的数据量
		//startPage	后面紧跟的查询就是一个分页查询
		//将数据进行页面信息包装
		InfoContentExample info;
		Criteria criteria;
		List<InfoContent> infos;
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("12");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist12",infos);

		PageHelper.startPage(1,7);//页码以及每页的数据量
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("21");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist21",infos);
		
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("22");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist22",infos);
		
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("23");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist23",infos);
		
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("31");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist31",infos);
		
		info=new InfoContentExample();
		criteria=info.createCriteria();
		criteria.andPlateNoEqualTo("32");
		infos=infoContentService.getAll(info);
		infoMap.put("infolist32",infos);
		
		//轮播图片
		List<InfoSlide> slidelist=infoSlideService.getTopNSlide(5);
		//infoMap.put("slidelist", slidelist);
		return JsonWithMsg.success().add("infos", infoMap).add("slidelist", slidelist);
	}
	
	//加载消息列表
	@RequestMapping("/loadList")
	public String LoadList(@RequestParam(value="plate",defaultValue="12")String plate,
			@RequestParam(value="pn",defaultValue="1")Integer pn,
			Model model){
		PageHelper.startPage(pn,20);
		InfoContentExample infoe=new InfoContentExample();
		Criteria criteria=infoe.createCriteria();
		criteria.andPlateNoEqualTo(plate);
		List<InfoContent> infos=infoContentService.getAll(infoe);
		PageInfo page=new PageInfo(infos,5);//第二个参数为连续显示多少页
		model.addAttribute("infolist",page );
		model.addAttribute("plate",plate);
		return "list";
	}
	
	//阅读消息
	@RequestMapping("/loadDetail.do/{conId}")
	public String loadDetail(@PathVariable("conId")Integer conId,Model model){

		model.addAttribute("detail", infoContentService.getContentById(conId));
		return "/WEB-INF/detail";
	}
	
	@RequestMapping("/getAllInfos")
	@ResponseBody
	public JsonWithMsg getAll(@RequestParam(value="pn",defaultValue="1") Integer pn,
			@RequestParam(value="type",defaultValue="all") String type,
			@RequestParam(value="pageSize",defaultValue="5") Integer pageSize,
			@RequestParam(value="contentsForSearch",defaultValue="") String contentsForSearch){
		PageHelper.startPage(pn,pageSize);//页码以及每页的数据量
		//startPage	后面紧跟的查询就是一个分页查询
		//将数据进行页面信息包装
		InfoContentExample info=new InfoContentExample();
		Criteria criteria =info.createCriteria();
		if(type!=null&&!type.equals("all")){
			criteria.andPlateNoEqualTo(type);
		}
		if(contentsForSearch!=null&&!contentsForSearch.equals("")){
			criteria.andConTitleLike(contentsForSearch);
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
					
					User user= (User)session.getAttribute("userInfo");
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
	
	/**
	 * 单个/批量删除
	 * @param conNo
	 * @return JsonWithMsg
	 */
	@ResponseBody
	@RequestMapping(value="/deleteContent/{conNo}",method=RequestMethod.DELETE)
	public JsonWithMsg deleteContent(@PathVariable("conNo")String conNos){
		//如果包含“~”符号表示批量删除
		if(conNos.contains("~")){
			String[] conNosArray=conNos.split("~");
			List<String> conNosList=new ArrayList<String>();
			for(String conNo:conNosArray){
				conNosList.add(conNo);
			}
			
			int affected=infoContentService.deleteByConNosBatch(conNosList);
			if(affected>0){
				return JsonWithMsg.success().setMsg("删除"+affected+"条消息成功");
			}
			
		}else{//否则为单个删除
			if(infoContentService.deleteContentbyConNo(conNos)){
				return JsonWithMsg.success().setMsg("删除消息成功");
			}
		}
		
		return JsonWithMsg.fail().setMsg("删除消息失败");
	}
	
	//修改消息
	@ResponseBody
	@RequestMapping(value="/updateContent/{conNo}",method=RequestMethod.PUT)
	public JsonWithMsg updateContent(InfoContent info,HttpSession session){
		//infoContentService
		User user=(User)session.getAttribute("userInfo");
		if(user!=null){
			info.setEditor(user.getRealName());
		}
		
		if(infoContentService.updateContent(info)){
			return JsonWithMsg.success();
		}
		
		return JsonWithMsg.fail();
	}
	
}
