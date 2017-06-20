$(function(){
	
	$.getJSON("content/getAllInfosForIndex",function(result){
		build_infos(result.extend.infos);
	})
})

function build_infos(infos){
	var temp;
	
	$.each(infos.infolist12,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="/content/loadDetail?conId=${info.conId}">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div> <span class="date">'+info.pubTime.substring(0,10)+'</span>'+
		'</li>';
		$("#infolist12").append(temp);
	})
	
	$.each(infos.infolist21,function(index,info){
		temp='<li><div class="article-title">'+
		'<a href="detailLoad.do?urlstring=${info.conId}">'+
		(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
		info.conTitle+'</a>'+
	'</div>'+
	'</li>';
	$("#infolist21").append(temp);
	})
	
	$.each(infos.infolist22,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="detailLoad.do?urlstring=${info.conId}">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist22").append(temp);
	})
	
	$.each(infos.infolist23,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="detailLoad.do?urlstring=${info.conId}">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist23").append(temp);
	})
	
	$.each(infos.infolist31,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="detailLoad.do?urlstring=${info.conId}">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div> '+
		'</li>';
		$("#infolist31").append(temp);
	})
	
	$.each(infos.infolist32,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="detailLoad.do?urlstring=${info.conId}">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist32").append(temp);
	})
}

function enterDetail(){
	
}