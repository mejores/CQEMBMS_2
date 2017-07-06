<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <style>
        .cus-menu{
            border: 1px solid #cccccc !important;/*表示提高权限*/
            border-radius: 5px;
        }
        .cus-menu li ul{
            padding-left: 30px;
        }
        .cus-content .table th{
            font-size: 13px;
            text-align: center;
        }
        .cus-content .table td{
            font-size: 12px;
            text-align: center;
            vertical-align: middle;
        }
        .cus-content .pagination{
            margin: 0;
        }

        #content table tbody .checkbox{
            margin-top: 0;
            margin-bottom: 0;
        }
        #content table tbody td,th{
           text-align: center;
            vertical-align: middle;
            height: 30px;
        }
         #slide table tbody td,th{
           text-align: center;
            vertical-align: middle;
            height: 30px;
        }
        #content table tbody .form-control{
           padding: 0;
            margin: 0;
            text-align: center;
            border: none;
            background-color:rgba(255, 255, 255, 0);
        }
         #slide table tbody .form-control{
           padding: 0;
            margin: 0;
            text-align: center;
            border: none;
            background-color:rgba(255, 255, 255, 0);
        }
        #content table tbody input[name=info-title]{
            max-width: 150px;
        }
        #content table tbody input[name=sub-title]{
            max-width: 100px;
        }
        #content table tbody select[name=info-plate]{
            max-width: 100px;
        }
        #content table tbody input[name=info-author]{
            max-width: 80px;
        }

        #content table tbody .pagination{
            margin: 0;
        }
         #preview, .img, img  
		 {  
		 width:180px;  
		 height:180px; 
		
		 }  
		 #preview  
		 {  
		border:1px solid #000;  
		}

    </style>
    <script src="static/js/jquery-1.11.2.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/layer/layer.js"></script>
    <script src="js/manage.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-header">
        <a href="" class="navbar-brand">重庆教育督导系统门户网站---后台系统</a>
    </div>
    <!--如果使用nav-pills等要占用整行-->
    <ul class="nav navbar-nav pull-right">
        <li><a href="">欢迎您，${sessionScope.userInfo.realName}</a></li>
        <li><a href="user/logout">退出</a></li>
        <li><a href="">消息 <span class="badge">10</span></a></li>
    </ul>
</nav>
<ul class="nav nav-tabs" style="margin-top: 50px">
    <li class="active"><a href="#content" data-toggle="tab">消息管理</a></li>
    <li><a href="#slide" data-toggle="tab">轮播图管理</a></li>
    <li><a href="#user" data-toggle="tab">人员管理<预留></a></li>
</ul>
<!--------------导航与内容分割线---------------------------------------------->
<div class="tab-content" >
    <!--消息管理-->
    <div class="tab-pane active" id="content">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="btn-group pull-left btn-toolbar ">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#addInfo">
                        <span class="glyphicon glyphicon-plus"></span>添加</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span>修改</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="dropdown pull-left" >

					<select class="form-control" name="main">
						
					</select>
              <!--       <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        全部类型 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">督导动态</a></li>
                        <li><a href="#">区县新闻</a></li>
                        <li><a href="#">督导报告</a></li>
                        <li><a href="#">督导研究</a></li>
                    </ul> -->
                </div>

                <div  role="form" class="form-inline">
                    <div class="form-group">
                        <input type="text" placeholder="搜索" class="form-control">
                        <button class="btn btn-primary" onclick="contentModel.doSearch(this)">点击查询</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered table-hover">
                <thead >
                <tr>
                    <!--还有分类、备注
                    删除应该增加多条同时删除
                    -->
                    <th>标题</th>
                    <th>副标题</th>
                    <th>类别</th>
                    <th>作者</th>
                    <th style="max-width: 60px">发布者</th>
                    <th style="width: 80px">最后修改</th>
                    <th>最后修改时间</th>
                    <th>发布时间</th>
                    <th>是否置顶</th>
                    <th>是否公开</th>
                    <th>访问次数</th>
                    <th>附件</th>
                    <th >操作</th>
                </tr>
                </thead>
                <tbody id="content_body">

                <tr id="112">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" disabled></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked disabled></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>

                <tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>
<tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>
<tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>
	<tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr><tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr><tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr><tr id="113">
                    <td><input name="info-title" type="text"  value="渝北区相应国家ddddddddddddddddddddddddddddddddddddddddddd......" class="form-control" readonly ></td>
                    <td><input name="sub-title" type="text" value="无" class="form-control" readonly  ></td>
                    <td><select name="info-plate" class="form-control" disabled>
                        <option value="11">督导动态</option>
                        <option value="21">督导研究</option>
                        <option value="22">区县动态</option>
                        <option value="23">督导动态</option>
                    </select></td>
                    <td><input name="info-author" type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td >系统管理员ddddddddddddd</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" ></label>
                    </div></td>
                    <td><div class="checkbox">
                        <label><input type="checkbox" value="" checked></label>
                    </div>
                    </td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>




                <!--底部页码部分-->
         <!--        <tr>
                    合并的单元
                    <td colspan="12">
                        <div class="row text-center">
                            <div class="col-md-5 " style="margin-top: 10px">
                                <span >当前第1页</span>
                                <span >共500条记录</span>

                            </div>
                            <div class="col-md-1 " style="margin-top: 10px">

                                <a class="pull-right"onclick="contentModel.fresh()"><span class="glyphicon glyphicon-refresh"></span></a>
                            </div>
                            <div class="col-md-6">
                                <ul class="pagination">
                                    <li><a href="">首页</a></li>
                                    <li><a href="">1</a></li>
                                    <li><a href="">2</a></li>
                                    <li><a href="">3</a></li>
                                    <li><a href="">4</a></li>
                                    <li><a href="">5</a></li>
                                    <li><a href="">6</a></li>
                                    <li><a href="">7</a></li>
                                    <li><a href="">尾页</a></li>
                                </ul>
                            </div>
                        </div>

                    </td>
                </tr> -->
                </tbody>
            </table>
            <!-- 导航 -->
             <div class="row text-center">
                            <div class="col-md-5 " style="margin-top: 25px" id="pageinfo">
                               	当前第 1页
                                		共500条记录

                            </div>
                            <div class="col-md-1 " style="margin-top: 25px">

                                <a class="pull-right"onclick="contentModel.fresh()"><span class="glyphicon glyphicon-refresh"></span></a>
                            </div>
                            <div class="col-md-6">
                                <ul class="pagination" id="pagenavbar">
                                    <li><a href="">首页</a></li>
                                    <li><a href="">1</a></li>
                                    <li><a href="">2</a></li>
                                    <li><a href="">3</a></li>
                                    <li><a href="">4</a></li>
                                    <li><a href="">5</a></li>
                                    <li><a href="">6</a></li>
                                    <li><a href="">7</a></li>
                                    <li><a href="">尾页</a></li>
                                </ul>
                            </div>
                        </div>
            
            
        </div>
    </div>
    <!--轮播图管理-->
    <div class="tab-pane" id="slide">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="btn-group pull-left btn-toolbar ">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#modal-addSlide" id="addSlide">
                        <span class="glyphicon glyphicon-plus"></span>添加</button>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#editSlide">
                        <span class="glyphicon glyphicon-pencil"></span>修改</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <form action="" role="form" class="form-inline">
                    <div class="form-group">
                        <input type="text" placeholder="搜索轮播图" class="form-control">
                        <button class="btn btn-primary">点击查询</button>
                    </div>
                </form>
            </div>
            <table class="table table-bordered table-hover">
                <thead >
                <tr>
                    <!--还有分类、备注
                    删除应该增加多条同时删除
                    -->
                    <th>消息说明</th>
                    <th>关联消息</th>
                    <th>备注</th>
                    <th>操作</th>

                </tr>
                </thead>
                <tbody id="slide_body">
                <tr>

                    <td>渝北区到广西自治区调研</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>

                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>

                </tbody>
            </table>
                       <!-- 导航 -->
             <div class="row text-center">
                            <div class="col-md-5 " style="margin-top: 25px" id="slide-pageinfo">
                               	当前第 1页
                                		共500条记录

                            </div>
                            <div class="col-md-1 " style="margin-top: 25px">

                                <a class="pull-right"onclick="contentModel.fresh()"><span class="glyphicon glyphicon-refresh"></span></a>
                            </div>
                            <div class="col-md-6">
                                <ul class="pagination" id="slide-pagenavbar">
                                    <li><a href="">首页</a></li>
                                    <li><a href="">1</a></li>
                                    <li><a href="">2</a></li>
                                    <li><a href="">3</a></li>
                                    <li><a href="">4</a></li>
                                    <li><a href="">5</a></li>
                                    <li><a href="">6</a></li>
                                    <li><a href="">7</a></li>
                                    <li><a href="">尾页</a></li>
                                </ul>
                            </div>
                        </div>
            
        </div>
    </div>
    <!--预留，人员管理-->
    <div class="tab-pane" id="user">

    </div>
</div>
<!--//////////选项卡-->

</div>




<!--添加消息模态框-->
<div class="modal fade" id="addInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"><span class="badge text-info">添加消息</span></h4>
            </div>
            <div class="modal-body">
                <form id="add-form" method="post"  action="content/addContent" class="center-block " onsubmit="contentModel.btnAdd()" style="line-height: 40px">
                    <div class="row" >
                        <div class="col-md-2"><label >标题</label></div>
                        <div class="col-md-4"><input type="text" class="form-control" name="conTitle"></div>
                        <div class="col-md-2"><label >副标题</label></div>
                        <div class="col-md-4"><input type="text" class="form-control"  name="subTitle"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-2"><label >类型</label></div>
                        <div class="col-md-4"><select class="form-control"
                                                      name="plateNo">
                            
                        </select></div>
                        <div class="col-md-2"><label >作者</label></div>
                        <div class="col-md-4"><input type="text" class="form-control" name="author"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-2"><label >是否置顶</label></div>
                        <div class="col-md-4"><select class="form-control"
                                                      name="istop">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select></div>
                        <div class="col-md-2"><label >是否公开</label></div>
                        <div class="col-md-4"><select class="form-control"
                                                      name="statu">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select></div>
                    </div>
                    <div class="row">
                        <div class="col-md-2"><label >网页文件<a style="font-size:18px" onclick="upLoadModel.webFileTips()">?</a></label></div>
                        <div class="col-md-4">
	                        <input type="file" class="form-control" id="webFile">
	                        <input type="hidden" id="conPath" name="conPath">
                        </div>
                        <div class="col-md-2"><label >附件[可选]</label></div>
                        <div class="col-md-4">
                        	<input type="file" multiple="multiple" class="form-control" id="slaveFile">
                        	<input type="hidden" id="slavesLogName" name="slavesLogName">
                        	<input type="hidden" id="slavesPhyName" name="slavesPhyName">
                        	</div>
                    </div>
                    <div class="row" id="upProgress" style="display:none">
                        <div class="col-md-12">
                            <div class="progress" style="height: 5px">
                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 1%;">
                                    30%
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-bottom: 20px">
                        <div class="col-md-4">
                            <button type="button" onclick="upLoadModel.btnUpLoad()" class="btn btn-primary btn-sm pull-right">上传文件</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2"><label >备注</label></div>
                        <div class="col-md-10"><textarea  class="form-control" name="comment"></textarea></div>

                    </div>
                    <div class="pull-right">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary">保存</button>
                    </div>
				
                </form>
            </div>
            <div class="modal-footer">
               
            </div>
        </div>
    </div>
</div>


<!--添加轮播图模态框-->
<div class="modal fade" id="modal-addSlide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ><span class="badge text-info">添加轮播图</span></h4>
            </div>
            <div class="modal-body">
            <div class="center-block " onsubmit="contentModel.btnAdd()" style="line-height: 40px">
            	
                <div class="row">
                        <div class="col-md-2"><label >消息说明</label></div>
                        <div class="col-md-4"><input type="text" class="form-control"
                                                      name="imgCon" readonly></div>
                        <div class="col-md-3"><label>与消息标题一致</label></div>
                        <div class="col-md-1"><input class="form-control" name="LinkToInfo" type="checkbox" checked onclick="slideModel.linkToInfo(this)"></div>
                    </div>
                <div class="row">
            		<div class="col-md-2"><label >消息图片</label></div>
            		<div class="col-md-4">
            		<input class="form-control" type="file" id="addPicFile" onchange="slideModel.picPreview(this)"
            		 accept="image/gif,image/jpeg,image/x-png"/></div>
            		 <div class="col-md-2"><label>备注</label></div>
            		 <div class="col-md-4">
            		   <input class="form-control" type="text" name="comment">
            		 </div>
            	</div>
            	<div class="row">
            		<!--可关联消息列表  -->
            		<div class="col-md-8">
            		<table class="table table-bordered table-hover">
            			<thead>
            				<tr>
            				<th>消息标题</th>
            				<th>是否公开</th>
            				</tr>
            			</thead>
            			<tbody>
            				
            			</tbody>
            		</table>
            		</div>
            		<div class="col-md-4">
            		  <!--图片预览框  -->
            		  <div><span style="font-size:20px;color:#FF7F50" class="glyphicon glyphicon-hand-left"></span>&nbsp要关联的消息</div>
            		  <div id="preview" class="pull-right"></div>
            		
            	</div>
            	</div>
            	<div class="row ">
            	  <div class="col-md-9 col-md-offset-2">
                      <ul class="pagination" style="padding:0;margin:0" id="addSlide-pagenavbar">
                          <li><a href="">首页</a></li>
                          <li><a href="">1</a></li>
                          <li><a href="">2</a></li>
                          <li><a href="">3</a></li>
                          <li><a href="">4</a></li>
                          <li><a href="">5</a></li>
                          <li><a href="">尾页</a></li>
                      </ul>
                      </div>
            	</div>
            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="commit" onclick="slideModel.addSlide()">保存</button>
            </div>
        </div>
    </div>
</div>



<!--查看附件模态框-->
<div class="modal fade" id="modal-showSlaves" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ><span class="badge text-info">查看附件</span></h4>
            </div>
            <div class="modal-body">
    			<!-- 附件内容 -->
    			<div name="slaves">
    			
    			</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="commit" onclick="slideModel.addSlide()">保存</button>
            </div>
        </div>
    </div>
</div>

<!-------------------------------------------------------------------------------------------------------->


</body>
</html>