/**
 * Created by joven on 2017/5/16.
 */
$(function(){
	contentModel.load(1);
})

//定义消息处理模型
var contentModel={};

//定义轮播图处理模型
var lideModel={};

//定义上传文件处理模型
var upLoadModel={};

/**************************************************************************/
/****************消息处理开始**************************************************/
/**************************************************************************/
//添加消息设置
//$('#addInfo').modal({backdrop:"static",show:true});


//编辑消息
function editInfo(){
	
}

$("#title1").on("click",function () {
    $('#title1').popover({
        title: '修改消息',
        content: "<div class='form-group'>" +
        "<input class='form-control' type='text'/>" +
        "<button class='btn btn-primary btn-xs'>保存修改</button>" +
        "</div>",
        html:true
    })
})
//点击项目选中
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
//初始化选择的消息类型类型
contentModel.selectType="all";

//跳转到多少页和初始化加载
contentModel.load=function(pn){
	$.ajax({
		url:"content/getAllInfos",
		data:{"pn":pn,"type":contentModel.selectType},
		type:"get",
		success:function(result){
			console.log(result);
			//1、解析并现实信息
			
			contentModel.build_table(result.extend.pageInfo.list);
			//2、解析并显示分页信息
			contentModel.build_nav(result.extend.pageInfo);
			
			//3、解析并显示分类下拉菜单
			contentModel.build_select(result.extend.plate)
		}
	});
}

//选项改变后，重新加载内容，但是不重新加载选项框
contentModel.loadWithoutSelect=function(pn){
	$.ajax({
		url:"content/getAllInfos",
		data:{"pn":pn,"type":contentModel.selectType},
		type:"get",
		success:function(result){
			console.log(result);
			//1、解析并现实信息
			
			contentModel.build_table(result.extend.pageInfo.list);
			//2、解析并显示分页信息
			contentModel.build_nav(result.extend.pageInfo);
			
		
		}
	});
}


//？先查出所有分类
//构建消息列表下拉菜单
contentModel.build_select=function(platelist){
	$("#content select").empty();
	//添加选项
	$("#content select").append('<option value="all" checked>全部类型</option>')
	$.each(platelist,function(index,plate){
		$("#content select").append('<option value="'+plate.plateNo+'">'+plate.plateName+'</option>');
		//添加消息模态框处的下拉菜单
		$("#add-form select").append('<option value="'+plate.plateNo+'">'+plate.plateName+'</option>');
	})
	$("#content select").bind("change",function(){
		//如果选项改变，则改变成员变量selectType的值
		contentModel.selectType=$("#content select").val();
		contentModel.loadWithoutSelect(1)
	});
	
}

//构建消息列表
contentModel.build_table=function(list){
	
	$("#content_body").empty();
	$.each(list,function(index,item){
	
	    var temp=' <tr > <td><input type="hidden" value="'+item.conNo+'"><input name="info-title" type="text"  value="'+item.conTitle+'" class="form-control" readonly ></td>'+
         '<td><input name="sub-title" type="text" value="'+item.subTitle+'" class="form-control" readonly  ></td>'+
         '<td><select name="info-plate" class="form-control" disabled>'+
             '<option value="11">督导动态</option>'+
             '<option value="21">督导研究</option>'+
             '<option value="22">区县动态</option>'+
             '<option value="23">督导动态</option>'+
         '</select></td>'+
         '<td><input name="info-author" type="text" value="'+item.author+'" class="form-control" readonly style="width: 100px"></td>'+
         '<td >'+item.publisher+'</td>'+
         '<td>'+item.editor+'</td>'+
         '<td>'+item.modifyTime+'</td>'+
         '<td>'+item.pubTime+'</td>'+
         '<td><div class="checkbox">'+
             '<label><input type="checkbox" disabled></label>'+
         '</div></td>'+
         '<td><div class="checkbox">'+
             '<label><input type="checkbox" value="" checked disabled></label>'+
         '</div>'+
         '</td>'+
         '<td>36</td>'+
         '<td><a href="">查看附件</a></td>'+
         '<td>'+
             '<div class="btn-group btn-group-sm">'+
                 '<button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>'+
                 '<button class="btn btn-primary" name="btn-delete-content">删除</button>'+
             '</div></td>'+
     '</tr>'
             $("#content_body").append(temp);     
	});
}

//构建分页信息
contentModel.build_nav=function(pageInfo){
	$("#pageinfo").html("当前第"+pageInfo.pageNum+"页,共"+pageInfo.pages+"页，共"+pageInfo.total+"条记录");
	$("#pagenavbar").empty();
	
	if(pageInfo.hasPreviousPage){
		$("#pagenavbar").append('<li><a onclick="contentModel.loadWithoutSelect(1)">首页</a></li>');
		$("#pagenavbar").append(' <li><a onclick="contentModel.loadWithoutSelect('+pageInfo.pageNum +'-1)"><<<</a></li>');
	}else{
		$("#pagenavbar").append('<li class="disabled"><a href="#">首页</a></li>');
	}
	$.each(pageInfo.navigatepageNums,function(index,page_Num){
		if(page_Num==pageInfo.pageNum){
			$("#pagenavbar").append('<li  class="active"><a href="#" > '+page_Num+'</a></li>')
			
		}else{
			$("#pagenavbar").append('<li><a onclick="contentModel.loadWithoutSelect('+page_Num+')"> '+page_Num+'</a></li>')
		}
	});
	
	if(pageInfo.hasNextPage){ 
		$("#pagenavbar").append(' <li><a onclick="contentModel.loadWithoutSelect('+pageInfo.pageNum +'+1)"> >>> </a></li>');
		$("#pagenavbar").append('<li><a onclick="contentModel.loadWithoutSelect('+pageInfo.lastPage+')">末页</a></li>');
	}else{
		$("#pagenavbar").append('<li class="disabled"><a href="#" >末页</a></li>');
	}
	 

}
//添加消息
contentModel.btnAdd=function () {
	var index = layer.load(3);
}
//删除消息
$(document).on("click","button[name='btn-delete-content']",function(){
	var conNo=$(this).parents("tr").find("td:eq(0)").find("input[type='hidden']").val();
	//alert($(this).parents("tr").find("td:eq(0)").find("input[type='hidden']").val())
	layer.confirm('确定删除吗?', {icon: 3, title:'删除消息'}, function(index){
		  //执行删除操纵
		$.ajax({
			url:"content/deleteContent/"+conNo,
			type:"DELETE",
			success:function(result){
				layer.msg(result.msg);
			}
		})
		  
		  layer.close(index);
		}); 
})

//编辑消息2
contentModel.btnEdit=function (obj) {
    var tt= obj.parentNode.parentNode.parentNode;
    var pp=tt.document.getElementsByTagName("input");
    alert(pp);
}
//刷新数据
contentModel.fresh=function () {
        var index = layer.load(2, {time: 10*1000});
        contentModel.load(1);
    }


/******************************************************************************/
/********************消息处理结束**********************************************/
/******************************************************************************/


/******************************************************************************/
/********************轮播图处理开始**********************************************/
/******************************************************************************/

/******************************************************************************/
/********************轮播图处理结束**********************************************/
/******************************************************************************/


/******************************************************************************/
/********************文件上传处理开始**********************************************/
/******************************************************************************/
	//网页文件提示
    upLoadModel.webFileTips=function(){
    	layer.alert('网页文件就是消息的具体内容，必须为word文件，仅支持上传单个', {icon: 1});
    }



    //文件上传按钮
	upLoadModel.btnUpLoad=function() {
		//绑定网页上传事件和附件上传事件
		//将打开进度条事件移动到附件上传里面
		upLoadModel.uploadWebFile();
		upLoadModel.uploadSlave();
		
	}
//--------------------------------------------------------------
	//上传wordWEB文件
	upLoadModel.uploadWebFile= function() {
  
	if($("#webFile").val()==null||$("#webFile").val()==""){
		layer.msg('网页文件未选择！');
		}else{
          // .准备FormData
          var fd = new FormData();

          // 装在web文件,webFile是input的id
		  fd.append("webfile",webFile.files[0]);
          // 创建xhr对象
           var xhr = new XMLHttpRequest();
          // 监听状态，实时响应
          // xhr 和 xhr.upload 都有progress事件，xhr.progress是下载进度，xhr.upload.progress是上传进度        xhr.upload.onprogress = function(event) {
	       //如果长度可计算
           xhr.upload.onprogress = function(event) {
            if (event.lengthComputable) {
            	//alert("长度可以计算");
                var percent = Math.round(event.loaded *100 / event.total);

            	}
        	};
        	// 传输开始事件
        	xhr.onloadstart = function(event) {
            $("#stopbtn").one('click', function() {
            	//终止当前的网络请求
                xhr.abort();
                $(this).hide();
            });

            //loading(true);
        };
      // ajax过程成功完成事件
        xhr.onload = function(event) {
            console.log('load success');
            $("#upprog").text('上传成功');
            console.log(xhr.responseText);
            var ret = JSON.parse(xhr.responseText);
            if(ret.code=='100'){
            	var path= ret.extend.res.phyName;
            	$("#conPath").val(path);
            	//layer.tips('上传成功', '#webFile');
            	layer.tips('网页文件上传成功！', '#webFile', {
            		  tips: [1, '#3595CC'],
            		  time: 3000
            		});
            }else{
            	layer.tips('网页文件上传失败！', '#webFile', {
          		  tips: [1, 'FF3333'],
          		  time: 3000
          		});
            }
           // alert(ret.retMsg);
            
           // $("#con_HTML").val(ret.con_HTML);
            $("#isUploaded").val("yes");
            
        };
      // ajax过程发生错误事件
        xhr.onerror = function(event) {
            console.log('error');
            $("#upprog").text('发生错误');
        };
      // ajax被取消
        xhr.onabort = function(event) {
            console.log('abort');
            $("#upprog").text('操作被取消');
        };
      // loadend传输结束，不管成功失败都会被触发
        xhr.onloadend = function (event) {
            console.log('load end');
            //loading(false);
            
        };
      // 发起ajax请求传送数据
        xhr.open('POST', 'content/uploadWebFile', true);
        xhr.send(fd);
	   }
        
    }

	 /*-------------------------------------------------------------------------------------------  */
    //上传附件
	upLoadModel.uploadSlave= function () {
		//将进度条宽度设置为0
		$("#upProgress div[role='progressbar']").css("width",0);
        if($("#slaveFile").val()!=null&& $("#slaveFile").val()!=""){
        // .准备FormData
        var fd = new FormData();
        var files = document.getElementById("slaveFile").files;
        for(var i=0; i< files.length; i++){
        	fd.append("slaveFile"+i, slaveFile.files[i]);
        } 
     

     // 创建xhr对象
        var xhr = new XMLHttpRequest();
     // 监听状态，实时响应
     // xhr 和 xhr.upload 都有progress事件，xhr.progress是下载进度，xhr.upload.progress是上传进度
        xhr.upload.onprogress = function(event) {
	       //如果长度可计算
            if (event.lengthComputable) {
            	//alert("长度可以计算");
                var percent = Math.round(event.loaded *100 / event.total);
                //显示上传了进度
                $("#upprog").text(percent+"%");
                $("#upProgress div[role='progressbar']").css("width",percent+"%");
            }
        };
     // 传输开始事件
        xhr.onloadstart = function(event) {
            console.log('load start');
            //显示进度条
            $("#upProgress").css("display","block");
            //终止上传、隐藏上传按钮
            $("#stopbtn").one('click', function() {
            	//终止当前的网络请求
                xhr.abort();
                $(this).hide();
            });

            //loading(true);
        };
     // ajax过程成功完成事件
        xhr.onload = function(event) {
        	 //上传成功返回数据
            var json=xhr.responseText;
            json=JSON.parse(json);
            console.log(json);
          //doSomething
            if(json.code=='100'){
            	//alert("处理成功");
            	var phy="";
            	var log="";
            	$.each(json.extend.res,function(index,obj){
            		if(index>0){
            			phy+="|";
            			log+="|";
            		}
            		phy+=obj.phyName;
            		log+=obj.logName;
            		
            	});
            	$("#slavesPhyName").val(phy);
            	$("#slavesLogName").val(log);
            }
            
        };
      // ajax过程发生错误事件
        xhr.onerror = function(event) {
            console.log('error');
            $("#upprog").text('发生错误');
        };
      // ajax被取消
        xhr.onabort = function(event) {
            console.log('abort');
            $("#upprog").text('操作被取消');
        };
      // loadend传输结束，不管成功失败都会被触发
        xhr.onloadend = function (event) {
            console.log('load end');
            //loading(false);
        };
      // 发起ajax请求传送数据
        xhr.open('POST', 'slave/upLoadSlaves', true);
        xhr.send(fd);
       }
        
    }
/******************************************************************************/	
/********************文件上传处理结束**********************************************/
/******************************************************************************/

