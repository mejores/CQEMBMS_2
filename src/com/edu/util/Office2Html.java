package com.edu.util;

import java.io.File;
import java.util.UUID;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


public class Office2Html {

	// 8 代表word保存成html  
    public static final int WORD_HTML = 8;   
  
   /* public static void main(String[] args) {  
    	String tName="关于开放就业系派遣信息录入权限的通知(1)";
        String docfile = "C:\\Users\\Air\\Desktop\\"+tName+".docx";  
        System.out.println(System.getProperty("user.dir"));
        String htmlfile = System.getProperty("user.dir")+"/htmlfiles/"+tName+".html";  
        WordReading.wordToHtml(docfile, htmlfile);  
    } */ 
      
    /**   
     * WORD转HTML   
     * @param docfile WORD文件全路径   
     * @param htmlfile 转换后HTML存放路径   
     */    
    public String wordToHtml(String docfile, String htmlDir)     
    {     
    	File file = new File(htmlDir);
    	 if(!file.exists()){
			 file.mkdir();
		 }
    	 String htmlfile=htmlDir+UUID.randomUUID().toString().substring(0, 16)+".html";
    	//String htmlfile=request.getContextPath();
        // 启动word应用程序(Microsoft Office Word 2003)  
        ActiveXComponent app = new ActiveXComponent("Word.Application");  
        System.out.println("*****正在转换...*****");  
        try    
        {     
            // 设置word应用程序不可见    
            app.setProperty("Visible", new Variant(false));    
            // documents表示word程序的所有文档窗口，（word是多文档应用程序）  
            Dispatch docs = app.getProperty("Documents").toDispatch();    
            // 打开要转换的word文件  
            Dispatch doc = Dispatch.invoke(     
                    docs,     
                    "Open",     
                    Dispatch.Method,     
                    new Object[] { docfile, new Variant(false),   
                            new Variant(true) }, new int[1]).toDispatch();     
            // 作为html格式保存到临时文件  
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {     
                    htmlfile, new Variant(WORD_HTML) }, new int[1]);     
            // 关闭word文件  
            Dispatch.call(doc, "Close", new Variant(false));     
        }     
        catch (Exception e)     
        {     
            e.printStackTrace();
            return null;
        }     
        finally    
        {     
            //关闭word应用程序  
            app.invoke("Quit", new Variant[] {});     
        }   
        System.out.println("*****转换完毕********"); 
        return htmlfile;
    }  
	
}
