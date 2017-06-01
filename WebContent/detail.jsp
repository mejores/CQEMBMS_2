<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%String path=request.getContextPath();
      String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
    %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>详情页 - 重庆教育督导网</title>
    <meta name="keywords" content="重庆教育督导，重庆市政府教育督导室">
    <meta name="description" content="重庆教育督导网，重庆市政府教育督导室主办。">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/global.css" rel="stylesheet" type="text/css">
    <link href="static/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="favicon.ico">
    <script>
   
    //var $current = $("#article-id");
    //$current.find("img")
    //$("#article-id").children("img").each(function(){
        //$(this).width();//就是他的宽度
       // $(this).$("#imgId")[0].src
      //  alert("5644");
           // $(this).attr('src',"htmlfiles"+$(this).src)
   // });
   
    </script>
</head>
<body >
<!-- 公共顶部开始 -->
<div id="bg-top" class="bgt-hide2">
    <div id="bg-top-ct" data-bgnum="1" style="background-image:url(static/images/bg-top0.jpg);"><!-- data-bgnum为切换数量  --></div>
    <div id="head">
        <div id="nav">
            <div class="nav-list">
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                   <c:if test="${requestScope.info.plate_name=='督导动态'}">
                     <li class="active"><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                    <c:if test="${requestScope.info.plate_name=='区县信息'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li class="active"><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='督导报告'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li ><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li class="active"><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='督导研究'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li  class="active"><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='组织机构'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li  class="active"><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='政策法规'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li  class="active"><a href="#">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- 公共顶部结束 -->


<!-- 首页：各板块内容开始 -->
<div class="container bulk-content">
    <div class="row">
        <div class="col-sm-4 p-0">
            <!-- 菜单导航 -->
            <div class="list-box m-t0 left-menu">
                <div class="head-line">
                    <h3>教育督导</h3>
                </div>
                <ul class="list-unstyled list-menu">
                   <!--  <li><a href="index.jsp">首页</a></li> -->
                    <c:if test="${requestScope.info.plate_name=='督导动态'}">
                     <li class="active"><a href="#">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                    <c:if test="${requestScope.info.plate_name=='区县信息'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li class="active"><a href="#">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='督导报告'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li ><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li class="active"><a href="#">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='督导研究'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li  class="active"><a href="#">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='组织机构'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li  class="active"><a href="#">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.info.plate_name=='政策法规'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li  class="active"><a href="#">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                </ul>
            </div>
            <div class="h-10"></div>
            <!-- 热点资讯 -->
            <div class="list-box m-t0 hot-news">
                <div class="head-line">
                    <h3>热点资讯</h3>
                </div>
                <ul class="list-unstyled list-article">
                                    <c:forEach var="hotNews" items="${requestScope.hotNewslist}">
						<li>
							<div class="article-title">
								<a href="detailLoad.do?urlstring=${hotNews.con_id}&&">
								${hotNews.con_title}</a>	</div>
							</li>
						</c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-sm-8 p-0 p-l5">
            <div class="list-box m-t0 right-article-detail">
            <!-- start -->
                <!-- 当前位置 -->
                <div class="position text-muted">
                    当前位置：
                    <a href="index.jsp">首页</a>
                    >
                    <a href="list.html">${requestScope.info.plate_name}</a>
                    >
                    <span>正文</span>
                </div>
                <!-- 标题 -->
                <h1 class="article-title">${requestScope.info.con_title}</h1>
                 <c:if test="${requestScope.info.sub_title!=null}">
                    <h1 class="article-sub_title">——${requestScope.info.sub_title}</h1>
                   </c:if>
               
                <!-- 信息 -->
                <div class="article-info ta-c text-muted fs-12">
                    <span>发布者：${requestScope.info.publisher}</span>
                    &emsp;&emsp;
                    <span>发布时间：${requestScope.info.pub_time}</span>
                    &emsp;&emsp;
                    <span>阅读：${requestScope.info.visit_count}</span>
                </div>
                <hr>
                <!-- 正文 -->
                
                <div class="article-content" id="article-id">
          
<%--                  <%System.out.print(basePath+"htmlfiles/关于开放就业系统2017届毕业生签约派遣信息录入权限的通知(1).html"); %> --%>
              <jsp:include page="htmlfiles/${requestScope.info.con_HTML}" />   
           <div style="float:right"> <a style="color:#8119d7" href="fileDownload.do?durl=${requestScope.info.con_id}&&type=con">下载本页内容</a></div><hr />
           <c:if test="${requestScope.slavelist!=null}">下载附件：</c:if>
           
           <c:forEach var="slave" items="${requestScope.slavelist}">
							<div style="float:right;"> <a style="color:#199cd7" href="fileDownload.do?durl=${slave.slave_id}&&type=sla">${slave.log_name}</a></div>
						<br/>
						</c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 首页：各板块内容结束 -->


<!-- 公共底部开始 -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ta-c">
                重庆市政府教育督导室 主办&emsp;&emsp;xx信息中心承办
                <br>
                地址：重庆市xx路xxx号&emsp;&emsp;邮政编码：408400&emsp;&emsp;版权所有 [备案信息]
                <br>
                <strong>投稿信箱：</strong>[信箱地址]&emsp;
                <strong>电话传真：</strong>[号码1]&emsp;
                <strong>咨询电话：</strong>[号码2]&emsp;
                <br>
            </div>
        </div>
    </div>
</div>
<script src="static/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
<script src="static/js/global.js" type="text/javascript"></script>
<script src="static/js/main.js" type="text/javascript"></script>
<!-- 公共底部结束 -->
 <script>
   $(function(){
	   $("#article-id").find("img").each(function(){
	        //$(this).width();//就是他的宽度
	       // $(this).$("#imgId")[0].src
	       var src = $(this).attr("src");
	       //alert($(this).attr("src"));
	       $(this).attr('src',"htmlfiles/"+src);
	    });
   });
  
    
   
    </script>
</body>
</html>