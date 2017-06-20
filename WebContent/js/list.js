$(function(){
	
	$.getJSON("content/getAllInfosForIndex",function(result){
		build_list(result.extend.infos);
	})
})