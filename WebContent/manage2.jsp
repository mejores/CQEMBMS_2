<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <style>"WebContent/static/js/bootstrap.min.js"
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
        p{
            padding-top: 50px
        }
        textarea{
            background-color:rgba(255, 255, 255, 0);
            width: 100%;
            height: 100%;
            border: none;
            text-align: center;
            vertical-align: middle;

        }
        td{
            padding: 0;
            margin: 0;
        }
        input{
            text-align: center;
            background-color:rgba(255, 255, 255, 0);
        }
    </style>
    <script src="static/js/jquery-1.11.2.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-header">
        <a href="" class="navbar-brand">重庆教育督导系统门户网站---后台系统</a>
    </div>
    <!--如果使用nav-pills等要占用整行-->
    <ul class="nav navbar-nav pull-right">
        <li><a href="">欢迎1223984</a></li>
        <li><a href="">退出</a></li>
        <li><a href="">消息 <span class="badge">10</span></a></li>
    </ul>
</nav>
<ul class="nav nav-pills" style="padding-top: 50px">
    <li class="active"><a href="">消息管理</a></li>
    <li><a href="">轮播图管理</a></li>
    <li><a href="">会员管理</a></li>
    <li><a href="">会员管理</a></li>
    <li><a href="">会员管理</a></li>
</ul>
<div class="row">
   <!-- <div class="col-md-1 cus-menu" style="max-width: 200px">
        &lt;!&ndash;<ul class="nav nav-pills nav-stacked">
            <li >
                <a href="#menu-1" data-toggle="collapse">
                    <span class="glyphicon glyphicon-collapse-down"></span>消息管理</a>
                <ul class="nav nav-pills nav-stacked collapse  in" id="menu-1">
                    <li><a href="" ><span class="glyphicon glyphicon-plus"></span> 添加</a></li>
                    <li><a href="" onclick="update_info()"><span class="glyphicon glyphicon-pencil"></span> 修改</a></li>
                    <li><a href=""><span class="glyphicon glyphicon-trash"></span> 删除</a></li>
                </ul>
            </li>
            <li >
                <a href="#menu-2" data-toggle="collapse"><span class="glyphicon glyphicon-collapse-down"></span>轮播图管理</a>
                <ul class="nav nav-pills nav-stacked collapse" id="menu-2">
                    <li><a href=""><span class="glyphicon glyphicon-plus"></span> 添加</a></li>
                    <li><a href=""><span class="glyphicon glyphicon-pencil"></span> 修改</a></li>
                    <li><a href=""><span class="glyphicon glyphicon-trash"></span> 删除</a></li>
                </ul>
            </li>
        </ul>&ndash;&gt;
    </div>-->
    <div class="col-md-12 cus-content">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="btn-group pull-left btn-toolbar ">
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>添加</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span>修改</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="dropdown pull-left" >

                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        全部类型 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">督导动态</a></li>
                        <li><a href="#">区县新闻</a></li>
                        <li><a href="#">督导报告</a></li>
                        <li><a href="#">督导研究</a></li>
                    </ul>
                </div>

                <form action="" role="form" class="form-inline">
                    <div class="form-group">
                        <input type="text" placeholder="搜索" class="form-control">
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
                    <th>标题</th>
                    <th>副标题</th>
                    <th>作者</th>
                    <th>发布者</th>
                    <th>最后修改</th>
                    <th>发布时间</th>
                    <th>最后修改时间</th>
                    <th>是否置顶</th>
                    <th>状态</th>
                    <th>访问次数</th>
                    <th>附件</th>
                    <th >操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="info">
                  <tr>
                  

  <!--   private String plateNo;
    private Byte istop;
    private String conHtml;
    private String conPath;
    private String comment; -->
                    <td>${info.conTitle}</td>
                    <td>${info.subTitle}</td>
                    <td>${info.author}</td>
                    <td>${info.publisher}</td>
                    <td>${info.editor}</td>
                    <td>${info.pubTime}</td>
                    <td>${info.modifyTime}</td>
                    <td>${info.istop}</td>
                    <td>${info.statu}</td>
                    <td>${info.visitCount}</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>
                </c:forEach>
               <!--  <tr id="111" onclick="choose(this)">
                    <td><textarea disabled>渝北区相应国家......</textarea></td>
                    <td>无</td>
                    <td>区督导办</td>
                    <td>系统管理员</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td>是</td>
                    <td>公开</td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr> -->
               <!--  <tr id="112" onclick="choose(this)">
                    <td><input type="text" value="渝北区相应国家......" class="form-control" readonly style="width: 160px"></td>
                    <td><input type="text" value="无" class="form-control" readonly style="width: 100px"></td>
                    <td><input type="text" value="区督导办" class="form-control" readonly style="width: 100px"></td>
                    <td><input type="text" value="系统管理员" class="form-control" readonly style="width: 100px"></td>
                    <td><input type="text" value="毕福剑" class="form-control" readonly style="width: 100px"></td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td><select class="form-control" name="mcsGrade" readonly="true" style="width: 70px">
                        <option value="Ⅰ">否</option>
                        <option value="Ⅱ">是</option>
                    </select></td>
                    <td>公开</td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr> -->
          
               <!--  <tr id="114" onclick="choose(this)">
                    <td>渝北区相应国家......</td>
                    <td>无</td>
                    <td>区督导办</td>
                    <td>系统管理员</td>
                    <td>毕福剑</td>
                    <td>2014.12.1 12:02</td>
                    <td>2016.12.1 12:02</td>
                    <td>是</td>
                    <td>公开</td>
                    <td>36</td>
                    <td><a href="">查看附件</a></td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-primary">修改</button>
                            <button class="btn btn-primary">删除</button>
                        </div></td>
                </tr>
                -->
              
             



                <tr>
                    <!--合并的单元-->
                    <td colspan="13">
                        <div class="row ">
                            <div class="col-md-5 pull-left" Style="">
                                当前第${pageInfo.pageNum}页,共 ${pageInfo.pages}页，总共 ${pageInfo.total}条记录 

                            </div>

                        </div>
                        <div class="col-md-6 pull-right">
                            <ul class="pagination">
                            <li><a href="getAllInfos?pn=1">首页</a></li>
                            <c:if test="${pageInfo.hasPreviousPage}">
                            <li><a href="getAllInfos?pn=${pageInfo.pageNum-1}"><<<</a></li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <!-- 如果遍历出来的页面是当前页面 -->
                            <c:if test="${page_Num==pageInfo.pageNum }">
                            <li  class="active"><a href="#"> ${page_Num}</a></li>
                            </c:if>
                            <!-- 如果不是 -->
                            <c:if test="${page_Num!=pageInfo.pageNum }">
                            <li><a href="getAllInfos?pn=${page_Num}"> ${page_Num}</a></li>
                            </c:if>
                            </c:forEach>
                             <c:if test="${pageInfo.hasNextPage}">
                            <li><a href="getAllInfos?pn=${pageInfo.pageNum+1}">>>></a></li>
                            </c:if>
                            <li><a href="getAllInfos?pn=${pageInfo.pages}">尾页</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    var checked_item_id="";
    function choose(obj) {
        if(checked_item_id!=""){

            $("#"+checked_item_id).css("background-color","#ffffff")
        }
        checked_item_id=obj.id
        obj.style.backgroundColor="#79afeb"
        obj.display.backgroundColor="red"
    }

    //编辑消息
    function update_info() {
        if(checked_item_id==""){
            alert("请先选择")
        }else{

        }
    }
</script>
</body>
