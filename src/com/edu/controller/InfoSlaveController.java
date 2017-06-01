package com.edu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.util.MD5Encoder;


@RequestMapping("/slave")
@Controller
public class InfoSlaveController {
	
	//上传文件
	@RequestMapping("/upLoadSlaves")
	public String upLoadSlaves(HttpServletRequest request,HttpServletResponse response){
		//System.out.println("上传附件");
		 // request.setCharacterEncoding("utf-8");
			//response.setContentType("textml;charset=utf-8");
		//String savePath = request.getServletContext().getRealPath("/wordFiles/");//存储路径  
		//String savePath = request.getContextPath()+"/wordFiles/";
		//String savePath=this.getServletContext().getRealPath("wordFiles");
		String path = request.getSession().getServletContext().getRealPath("/")+"CQEMBMS_Upload"; 
		   String savePath=request.getSession().getServletContext().getRealPath("/")+"slavefiles"; 
		    System.out.println("路径为："+path);
		//System.out.println(savePath);
		// WordReading wr=new WordReading();
    String retMsg = "";//定义将返回给客户端的信息  
    String fileName = "";//带扩展名的文件名
    String filePath = "";//带路径的完整名称
    String  fileOriginal="";//不带扩展名的文件名
    //JsonArray jsarray=new JsonArray();
    //JsonObject lan=null;
    try {  
        if (ServletFileUpload.isMultipartContent(request)) {  
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);  
            for (FileItem item : items) {  
                if (!item.isFormField()) {// 过滤掉表单中非文件域  
                	 String fileType = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();//文件类型
                      fileOriginal=item.getName().substring(0, item.getName().length()-fileType.length()-1);
                      String temp=new MD5Encoder().toMD5(fileOriginal+new Date().getTime());
                      if(temp!=null&&temp!=""){
                    	fileName = temp+ "." + fileType; //保存的文件名  
                      }
                     
                     filePath = savePath + "/" + fileName; //保存的文件路径  
                      
                    BufferedInputStream in = new BufferedInputStream(item.getInputStream());// 获得文件输入流  
                    BufferedOutputStream out = new BufferedOutputStream(  
                            new FileOutputStream(new File(filePath)));// 获得文件输出流  
                    Streams.copy(in, out, true);// 开始把文件写到指定的上传文件夹  
                    retMsg = fileOriginal+"."+fileType;  
                    in.close();  
                    out.close();
                    //lan=new JsonObject();
                    //lan.addProperty("retMsg", retMsg);
                    //lan.addProperty("slavePath", fileName);
                    //jsarray.add(lan);
              //      String htmlfile=request.getServletContext().getRealPath("/htmlfiles/")+fileOriginal;
                 ;
                } else {  
                     retMsg += "失败:" + new String(item.getString().getBytes("iso-8859-1"),"utf-8");  
                }  
            }  
        }  
        response.setContentType("text/html;charset=utf8"); 
        /**
         * 传回的值要包括逻辑名字（页面显示）和物理名字（数据库存储）;
         */
        
/*          lan.addProperty("retMsg", retMsg);
        lan.addProperty("slavePath", fileName);*/
        PrintWriter pw = response.getWriter();  
        pw.print("d");  
        pw.flush();  
        pw.close();  
    } catch (Exception e) {  
        e.printStackTrace();  
    }
		
		return null;
	}

}
