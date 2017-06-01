<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>列表页 - 重庆教育督导网</title>
    <meta name="keywords" content="重庆教育督导，重庆市政府教育督导室">
    <meta name="description" content="重庆教育督导网，重庆市政府教育督导室主办。">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/global.css" rel="stylesheet" type="text/css">
    <link href="static/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="favicon.ico">
</head>
<body>
<!-- 公共顶部开始 -->
<div id="bg-top" class="bgt-hide2">
    <div id="bg-top-ct" data-bgnum="1" style="background-image:url(static/images/bg-top0.jpg);"><!-- data-bgnum为切换数量  --></div>
    <div id="head">
        <div id="nav">
            <div class="nav-list">
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                    <c:if test="${requestScope.plate=='12'}">
                     <li class="active"><a href="#">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                    <c:if test="${requestScope.plate=='21'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li class="active"><a href="#">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='22'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li ><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li class="active"><a href="#">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='23'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li  class="active"><a href="#">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='31'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li  class="active"><a href="#">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='32'}">
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
                
                   <c:if test="${requestScope.plate=='12'}">
                     <li class="active"><a href="#">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                    <c:if test="${requestScope.plate=='21'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li class="active"><a href="#">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='22'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li ><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li class="active"><a href="#">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='23'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li  class="active"><a href="#">督导研究</a></li>
                    <li><a href="listLoad.do?plate=31">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='31'}">
                     <li><a href="listLoad.do?plate=12">督导动态</a></li>
                    <li><a href="listLoad.do?plate=21">区县信息</a></li>
                    <li><a href="listLoad.do?plate=22">督导报告</a></li>
                    <li><a href="listLoad.do?plate=23">督导研究</a></li>
                    <li  class="active"><a href="#">组织机构</a></li>
                    <li><a href="listLoad.do?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
                   </c:if>
                   <c:if test="${requestScope.plate=='32'}">
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
            <div class="list-box m-t0 right-article-list">
                <!-- 当前位置 -->
                <div class="position text-muted">
                    当前位置：
                    <a href="index.jsp">首页</a>
                    >
                    <span>
                    <c:if test="${requestScope.plate=='12'}">
                     	督导动态
                   </c:if>
                   <c:if test="${requestScope.plate=='21'}">
                     	区县信息
                   </c:if>
                   <c:if test="${requestScope.plate=='22'}">
                     	督导报告
                   </c:if>
                   <c:if test="${requestScope.plate=='23'}">
                     	督导研究
                   </c:if>
                   <c:if test="${requestScope.plate=='31'}">
                     	组织机构
                   </c:if>
                    <c:if test="${requestScope.plate=='32'}">
                     	政策法规
                   </c:if>
                    
                    </span>
                </div>
                <!-- 正文列表 -->
                <ul class="list-article list-with-date">
                
                
                <c:forEach var="info" items="${requestScope.infolist}">
						<li>
							<div class="article-title">
								<a href="detailLoad.do?urlstring=${info.con_id}&&">
								<c:if test="${info.isTop==1 }">
									[置顶]
                                </c:if>
								${info.con_title}</a>
							</div> <span class="date">${fn:substring(info.pub_time,0,10)}</span>
							<%-- <c:out value="${fn:substring(info.pub_time,0,10)}"/> --%>
							</li>
						
						</c:forEach>
                   
                </ul>
                <!-- 分页信息 -->
                <div class="pagination-box">
                    <span class="info">共<span class="total">${requestScope.rowCount}</span>条，每页<span class="per">20</span>条，分<span class="pages">${requestScope.pageCount}</span>页显示</span>
                    <ul class="pagination">
                           <c:if test="${requestScope.toPage!=1}">
                        <li >
                           <!--  <span><<</span> -->
                            <a href="listLoad.do?plate=${requestScope.plate}&&toPage=${requestScope.toPage-1}"><<<</a>
                        </li>
                        </c:if>
                        <c:if test="${requestScope.toPage==1}">
                        <li class="disabled">
							<span><<</span> 
                        </li>
                        </c:if>
                        <c:set var="sta" scope="page" value="1"/>
                        <c:set var="endd" scope="page" value="${requestScope.pageCount}"/>
                        <!--如果总页面大于8个或者总页面减去当前页面大于8  -->
                         <c:if test="${requestScope.pageCount>8||(requestScope.pageCount-requestScope.toPage)>8}">
                        	<!--如果当前页大于3  -->
                        	<c:if test="${requestScope.toPage>3}">
                        		<c:set var="sta" scope="page" value="${requestScope.toPage-2}"/>
                        	</c:if>
                        	<!--如果当前页小于总页面减4  -->
                         	<c:if test="${requestScope.toPage<(requestScope.pageCount-4)}">
                        		<c:set var="endd" scope="page" value="${requestScope.toPage+5}"/>
                        	</c:if>
                        </c:if> 
                        <c:forEach var="j" begin="${sta}" end="${endd}">
                      
                         <c:choose>
                           <c:when test="${j==requestScope.toPage}">
                        	<li class="active">
                            <span>${j}</span>
                            </li>
                        </c:when>
                         <c:otherwise>
                         <li>
                            <a href="listLoad.do?plate=${requestScope.plate}&&toPage=${j}">${j}</a>
                        </li>
                        </c:otherwise>
                        </c:choose>
						
					</c:forEach>
                          <c:if test="${requestScope.toPage!=requestScope.pageCount}">
                        <li >
                            <a href="listLoad.do?plate=${requestScope.plate}&&toPage=${requestScope.toPage+1}">>>></a>
                        </li>
                        </c:if>
                        <c:if test="${requestScope.toPage==requestScope.pageCount}">
                        <li class="disabled">
							<span>>></span>
                        </li>
                        </c:if>
                      
                 	</ul>
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
</body>
</html>