$(function(){
    // 顶部大图片切换
    var bgi = 0;
    var bgnum = $('#bg-top-ct').attr('data-bgnum');
    bgnum = parseInt(bgnum) || 1;
    if (bgnum >= 2) {
        setInterval(function(){
            bgi = ++bgi%bgnum;
            $('#bg-top-ct').animate({opacity: 0.11},700,function(){
                $('#bg-top-ct').css({'background-image':'url(static/bann/bg-top'+bgi+'.jpg?'+G.version+')'}).animate({opacity: 1},700)
            });
        }, 7E3);
    }
    // 增加dashline
    if ($('.right-article-list').length) {
        add_dashline($('.right-article-list>.list-article>li:eq(14)'));
        add_dashline($('.right-article-list>.list-article>li:eq(9)'));
        add_dashline($('.right-article-list>.list-article>li:eq(4)'));
    }
});

function add_dashline($ta){
    if ($ta.length) {
        $ta.after('<li class="dashline"></li>');
    }
}

function add_favorite(sURL, sTitle){
    if(sURL == '') sURL = window.location.href;
    if(sTitle == '') sURL = $('title').text();
    try{
        window.external.addFavorite(sURL, sTitle);
    }
    catch (e){
        try{
            window.sidebar.addPanel(sTitle, sURL, "");
        }
        catch (e){
            alert("您的浏览器较高级，请使用 Ctrl+D 进行添加");
        }
    }
}