$(function() {
    G = typeof(G) !== 'undefined' ? G : {};
    G.__message && show_head_tip(G.__message);

    var $sidebar_follow = $('#sidebar-follow');
    $sidebar_follow.fixbox({
        distanceToBottom: 300
    });
    $sidebar_follow.css({
        width: $sidebar_follow.parent().width()
    });

    // 绑定enter键
    $(document).on('keydown', '[data-enter-target]',
    function(event) {
        if (event.keyCode == 13) { //enter键
            $($(this).data('enter-target')).trigger('focus').trigger('click');
        }
    });

    // 绑定标签点击事件
    $(document).on('click', '.tags>span',
    function() {
        var $sf = $(this);
        var $pa = $sf.parent();
        if ($pa.hasClass('js-single')) {
            $sf.addClass('active');
            $sf.siblings().removeClass('active');
        } else {
            var maxnum = parseInt($pa.data('maxnum'));
            if (maxnum > 0 && !$sf.hasClass('active')) {
                if ($sf.siblings('.active').length >= maxnum) {
                    show_head_tip('此组标签最多使用 ' + maxnum + ' 个');
                    return;
                }
            }
            $sf.toggleClass('active');
            // 如果有“不限”
            if ($pa.find('.js-reverse').length) {
                var $reverse = $pa.find('.js-reverse');
                if ($sf.hasClass('js-reverse')) {
                    if ($reverse.hasClass('active')) {
                        $reverse.siblings().removeClass('active');
                    } else if ($reverse.siblings('.active').length == 0) {
                        $reverse.addClass('active');
                    }
                } else {
                    if ($reverse.hasClass('active') && $reverse.siblings('.active').length >= 0) {
                        $reverse.removeClass('active');
                    } else if ($reverse.siblings('.active').length == 0) {
                        $reverse.addClass('active');
                    }
                }
            }
        }
        var target_id = $pa.data('target-input-id');
        var $target = $('#' + target_id);
        var $parent = $('#' + $pa.attr('id'));
        if (target_id != '' && $target.length) {
            var tag_value = get_tags($parent, $parent.data('child-key'));
            $target.val(tag_value);
        }
    });
    // 初始值
    $('.tags[data-init-value]').each(function(k, v) {
        var init_value = $(v).data('init-value').toString();
        if (init_value.length) {
            set_tags($(v), $(v).data('init-value'), $(v).data('child-key'));
        }
    });

});

/* ================================================ */
/*                     分割线                        */
/* ================================================ */

function empty_location_hash() {
    if (history && history.replaceState) {
        history.replaceState(null, '', location.pathname + location.search);
    } else {
        location.hash = '';
    }
}

function format_money(value, length, ignore_comma) {
    if (!value || typeof(value) == 'undefined' || value == '') {
        return value;
    }
    var s = value, n = length;
    n = n > 0 && n <= 20 ? n: 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    if (ignore_comma !== false) {
        return s;
    }
    var l = s.split(".")[0].split("").reverse();
    var r = s.split(".")[1];
    var t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
    return t.split("").reverse().join("") + "." + r;
}

function get_browser_infomation() {
    return {
        versions: function() {
            var u = navigator.userAgent,
            app = navigator.appVersion;
            return { //移动终端浏览器版本信息
                trident: u.indexOf('Trident') > -1,
                //IE内核
                presto: u.indexOf('Presto') > -1,
                //opera内核
                webKit: u.indexOf('AppleWebKit') > -1,
                //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,
                //火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/),
                //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
                //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1,
                //android终端或者uc浏览器
                iPhone: u.indexOf('iPhone') > -1,
                //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1,
                //是否iPad
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
            };
        } (),
        language: (navigator.browserLanguage || navigator.language).toLowerCase(),
    };
}

function nl2br(str, is_xhtml) {
    var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br />': '<br>';
    return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1' + breakTag + '$2');
}

function is_ie() {
    return /msie/.test(navigator.userAgent.toLowerCase());
}

function popup_frame(title, content, frame_type) {
    if ($('.popup-frame').hasClass('js-keep') && title == $('.popup-frame .modal-head .fl').text()) {
        $('.popup-frame, .popup-mask').removeClass('hide');
    } else {
        $('.popup-frame, .popup-mask').remove();
        var frame_html = [];
        var frame_type = typeof(frame_type) != 'undefined' ? frame_type: 'default';
        frame_html.push('<div class="dialog modal popup-frame ' + frame_type + '">');
        frame_html.push(' <div class="modal-head">');
        frame_html.push('   <div class="fl">' + title + '</div>');
        frame_html.push('   <div class="fr">×</div>');
        frame_html.push(' </div>');
        frame_html.push(' <div class="modal-body">' + content + '</div>');
        frame_html.push('</div>');
        frame_html.push('<div class="popup-mask"></div>');
        $('body').append(frame_html.join(''));

        $('.popup-frame .modal-head .fr, .popup-frame .js-btn-close').on('click',
        function() {
            if ($('.popup-frame').hasClass('js-keep')) {
                $('.popup-frame, .popup-mask').addClass('hide');
            } else {
                $('.popup-frame, .popup-mask').remove();
            }
        });
    }
}

function rand(min, max) {
    return parseInt(Math.random() * (max - min + 1) + min);
}

// 误关闭页面时提示保存
function before_unload_set(msg) {
    var UnloadConfirm = {};
    if (msg === undefined) {
        msg = "数据尚未保存，离开后可能会导致数据丢失！";
    }
    UnloadConfirm.set = function(a) {
        window.onbeforeunload = function(b) {
            b = b || window.event;
            b.returnValue = a;
            return a;
        }
    };
    UnloadConfirm.set(msg);
}
function before_unload_clear() {
    window.onbeforeunload = function() {}
}

// 显示通知
function show_head_tip(msg, type, delay) {
    if (msg === undefined || msg === "") {
        return;
    }
    var _mt = mt();
    hide_head_tip();
    var is_mobile_html = $('body').width() < 700 ? ' mini': '';
    $('body').prepend('<div id="_m' + _mt + '" class="__message' + is_mobile_html + '">' + msg + '<div class="_m_btn_close">×</div></div>');
    $('.__message>._m_btn_close').on('click',
    function() {
        hide_head_tip();
    });
    // 自动识别成功、失败
    if (type === undefined) {
        if (msg.indexOf('成功') !== -1) {
            type = 'success';
        } else if (msg.indexOf('失败') !== -1 || msg.indexOf('错误') !== -1 || msg.toUpperCase().indexOf('ERROR') !== -1 || msg.indexOf('出错') !== -1) {
            type = 'error';
        }
    }
    if (type == 'error') {
        $('#_m' + _mt).css({
            background: '#FA3F54',
            border: '1px solid #BD362F'
        });
    } else if (type == 'success') {
        $('#_m' + _mt).css({
            background: '#5BB75B',
            border: '1px solid #51A351'
        });
    }
    $('#_m' + _mt).fadeIn(120);

    // 自适应长度显示时间
    if (!delay) {
        if (msg.length > 30) {
            delay = 11000;
        } else if (msg.length > 20) {
            delay = 8000;
        } else if (msg.length > 10) {
            delay = 5000;
        } else {
            delay = 2000;
        }
    }

    setTimeout(function() {
        $('#_m' + _mt).fadeOut();
    },
    delay);
}
function hide_head_tip() {
    $('.__message').remove();
}

// cookie读写函数
function ck(k, v) {
    var prefix = G.ckprefix || '';
    var ckpath = G.ckpath || '/';
    // 如果直接调用ck()，则返回document.cookie
    if (typeof(k) == 'undefined' && typeof(v) == 'undefined') return document.cookie;
    // 如果用==，则V为0时也将失效
    if (typeof(v) == 'undefined') return $.cookie(prefix + k); //v===''
    return $.cookie(prefix + k, v, {
        path: ckpath
    });
}

// 本地kv方法
function kv(k, v) {
    if (typeof(k) == 'undefined' && typeof(v) == 'undefined') {
        return window.localStorage;
    }
    if (typeof(v) == 'undefined') {
        return window.localStorage.getItem(k);
    }
    return window.localStorage.setItem(k, v);
}

// 引自php
function deb(o) {
    console.log(get_obj(o));
}

// 返回当前时间戳
function time(cmd) {
    if (cmd == '-mt') return new Date().getTime();
    return Date.parse(new Date()) / 1000;
}

function mt() {
    return time('-mt');
}

/**
 * 模仿PHP的strtotime()函数
 * strtotime('2012-07-27 12:43:43') OR strtotime('2012-07-27')
 * @return 时间戳
 */
function strtotime(str) {
    if (!str || str == '') {
        return 0;
    }
    if (str.indexOf('/') !== -1 && str.length == 16) {
        str = str.replace(/\//g, '-') + ':00';
    }
    var _arr = str.split(' ');
    var _day = _arr[0].split('-');
    _arr[1] = (_arr[1] == null) ? '0:0:0': _arr[1];
    var _time = _arr[1].split(':');
    for (var i = _day.length - 1; i >= 0; i--) {
        _day[i] = isNaN(parseInt(_day[i])) ? 0 : parseInt(_day[i]);
    };
    for (var i = _time.length - 1; i >= 0; i--) {
        _time[i] = isNaN(parseInt(_time[i])) ? 0 : parseInt(_time[i]);
    };
    var _temp = new Date(_day[0], _day[1] - 1, _day[2], _time[0], _time[1], _time[2]);
    return _temp.getTime() / 1000;
}
// 加0
var fix_time = function(t) {
    if (t <= 9) {
        return '0' + t;
    } else {
        return t;
    }
}
/**
 * 模仿PHP的date()函数
 * strtotime('Y-m-d H:i:s');
 * @param format 支持的调用方式： 'Y-m-d H:i:s', 'Y/m/d H:i','Y-m-d','H:i:s'
 * @param time 为空时，取当前时间
 * @return 日期格式化的字符串
 */
function date(format, time) {
    var _temp = (time != null) ? new Date(time * 1000) : new Date();
    var _return = '';
    var _day = [_temp.getFullYear(), fix_time(1 + _temp.getMonth()), fix_time(_temp.getDate())];
    if (/Y-m-d/.test(format)) {
        _return = _day.join('-');
    } else if (/Y\/m\/d/.test(format)) {
        _return = _day.join('/');
    }
    if (/H:i:s/.test(format)) {
        var _time = [fix_time(_temp.getHours()), fix_time(_temp.getMinutes()), fix_time(_temp.getSeconds())];
    } else if (/H:i/.test(format)) {
        var _time = [fix_time(_temp.getHours()), fix_time(_temp.getMinutes())];
    }
    _return += ' ' +_time.join(':');
    return _return;
}

// 返回datetime
function dt(timestamp) {
    timestamp = timestamp || Date.parse(new Date()) / 1000;
    var now = new Date(timestamp * 1000);
    var years = now.getFullYear();
    var months = fix_time(now.getMonth() + 1);
    var date = fix_time(now.getDate());
    var hours = fix_time(now.getHours());
    var minutes = fix_time(now.getMinutes());
    var seconds = fix_time(now.getSeconds());
    return years + "-" + months + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
}

// bootstrap button function
!
function(a) {
    var b = function(b, c) {
        this.$element = a(b),
        this.options = a.extend({},
        a.fn.button.defaults, c)
    };
    b.prototype.setState = function(a) {
        var b = "disabled",
        c = this.$element,
        d = c.data(),
        e = c.is("input") ? "val": "html";
        a += "Text",
        d.resetText || c.data("resetText", c[e]()),
        c[e](d[a] || this.options[a]),
        setTimeout(function() {
            a == "loadingText" ? c.addClass(b).attr(b, b) : c.removeClass(b).removeAttr(b)
        },
        0)
    },
    b.prototype.toggle = function() {
        var a = this.$element.closest('[data-toggle="buttons-radio"]');
        a && a.find(".active").removeClass("active"),
        this.$element.toggleClass("active")
    };
    var c = a.fn.button;
    a.fn.button = function(c) {
        return this.each(function() {
            var d = a(this),
            e = d.data("button"),
            f = typeof c == "object" && c;
            e || d.data("button", e = new b(this, f)),
            c == "toggle" ? e.toggle() : c && e.setState(c)
        })
    },
    a.fn.button.defaults = {
        loadingText: "操作中"
    },
    a.fn.button.Constructor = b,
    a.fn.button.noConflict = function() {
        return a.fn.button = c,
        this
    },
    a(document).on("click.button.data-api", "[data-toggle^=button]",
    function(b) {
        var c = a(b.target);
        c.hasClass("btn") || (c = c.closest(".btn")),
        c.button("toggle")
    })
} (window.jQuery);

// cookie封装
jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') {
        if (typeof(options) == "undefined") options = {};
        options.expires = options.expires | 90;
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString();
        }
        var path = options.path ? '; path=' + options.path: '';
        var domain = options.domain ? '; domain=' + options.domain: '';
        var secure = options.secure ? '; secure': '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};

/**************     go-top     ********************/
GoTop = function() {
    this.config = {
        pageWidth: $('.header>.container').width() || 980,
        nodeId: '_go-top_',
        nodeClass: '_square',
        nodeWidth: 49,
        distanceToBottom: 190,
        distanceToPage: 25,
        hideRegionHeight: 130,
        text: '返回顶部'
    };
    this.cache = {
        topLinkThread: null
    }
};
GoTop.prototype = {
    init: function(config) {
        this.config = $.extend(true, {},
        this.config, config);
        var _self = this;
        jQuery(window).scroll(function() {
            _self._scrollScreen({
                _self: _self
            });
        });
        jQuery(window).resize(function() {
            _self._resizeWindow({
                _self: _self
            });
        });
        _self._insertNode({
            _self: _self
        });
    },
    _insertNode: function(args) {
        var _self = args._self;
        var topLink = jQuery('<a id="' + _self.config.nodeId + '" class="' + _self.config.nodeClass + '" href="#">' + _self.config.text + '</a>');
        var go_top_use_time = $(document).height() > 2000 ? 400 : 250;
        topLink.click(function() {
            jQuery('html,body').animate({
                scrollTop: 0
            },
            go_top_use_time);
            return false;
        }).appendTo(jQuery('body'));
        var right = _self._getDistanceToBottom({
            _self: _self
        });
        if (/MSIE 6/i.test(navigator.userAgent)) {
            topLink.css({
                'display': 'none',
                'position': 'absolute',
                'right': right + 'px'
            });
        } else {
            topLink.css({
                'display': 'none',
                'position': 'fixed',
                'right': right + 'px',
                'top': (jQuery(window).height() - _self.config.distanceToBottom) + 'px'
            });
        }
    },
    _scrollScreen: function(args) {
        var _self = args._self;
        var topLink = jQuery('#' + _self.config.nodeId);
        if (jQuery(document).scrollTop() <= _self.config.hideRegionHeight) {
            clearTimeout(_self.cache.topLinkThread);
            topLink.hide();
            return;
        }
        if (/MSIE 6/i.test(navigator.userAgent)) {
            clearTimeout(_self.cache.topLinkThread);
            topLink.hide();
            _self.cache.topLinkThread = setTimeout(function() {
                var top = jQuery(document).scrollTop() + jQuery(window).height() - _self.config.distanceToBottom;
                topLink.css({
                    'top': top + 'px'
                }).fadeIn();
            },
            400);
        } else {
            topLink.fadeIn();
        }
    },
    _resizeWindow: function(args) {
        var _self = args._self;
        var topLink = jQuery('.' + _self.config.nodeClass);
        var right = _self._getDistanceToBottom({
            _self: _self
        });
        var top = jQuery(window).height() - _self.config.distanceToBottom;
        if (/MSIE 6/i.test(navigator.userAgent)) {
            top += jQuery(document).scrollTop();
        }
        topLink.css({
            'right': right + 'px',
            'top': top + 'px'
        });
        if (typeof(topLink[1]) != 'undefined') {
            $(topLink[1]).css({
                'top': (top + 60) + 'px'
            });
        }
    },
    _getDistanceToBottom: function(args) {
        var _self = args._self;
        var right = parseInt((jQuery(window).width() - _self.config.pageWidth + 1) / 2 - _self.config.nodeWidth - _self.config.distanceToPage, 10);
        if (right < 10) {
            right = 10;
        }
        return right;
    }
};

/************** sidebar-follow ********************/
(function($, window, document, undefined) {
    var $win = $(window);
    var $document = $(document);
    var FixBox = function(element, options) {
        this.initialize('fixbox', element, options);
    };
    FixBox.prototype = {
        constructor: FixBox,
        initialize: function(type, element, options) {
            var _this = this;
            this.type = type;
            this.$element = $(element);
            this.options = this.options || this.getOptions(options);
            this.winH = $win.height();
            this.winW = $win.width();
            if (this.options.isFixdeHeight) {
                this.fixedBoxH = this.$element.outerHeight(true);
            }
            this.offsetT = this.$element.offset().top;
            this.resizeWindow();
            this.documentH = $document.height();
            $win.bind("resize",
            function() {
                _this.resizeWindow();
            });
        },
        getOptions: function(options) {
            options = $.extend({},
            $.fn[this.type].defaults, this.$element.data(), options || {});
            return options;
        },
        resizeWindow: function() {
            var options = this.options;
            var _this = this;
            this.winH = $win.height();
            this.winW = $win.width();
            if (this.winW >= options.pagewidth) {
                this.doFix();
                $win.unbind("." + options.scrollEventName);
                $win.bind("scroll." + options.scrollEventName,
                function() {
                    _this.doFix();
                });
            } else {
                $win.unbind("." + options.scrollEventName);
                this.$element.css("position", "static");
            }
        },
        doFix: function() {
            var $element = this.$element;
            var options = this.options;
            var distanceToBottom = options.distanceToBottom;
            var distanceToTop = options.distanceToTop;
            if (!this.options.isFixdeHeight) {
                this.fixedBoxH = $element.outerHeight(true);
            }
            var fixedBoxH = this.fixedBoxH;
            var offsetT = this.offsetT;
            var fixedBoxPositionB = fixedBoxH + this.offsetT;
            var winH = this.winH;
            if (!options.isFixdeDocHeight) {
                this.documentH = $document.height();
            }
            var documentH = this.documentH;
            if (fixedBoxPositionB + distanceToBottom - options.threshold >= documentH) {
                return;
            }
            var scrollNum = fixedBoxPositionB - winH;
            var winST = $win.scrollTop();
            if (fixedBoxH < (winH - distanceToTop)) {
                if (winST > offsetT) {
                    if (winST >= (documentH - distanceToBottom - fixedBoxH)) {
                        $element.css({
                            "position": "fixed",
                            "top": -(winST + distanceToBottom + fixedBoxH - documentH)
                        });
                    } else {
                        $element.css({
                            "position": "fixed",
                            "top": distanceToTop
                        });
                    }
                } else {
                    $element.css("position", "static");
                }
            } else {
                if (winST > scrollNum) {
                    if (winST > (documentH - winH - distanceToBottom)) {
                        $element.css({
                            "position": "fixed",
                            "top": -(winST + distanceToBottom + fixedBoxH - documentH)
                        });
                    } else {
                        $element.css({
                            "position": "fixed",
                            "top": winH - fixedBoxH
                        });
                    }
                } else {
                    $element.css("position", "static");
                }
            }
        }
    };
    $.fn.fixbox = function(option) {
        var argumentsAry = [];
        for (var i = 0,
        len = arguments.length; i < len; i++) {
            argumentsAry.push(arguments[i]);
        }
        var newarg = argumentsAry.slice(1);
        return this.each(function() {
            var $this = $(this),
            data = $this.data('fixbox'),
            options = typeof option == 'object' && option;
            if (!data) {
                data = new FixBox(this, options);
                $this.data('fixbox', data);
            }
            if (typeof argumentsAry[0] == 'string') {
                data[argumentsAry[0]].apply(data, newarg);
            }
        });
    };
    $.fn.fixbox.Constructor = FixBox;
    $.fn.fixbox.defaults = {
        distanceToTop: 5,
        distanceToBottom: 99,
        isFixdeHeight: true,
        isFixdeDocHeight: false,
        pagewidth: 1000,
        threshold: 0,
        scrollEventName: "followScroll"
    };
})(window.jQuery, window, document);

/***************** Overload ************************/
Overload = function(fn_objs) {
    var is_match = function(x, y) {
        if (x == y) {
            return true
        }
        if (x.indexOf("*") == -1) {
            return false
        }
        var x_arr = x.split(","),
        y_arr = y.split(",");
        if (x_arr.length != y_arr.length) {
            return false
        }
        while (x_arr.length) {
            var x_first = x_arr.shift(),
            y_first = y_arr.shift();
            if (x_first != "*" && x_first != y_first) {
                return false
            }
        }
        return true
    };
    var ret = function() {
        var args = arguments,
        args_len = args.length,
        args_types = [],
        args_type,
        fn_objs = args.callee._fn_objs,
        match_fn = function() {};
        for (var i = 0; i < args_len; i++) {
            var type = typeof args[i];
            type == "object" && (args[i].length > -1) && (type = "array");
            args_types.push(type)
        }
        args_type = args_types.join(",");
        for (var k in fn_objs) {
            if (is_match(k, args_type)) {
                match_fn = fn_objs[k];
                break
            }
        }
        return match_fn.apply(this, args)
    };
    ret._fn_objs = fn_objs;
    return ret
};
String.prototype.format = Overload({
    "array": function(params) {
        var reg = /{(\d+)}/gm;
        return this.replace(reg,
        function(match, name) {
            return params[~~name]
        })
    },
    "object": function(param) {
        var reg = /{([^{}]+)}/gm;
        return this.replace(reg,
        function(match, name) {
            return param[name]
        })
    }
});