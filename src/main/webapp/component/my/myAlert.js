/**
 * Created by tanglc on 2016/11/30.
 */
//成功，警告，危险
var myClass = ['alert-success', 'alert-warning', 'alert-danger'];

/**
 * 警告框
 * @param title 提示标题
 * @param content 提示内容
 * @param myclass 显示的效果的类型样式
 * @param mytime 显示时间
 */
function longAlert(title, content, myclass, mytime) {
    var div = '<div class="alert ' + myclass + '" style="position: fixed;top: 0px;left: 0px;width: 100%;display: none;text-align: center;">';
    div = div + '<a href="#" class="close" data-dismiss="alert">&times;</a>'
    div = div + '<strong>' + title + '！</strong>' + content + '</div>';
    var $div = $(div);
    $("body").append($div);
    $div.slideDown();
    var timer = setTimeout(function () {
        $div.slideUp();
        clearTimeout(timer);
    }, mytime);
}



