/**
 * Created by joven on 2017/5/16.
 */
$(function(){
	//获取消息数据
	contentModel.load(1);
	//获取轮播图数据
	slideModel.load(1);
	//当添加图片模态框打开的时候
	$('#modal-addSlide').on('shown.bs.modal', function (e) {
		  slideModel.loadInfoList();
		})
})

//定义消息处理模型
var contentModel={};

//定义轮播图处理模型
var slideModel={};

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
			
			contentModel.build_table(result.extend.pageInfo.list,result.extend.plate);
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
			
			contentModel.build_table(result.extend.pageInfo.list,result.extend.plate);
			//2、解析并显示分页信息
			contentModel.build_nav(result.extend.pageInfo);
			
		
		}
	});
}


//？先查出所有分类
//构建消息列表下拉菜单
contentModel.build_select=function(platelist){
	$("#content select[name='main']").empty();
	//添加选项
	$("#content select[name='main']").append('<option value="all" checked>全部类型</option>')
	$.each(platelist,function(index,plate){
		$("#content select[name='main']").append('<option value="'+plate.plateNo+'">'+plate.plateName+'</option>');
		//添加消息模态框处的下拉菜单
		$("#add-form select").append('<option value="'+plate.plateNo+'">'+plate.plateName+'</option>');
	})
	$("#content select[name='main']").bind("change",function(){
		//如果选项改变，则改变成员变量selectType的值
		contentModel.selectType=$("#content select[name='main']").val();
		contentModel.loadWithoutSelect(1)
	});
	
}

//构建消息列表
contentModel.build_table=function(infolist,platelist){
	
	$("#content_body").empty();
	var plateTemp='<select class="form-control" name="info-select" disabled>'
	$.each(platelist,function(index,plate){
		//
		plateTemp+='<option value="'+plate.plateNo+'">'+plate.plateName+'</option>';
	})
	plateTemp+='</select>';
	$.each(infolist,function(index,item){
	
	    var infoTemp=' <tr > <td><input type="hidden" name="info-conNO" value="'+item.conNo+'"><input name="info-title" type="text"  value="'+item.conTitle+'" class="form-control" readonly ></td>'+
         '<td><input name="sub-title" type="text" value="'+item.subTitle+'" class="form-control" readonly  ></td>'+
         '<td>'+plateTemp+'</td>'+
         '<td><input name="info-author" type="text" value="'+item.author+'" class="form-control" readonly style="width: 100px"></td>'+
         '<td >'+item.publisher+'</td>'+
         '<td>'+(item.editor==null?"":item.editor)+'</td>'+
         '<td>'+(item.modifyTime==null?"":item.modifyTime)+'</td>'+
         '<td>'+item.pubTime+'</td>'+
         '<td><div class="checkbox">'+
             '<label><input name="info-istop" type="checkbox" disabled '+(item.istop=="1"?"checked":"")+'></label>'+
         '</div></td>'+
         '<td><div class="checkbox">'+
             '<label><input name="info-statu" type="checkbox" '+(item.statu=="1"?"checked":"")+' disabled></label>'+
         '</div>'+
         '</td>'+
         '<td>36</td>'+
         '<td><a name="show-slaves">查看附件</a></td>'+
         '<td>'+
             '<div class="btn-group btn-group-sm">'+
                 '<button class="btn btn-primary" name="btn-edit-content">修改</button>'+
                 '<button class="btn btn-primary" name="btn-delete-content">删除</button>'+
             '</div></td>'+
     '</tr>';
	    //temp=temp.replace("#{statu}",item.statu=="1"?checked:"")
             $("#content_body").append(infoTemp);
             $("tbody select[name='info-select']").last().val(item.plateNo)
	});
}

//构建消息分页信息
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
	if($(this).text()=="删除"){
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
	}else{//如果为撤销功能
		$(this).text("删除");
		$(this).prev("button").text("修改");
		$(this).parents("tr").find("input").attr("readonly", true);
		$(this).parents("tr").find("select").attr("disabled", true);
		$(this).parents("tr").find("input[type='checkbox']").attr("disabled", true);
		$(this).parents("tr").css("background-color", "rgba(255, 255, 255, 0)");
		//$(this).parents("tr").find("select").css("background-color", "rgba(255, 255, 255, 0)");
		//$(this).parents("tr").find("input[type='checkbox']").css("background-color", "rgba(255, 255, 255, 0)");
	}
})

//点击修改按钮过后，打开编辑状态
$(document).on("click","button[name='btn-edit-content']",function(){
	if($(this).text()=="修改"){
		$(this).text("保存");
		$(this).siblings("button").text("撤销");
		$(this).parents("tr").find("input").attr("readonly", false);
		$(this).parents("tr").find("select").attr("disabled", false);
		$(this).parents("tr").find("input[type='checkbox']").attr("disabled", false);
		$(this).parents("tr").css("background-color", "#C0FF3E");
		//$(this).parents("tr").find("select").css("background-color", "#C0FF3E");
		//$(this).parents("tr").find("input[type='checkbox']").css("background-color", "#C0FF3E");
	}else{
		//执行修改操作
		contentModel.editContent(this);
		layer.msg("即将保存！");
	}
	
	
})

contentModel.editContent=function(obj){
	var parent=$(obj).parents("tr");
	var infoConNo=$(parent).find("input[name='info-conNO']").val();
	var infoTitle=$(parent).find("input[name='info-title']").val();
	var subTitle=$(parent).find("input[name='sub-title']").val();
	var infoAuthor=$(parent).find("input[name='info-author']").val();
	var infoSelect=$(parent).find("input[name='info-select']").val();
	var infoStatu=($(parent).find("input[name='info-statu']").is(':checked')==true)?1:0;
	var infoIstop=($(parent).find("input[name='info-istop']").is(':checked')==true)?1:0;
	var infodata={"conTitle":infoTitle,"subTitle":subTitle,"author":infoAuthor,
			"plateNo":infoSelect,"istop":infoIstop,"statu":infoStatu,"_method":"PUT"}
	//check infos
	if(infoTitle.length<3){
		layer.msg("标题不能少于三个字！");
	}else{
		$.ajax({
			url:"content/updateContent/"+infoConNo,
			type:"POST",
			data:infodata,
			success:function(result){
				layer.msg(result.msg)
				if(result.code=="100"){
					$(this).text("删除");
					$(this).prev("button").text("修改");
					$(this).parents("tr").find("input").attr("readonly", true);
					$(this).parents("tr").find("select").attr("disabled", true);
					$(this).parents("tr").find("input[type='checkbox']").attr("disabled", true);
					$(this).parents("tr").css("background-color", "rgba(255, 255, 255, 0)");
				}
			}
		})
	}
	//put operation
}



//消息查找
contentModel.doSearch=function(obj){
	/*
	$.ajax({
		url:"content/getAllInfos",
		data:{"pn":"1","type":contentModel.selectType,"contentsForSearch":contentsForSearch},
		type:"get",
		success:function(result){
			console.log(result);
			//1、解析并现实信息
			
			contentModel.build_table(result.extend.pageInfo.list,result.extend.plate);
			//2、解析并显示分页信息
			contentModel.build_nav(result.extend.pageInfo);
			
		
		}
	});*/
}

//刷新数据
contentModel.fresh=function () {
        var index = layer.load(2, {time: 10*1000});
        contentModel.load(1);
    }

//查看附件
$(document).on("click","a[name='show-slaves']",function(){
	var conNo=$(this).parents("tr").find("input[name='info-conNO']").val();
	$.getJSON("slave/getByConNo/"+conNo,function(result){
		if(result.code=="100"){
			$('#modal-showSlaves').modal("show");
			$('#modal-showSlaves div[name="slaves"]').empty();
			$.each(result.extend.slaves,function(index,slave){
				$('#modal-showSlaves div[name="slaves"]').append(slave.logName+'<button type="button" conno="'+slave.conNo+'" class="btn btn-danger btn-sm">删除</button><br/>');
			})
			//为删除按钮绑定事件
			$(document).on("click","#modal-showSlaves div[name='slaves'] button",function(){
				layer.msg("shanchu"+$(this));
			})
			
		}else
			{
			layer.msg("该消息无附件！",{
				time:1000
			});
			}
	})
	
	
})

//删除附件


/******************************************************************************/
/********************消息处理结束**********************************************/
/******************************************************************************/


/******************************************************************************/
/********************轮播图处理开始**********************************************/
/******************************************************************************/


$("#addSlide").on('click',function(){
	console.log("boot")
})
//获取轮播图列表数据
slideModel.load=function(pn){
	$.ajax({
		url:"slide/getAll",
		data:{"pn":pn},
		type:"get",
		success:function(result){
			console.log(result);
			//1、解析并现实信息
			
			slideModel.build_table(result.extend.pageInfo.list);
			//2、解析并显示分页信息
			slideModel.build_nav(result.extend.pageInfo);

		}
	});
}


//构建轮播图列表
slideModel.build_table=function(list){

	$("#slide_body").empty();
	$.each(list,function(index,item){
	if(item.comment==null){
		item.comment="无";
	}
	    var temp=' <tr > <td><input type="hidden" value="'+item.slideId+'"><input name="imgCon" type="text"  value="'+item.imgCon+'" class="form-control" readonly ></td>'+
         '<td><input name="conNO" type="text" value="'+item.conNo+'" class="form-control" readonly  ></td>'+
         '<td><input name="comment" type="text" value="'+item.comment+'" class="form-control" readonly  ></td>'+
         '<td>'+
             '<div class="btn-group btn-group-sm">'+
                 '<button class="btn btn-primary" onclick="contentModel.btnEdit(this)">修改</button>'+
                 '<button class="btn btn-primary" name="btn-delete-slide">删除</button>'+
             '</div></td>'+
     '</tr>'
             $("#slide_body").append(temp);     
	});
}


//构建轮播图分页信息
slideModel.build_nav=function(pageInfo){
	$("#slide-pageinfo").html("当前第"+pageInfo.pageNum+"页,共"+pageInfo.pages+"页，共"+pageInfo.total+"条记录");
	$("#slide-pagenavbar").empty();
	
	if(pageInfo.hasPreviousPage){
		$("#slide-pagenavbar").append('<li><a onclick="slideModel.load(1)">首页</a></li>');
		$("#slide-pagenavbar").append(' <li><a onclick="slideModel.load('+pageInfo.pageNum +'-1)"><<<</a></li>');
	}else{
		$("#slide-pagenavbar").append('<li class="disabled"><a href="#">首页</a></li>');
	}
	$.each(pageInfo.navigatepageNums,function(index,page_Num){
		if(page_Num==pageInfo.pageNum){
			$("#slide-pagenavbar").append('<li  class="active"><a href="#" > '+page_Num+'</a></li>')
			
		}else{
			$("#slide-pagenavbar").append('<li><a onclick="slideModel.load('+page_Num+')"> '+page_Num+'</a></li>')
		}
	});
	
	if(pageInfo.hasNextPage){ 
		$("#slide-pagenavbar").append(' <li><a onclick="slideModel.load('+pageInfo.pageNum +'+1)"> >>> </a></li>');
		$("#slide-pagenavbar").append('<li><a onclick="slideModel.load('+pageInfo.lastPage+')">末页</a></li>');
	}else{
		$("#slide-pagenavbar").append('<li class="disabled"><a href="#" >末页</a></li>');
	}
	 

}


//与消息标题一致选中状态的变化
slideModel.linkToInfo=function(obj){
	if(obj.checked==false){
		$("#modal-addSlide input[name='imgCon']").attr("readonly",false);
	}else{
		$("#modal-addSlide input[name='imgCon']").attr("readonly",true);
	}
}

//提交要添加的轮播图片
//$(document).on("click","#modal-addSlide button[name='commit']","slideModel.upLoadImg");

slideModel.btnAddSlide=function(){
	
}
//添加轮播图
slideModel.addSlide=function(){
	//$("#addPicFile")
	var f=$("#addPicFile").val()
	 if(f==null||f==""){layer.msg("请选择要上传的图片！",{
			time:1000
		});}else{
		 if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f))
	        {

			 layer.msg("图片类型必须是.gif,jpeg,jpg,png中的一种",{
					time:1000
				})
	         // return false;
	        }else{	
	 //如果已经选中与之关联的消息
	 if(slideModel.checkedConNo!=null){
			// .准备FormData
	        var picfd = new FormData();
	        var imgCon=$("#modal-addSlide input[name='imgCon']").val();
			 var comment=$("#modal-addSlide input[name='comment']").val();
			picfd.append("picfile",addPicFile.files[0]);
			picfd.append("conNo",slideModel.checkedConNo);
			picfd.append("imgCon",imgCon);
			picfd.append("comment",comment);
		
		  $.ajax({
				url:'slide/addSlide',
				method:'post',
				contentType:"multipart/form-data",   
				type:"POST",  
				data:picfd,    
				processData: false,  // 告诉jQuery不要去处理发送的数据  
				contentType: false,   // 告诉jQuery不要去设置Content-Type请求头 
				success:function(result){
						layer.msg(result.msg);}
			});  
	
		}
	 else{
		layer.msg("请选择要关联的消息！",{
			time:1500
		});
	 }
	 }
	 }
}

//删除轮播图
$(document).on("click","button[name='btn-delete-slide']",function(){
	var slideId=$(this).parents("tr").find("td:eq(0)").find("input[type='hidden']").val();
	//alert($(this).parents("tr").find("td:eq(0)").find("input[type='hidden']").val())
	layer.confirm('确定删除吗?', {icon: 3, title:'删除消息'}, function(index){
		  //执行删除操纵
		$.ajax({
			url:"slide/deleteBySlideId/"+slideId,
			type:"DELETE",
			success:function(result){
				layer.msg(result.msg,{
					time:1500
				});
			}
		})
		  
		  layer.close(index);
		}); 
})

//加载可关联的消息列表
slideModel.loadInfoList=function(pn){
	if(pn==null){
		pn=1;
	}
	$.ajax({
		url:"content/getAllInfos",
		data:{"pn":pn,"type":"12"},
		type:"get",
		success:function(result){
			//1、解析并现实信息
			$("#modal-addSlide tbody").empty();
			var infoList=result.extend.pageInfo.list;
			$.each(infoList,function(index,obj){
				if(obj.conTitle.length>20){
					obj.conTitle=obj.conTitle.substring(0,18)+"..."
				}
				$("#modal-addSlide tbody").append('<tr><td><input type="hidden" value="'+obj.conNo+'"/>'+obj.conTitle+'</td><td>'+(obj.statu=="1"?"是":"否")+'</td></tr>');
			});
			//点击关联消息-轮播图添加
			$(document).on("click","#modal-addSlide tr",function(){
				var conNo=$(this).find("td:eq(0)").find("input[type='hidden']").val();
				var conTitle=$(this).find("td:eq(0)").text()
				$("input[name='imgCon']").val(conTitle);
				slideModel.checkedConNo=conNo;
				//alert(conNo+"---"+conTitle)
			})
			
			
		}
	})
}



//图片预览
slideModel.picPreview=function(file){
	//$("#addPicFile")
	 var prevDiv = document.getElementById('preview');  
	 if (file.files && file.files[0])  
	 {  
	 var reader = new FileReader();  
	 reader.onload = function(evt){  
	 prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
	}    
	 reader.readAsDataURL(file.files[0]);  
	}  
	 else    
	 {  
	 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
	 }
}

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
		layer.msg('网页文件未选择！',{
			time:1500
		});
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

