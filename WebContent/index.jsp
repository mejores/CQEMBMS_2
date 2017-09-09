<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>首页 - 重庆教育督导网</title>
<meta name="keywords" content="重庆教育督导，重庆市政府教育督导室">
<meta name="description" content="重庆教育督导网，重庆市政府教育督导室主办。">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="static/css/global.css" rel="stylesheet" type="text/css">
<link href="static/css/main.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="favicon.ico">
<script type="text/javascript" src="static/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<%-- <c:if test="${requestScope.infolist12==null }">
	<script type="text/javascript">
	location.href="content/getAllInfosToRequest";
	</script>
</c:if>
 --%>
</head>
<body >

	<!-- 公共顶部开始 -->
	<div id="bg-top" class="bgt-hide2">
		<div id="bg-top-ct" data-bgnum="1"
			style="background-image: url(static/images/bg-top0.jpg);">
			<!-- data-bgnum为切换数量  -->
		</div>
		<div id="head">
			<div id="nav">
				<div class="nav-list">
					<ul>
					<li class="active"><a href="index.jsp">首页</a></li>
					<li><a href="content/loadList?plate=12">督导动态</a></li>
                    <li><a href="content/loadList?plate=21">区县信息</a></li>
                    <li><a href="content/loadList?plate=22">督导报告</a></li>
                    <li><a href="content/loadList?plate=23">督导研究</a></li>
                    <li><a href="content/loadList?plate=31">组织机构</a></li>
                    <li><a href="content/loadList?plate=32">政策法规</a></li>
                    <li><a href="#">服务平台</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 公共顶部结束 -->

	<!-- 首页：各板块内容开始 -->
	<div class="container bulk-content">
		<!-- 幻灯片+动态 -->
		<div class="row">
			<div class="col-sm-5 p-0">
				<div class="list-box m-t0 index-pic" id="slidewrap">
					<script type="text/javascript">

					var swf_width = 400;
					var swf_height = 260 + 20;
					var title_height = 20;
					var focus_height = swf_height + title_height;
					var interval_time = 6;
					var files=[];
					var links=[];
					var texts=[];
					//<c:forEach var="slide" items="${requestScope.slidelist}">
					
						//alert(slides)
					 	 $.each(slides,function(index,slide){
						files.push('upload/slides/'+slide.imgPath);
						links.push('detailLoad.do?urlstring='+slide.conId);
						texts.push(slide.imgCon);
					}) 
	
					
					  
					
					//</c:forEach>
					
					/* var files = [
							'slidepic/1481768651004.jpg',
							'static/images/examples/index-pic/201611110546120418_S.jpg',
							'static/images/examples/index-pic/201611110235298374_S.jpg',
							'static/images/examples/index-pic/201611110229230382_S.jpg',
							'static/images/examples/index-pic/201611110004371723_S.jpg', ]; */
					
					//var links = [ '#', '#', '#', '#', '#', ];
					/* var texts = [ '我市教育系统积极开展“消防宣传…', '黔江区命名首批“名师工作室”',
							'送岗位进高校双选活动（大足专场…', '第二届重庆市青少年科学素养大赛…',
							'江北区开展“校长谈规划”交流活动', ]; */
					
					var swf_src = 'static/swf/focus.swf';
					document
							.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="' + swf_width + '" height="' + focus_height + '">');
					document
							.write('<param name="movie" value="' + swf_src + '">');
					document.write('<param name="quality" value="high">');
					document.write('<param name="menu" value="false">');
					document.write('<param name="wmode" value="opaque" id="slidesForShow">');
					
					document.write('</object>');
					
					</script>
				</div>
			</div>
			<div class="col-sm-7 p-0 p-l5">
				<div class="list-box m-t0 box-important-list">
					<div class="head-line">
						<h3>督导动态</h3>
						<a href="content/loadList?plate=12">更多>></a>
					</div>
					<ul class="list-unstyled list-article list-with-date" id="infolist12">
					
					</ul>
					
				</div>
			</div>
		</div>
		<!-- 左2栏+右1栏 -->
		<div class="row m-t5">
			<div class="col-sm-9 p-0 p-r10">
				<div class="col-sm-6 p-0 p-r5">
					<div class="list-box box-general-list">
						<div class="head-line">
							<h3>区县信息</h3>
							<a href="content/loadList?plate=21">更多>></a>
						</div>
						<ul class="list-unstyled list-article"  id="infolist21">
						<%-- <c:forEach var="info" items="${requestScope.infolist21}">
							<li>
							<div class="article-title">
								<a href="detailLoad.do?urlstring=${info.conId}">
								<c:if test="${info.istop==1 }">
									<span style="color:red">[置顶]</span>
                                </c:if>
								${info.conTitle}</a>
							</div> 
							</li>
						
						</c:forEach> --%>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 p-0 p-l5">
					<div class="list-box box-general-list">
						<div class="head-line">
							<h3>督导报告</h3>
							<a href="content/loadList?plate=22">更多>></a>
						</div>
						<ul class="list-unstyled list-article" id="infolist22">
							
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-3 p-0">
				<div class="list-box box-general-list">
					<div class="head-line">
						<h3>督导研究</h3>
						<a href="content/loadList?plate=23">更多>></a>
					</div>
					<ul class="list-unstyled list-article" id="infolist23">
						
					</ul>
				</div>
			</div>
		</div>
		<!-- 左1大栏+右1栏 -->
		<div class="row m-t5">
			<div class="col-sm-9 p-0 p-r10">
				<div class="list-box box-picture-link">
					<a href="#"><img src="static/images/index-middle-slogan.jpg"
						width="100%" height="120" alt="中图"></a>
				</div>
			</div>
			<div class="col-sm-3 p-0">
				<div class="list-box box-picture-link">
					<a href="#"><img src="static/images/index-service-platform.jpg"
						width="100%" height="120" alt="图-链接-服务平台"></a>
				</div>
			</div>
		</div>
		<!-- 左2栏+右1栏 -->
		<div class="row m-t5">
			<div class="col-sm-9 p-0 p-r10">
				<div class="col-sm-6 p-0 p-r5">
					<div class="list-box box-general-list">
						<div class="head-line">
							<h3>组织机构</h3>
							<a href="content/loadList?plate=31">更多>></a>
						</div>
						<ul class="list-unstyled list-article" id="infolist31">
							
						</ul>
					</div>
				</div>
				<div class="col-sm-6 p-0 p-l5">
					<div class="list-box box-general-list">
						<div class="head-line">
							<h3>政策法规</h3>
							<a href="content/loadList?plate=32">更多>></a>
						</div>
						<ul class="list-unstyled list-article" id="infolist33">
							
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-3 p-0">
				<div class="list-box box-general-list">
					<div class="head-line">
						<h3>友情链接</h3>
					</div>
					<ul class="list-unstyled list-article">
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
						<li>
							<div class="article-title">
								<a href="http://www.bjjydd.gov.cn/" target="_blank">北京市人民政府教育督导室</a>
							</div>
						</li>
					</ul>
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
					重庆市政府教育督导室 主办&emsp;&emsp;xx信息中心承办 <br>
					地址：重庆市xx路xxx号&emsp;&emsp;邮政编码：408400&emsp;&emsp;版权所有 [备案信息] <br>
					<strong>投稿信箱：</strong>[信箱地址]&emsp; <strong>电话传真：</strong>[号码1]&emsp;
					<strong>咨询电话：</strong>[号码2]&emsp; <br>
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