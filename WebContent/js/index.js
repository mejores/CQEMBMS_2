$(function(){
	
	$.getJSON("content/getAllInfosForIndex",function(result){
		build_infos(result.extend.infos);
		build_slides(result.extend.slidelist)
	})
})

function build_infos(infos){
	var temp;
	
	$.each(infos.infolist12,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="content/loadDetail.do/'+info.conId+'">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div> <span class="date">'+info.pubTime.substring(0,10)+'</span>'+
		'</li>';
		$("#infolist12").append(temp);
	})
	
	$.each(infos.infolist21,function(index,info){
		temp='<li><div class="article-title">'+
		'<a href="=content/detailLoad.do/'+info.conId+'">'+
		(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
		info.conTitle+'</a>'+
	'</div>'+
	'</li>';
	$("#infolist21").append(temp);
	})
	
	$.each(infos.infolist22,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="=content/detailLoad.do/'+info.conId+'">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist22").append(temp);
	})
	
	$.each(infos.infolist23,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="=content/detailLoad.do/'+info.conId+'">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist23").append(temp);
	})
	
	$.each(infos.infolist31,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="=content/detailLoad.do/'+info.conId+'">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div> '+
		'</li>';
		$("#infolist31").append(temp);
	})
	
	$.each(infos.infolist32,function(index,info){
		temp='<li><div class="article-title">'+
			'<a href="=content/detailLoad.do/'+info.conId+'">'+
			(info.istop==1?'<span style="color:red">[置顶]</span>':'')+
			info.conTitle+'</a>'+
		'</div>'+
		'</li>';
		$("#infolist32").append(temp);
	})
}


function build_slides(slides){
	//alert(slides)
	 $.each(slides,function(index,slide){
			files.push('upload/slides/'+slide.imgPath);
			links.push('=content/detailLoad.do/'+slide.conId);
			texts.push(slide.imgCon);
		})
	/*	$("#slidesForShow").after('<param name="FlashVars" value="borderwidth='
				+ swf_width
				+ '&amp;borderheight='
				+ swf_height
				+ '&amp;textheight='
				+ title_height
				+ '&amp;interval_time='
				+ interval_time
				+ '&amp;pics='
				+ files.join('|')
				+ '&amp;links='
				+ links.join('|')
				+ '&amp;texts='
				+ texts.join('|') + '">');
	*/
	
	
	
	$("#slidesForShow").after('<embed src="'
				+ swf_src
				+ '" wmode="opaque" FlashVars="borderwidth='
				+ swf_width
				+ '&amp;borderheight='
				+ swf_height
				+ '&amp;textheight='
				+ title_height
				+ '&amp;interval_time='
				+ interval_time
				+ '&amp;pics='
				+ files.join('|')
				+ '&amp;links='
				+ links.join('|')
				+ '&amp;texts='
				+ texts.join('|')
				+ '" menu="false" quality="high" width="'
				+ swf_width
				+ '" height="'
				+ focus_height
				+ '" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>');
	
	
	
	$("#slidesForShow").after('<param name="FlashVars" value="borderwidth='
			+ swf_width
			+ '&amp;borderheight='
			+ swf_height
			+ '&amp;textheight='
			+ title_height
			+ '&amp;interval_time='
			+ interval_time
			+ '&amp;pics='
			+ files.join('|')
			+ '&amp;links='
			+ links.join('|')
			+ '&amp;texts='
			+ texts.join('|') + '">'); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function enterDetail(){
	
}