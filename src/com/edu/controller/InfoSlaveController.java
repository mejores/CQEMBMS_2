package com.edu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.InfoSlave;
import com.edu.function.UploadBean;
import com.edu.service.InfoSlaveService;
import com.edu.util.JsonWithMsg;
import com.edu.util.MD5Encoder;


@RequestMapping("/slave")
@Controller
public class InfoSlaveController {
	
	@Autowired
	InfoSlaveService infoSlaveService;
	
	
	//上传附件
	@RequestMapping("/upLoadSlaves")
	@ResponseBody
	public JsonWithMsg upLoadSlaves(HttpServletRequest request,HttpServletResponse response){
		String savePath = request.getServletContext().getRealPath("/")+"upload/slaves"; 
		 File file = new File(savePath);
		 if(!file.exists()){
			 file.mkdir();
		 }
	    String fileName = "";//带扩展名的文件名
	    String filePath = "";//带路径的完整名称
	    String  fileOriginal="";//不带扩展名的文件名
	    //定义返回结果提示对象
	    UploadBean up=null;
	    List<UploadBean> res=new ArrayList<UploadBean>();
	    try {  
	        if (ServletFileUpload.isMultipartContent(request)) {  
	            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);  
	            for (FileItem item : items) {  
	                if (!item.isFormField()) {// 过滤掉表单中非文件域  
	                	  //文件类型
	                	 String fileType = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();
	                	 //文件不带后缀的名称
	                      fileOriginal=item.getName().substring(0, item.getName().length()-fileType.length()-1);
	                      //用于存储的文件名称（不带后缀）
	                      String temp=new MD5Encoder().toMD5(fileOriginal+new Date().getTime());
	                      if(temp!=null&&temp!=""){
	                    	fileName = temp+ "." + fileType; //保存的文件名  
	                      }
	                    //保存的文件路径  （带后缀）
	                     filePath = savePath + "/" + fileName; 
	                      
	                    BufferedInputStream in = new BufferedInputStream(item.getInputStream());// 获得文件输入流  
	                    BufferedOutputStream out = new BufferedOutputStream(  
	                            new FileOutputStream(new File(filePath)));// 获得文件输出流  
	                    Streams.copy(in, out, true);// 开始把文件写到指定的上传文件夹  
		                    up=new UploadBean();
		                    up.setLogName(item.getName());
		                    up.setPhyName(fileName);
		                    res.add(up);
	                    //retMsg = fileOriginal+"."+fileType;  
	                    in.close();  
	                    out.close();
	                   
	                 ;
	                } else {  
	                     //retMsg += "失败:" + new String(item.getString().getBytes("iso-8859-1"),"utf-8");  
	                }  
	            }  
	        }  
	   
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    } 
				
				return JsonWithMsg.success().add("res", res);
	}
	
	//查看附件
	@ResponseBody
	@RequestMapping("/getByConNo/{conNo}")
	public JsonWithMsg getByConNo(@PathVariable("conNo")String conNo){
		if(conNo==null){
			return JsonWithMsg.fail();
		}
		List<InfoSlave> slaves=infoSlaveService.getByConNo(conNo);
		if(slaves.isEmpty()){
			return JsonWithMsg.fail();
		}
		return JsonWithMsg.success().add("slaves",slaves);
	}

}
