package com.edu.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InfoSlideMapper;
import com.edu.entity.InfoSlave;
import com.edu.entity.InfoSlaveExample;
import com.edu.entity.InfoSlide;
import com.edu.entity.InfoSlideExample;
import com.edu.entity.InfoSlideExample.Criteria;
import com.edu.function.ContextPath;
import com.edu.util.DeleteFile;
import com.edu.util.MD5Encoder;

@Service
public class InfoSlideService {
	
	@Autowired
	InfoSlideMapper infoSlideMapper;

	
	public boolean addSlide(HttpServletRequest request) {
		
		InfoSlide slid=this.upLoadSlide(request);
		if(infoSlideMapper.insert(slid)>0){
			return true;
		}
		return false;
	}
	
	public List<InfoSlide> getAll() {
		return infoSlideMapper.selectByExample(null);
	}
	
	//按外键“消息编号删除”
	public boolean deleteByConNo(String conNo) {
		InfoSlideExample slideExample=new InfoSlideExample();
		Criteria criteria=slideExample.createCriteria();
		criteria.andConNoEqualTo(conNo);
		if(infoSlideMapper.deleteByExample(slideExample)<1){
			
			return false;
		}
		
		try {
			List<InfoSlide>slidelist=infoSlideMapper.selectByExample(slideExample);
			//删除实体文件
			for(InfoSlide sli:slidelist){
				if(sli.getImgPath().trim().length()>0){
					new DeleteFile().delete(ContextPath.path+"slides/"+sli.getImgPath());
				}
			}
			
				
		} catch (NullPointerException ne) {
			
		}
		
		return true;
	}
	
	//按主键删除
	public boolean deleteBySlideId(Integer slideId) {
		InfoSlideExample slideExample=new InfoSlideExample();
		Criteria criteria=slideExample.createCriteria();
		criteria.andSlideIdEqualTo(slideId);
		if(infoSlideMapper.deleteByPrimaryKey(slideId)<1){
			
			return false;
		}
		
		try {
			InfoSlide slide=infoSlideMapper.selectByExample(slideExample).get(0);
			//删除实体文件
			if(slide.getImgPath().trim().length()>0){
				new DeleteFile().delete(ContextPath.path+"slides/"+slide.getImgPath());
			}
				
		} catch (IndexOutOfBoundsException iobe) {
			
		}
		
		return true;
	}
	
	//上传轮播图片，由于前端用formdata作为载体，所以不能直接获取参数
	public InfoSlide upLoadSlide(HttpServletRequest request) {
		//请求与子文件夹名称
			StringBuilder savePath=new StringBuilder(ContextPath.path+"slides");
			//String savePath = request.getServletContext().getRealPath("/")+"upload/slaves"; 
			 File file = new File(savePath.toString());
			 if(!file.exists()){
				 file.mkdir();
			 }
		    String fileName = "";//带扩展名的文件名
		    String filePath = "";//带路径的完整名称
		    String  fileOriginal="";//不带扩展名的文件名
		    //定义返回结果提示对象
		    InfoSlide slide=new InfoSlide();
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
			                    
			                    slide.setImgPath(fileName);
		                    //retMsg = fileOriginal+"."+fileType;  
		                    in.close();  
		                    out.close();
		                   
		                 ;
		                } else {  
		                	switch (new String(item.getFieldName())){
	                    	case "conNo": slide.setConNo(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));break;
	                    	case "imgCon": slide.setImgCon(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));break;
	                    	case "imgComment":slide.setComment(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));break;
	                    	case "slideId":if(item.getString().getBytes("iso-8859-1")!=null){
	                    		slide.setSlideId(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"),"utf-8")));
	                    		};break;
	                    		
	                    	}
		                }  
		            }  
		        }  
		   
			    } catch (Exception e) {
			    	e.printStackTrace();
			    	return null;
			         
			    } 
					
					return slide;
		}
	
	/**
	 * 批量删除轮播图
	 * @param conNosList
	 */

	public int deletebyConNosBatch(List<String> conNosList) {
		InfoSlideExample slideExample=new InfoSlideExample();
		Criteria criteria=slideExample.createCriteria();
		criteria.andConNoIn(conNosList);
		int affected= infoSlideMapper.deleteByExample(slideExample);
		
		try {
			List<InfoSlide> slideList=infoSlideMapper.selectByExample(slideExample);
			//删除实体文件
			for(InfoSlide sli:slideList){
				if(sli.getImgPath().trim().length()>0){
					new DeleteFile().delete(ContextPath.path+"slides/"+sli.getImgPath());
				}
			}
				
		} catch (NullPointerException ne) {
			System.out.println("批量删除轮播图实体文件失败！");
		}
		
		return affected;
		
	}

	//修改轮播图--
	public boolean updateBySlideId(HttpServletRequest request) {
		InfoSlide slide=upLoadSlide(request);
		if(slide.getSlideId()!=null&&!slide.getSlideId().equals("")){
			if(slide.getImgPath()!=null&&!slide.getImgPath().equals("")){
				String oldPath=infoSlideMapper.selectByPrimaryKey(slide.getSlideId()).getImgPath();
				//删除旧的实体文件
				try {
						new DeleteFile().delete(ContextPath.path+"slides/"+oldPath);

						
				} catch (IndexOutOfBoundsException iobe) {
					System.out.println("修改-删除实体文件失败！");
				}
			}
		}
		if(slide!=null&&slide.getSlideId()!=null&&!slide.getSlideId().equals("")){
			if(infoSlideMapper.updateByPrimaryKeySelective(slide)>0){
				return true;
			}
		
			
		}
		return false;
	}
		
	}

