package com.edu.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Service;

import com.edu.function.ContextPath;
import com.edu.function.UploadBean;
import com.edu.util.JsonWithMsg;
import com.edu.util.MD5Encoder;

@Service
public class FileService {

	//请求与子文件夹名称
	public List<UploadBean> uploadFIle( HttpServletRequest request,String subDir){
		StringBuilder savePath=new StringBuilder(ContextPath.path+subDir);
		//String savePath = request.getServletContext().getRealPath("/")+"upload/slaves"; 
		 File file = new File(savePath.toString());
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
				
				return res;
	}
	
	
}
