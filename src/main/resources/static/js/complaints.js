/**
 * Created by yeli on 05/07/2017.
 */
(function ($){
    var $content = $("#content");

    function loadContent(pageNum) {
        layer.load();
        $.ajax({
            type: "get",
            url: "list",
            data: {pageNum: pageNum-1||0,id:$("#target").val()},
            dataType: "json",
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                layer.closeAll('loading');
                console.log(data)
                if (data && data.data.content) {
                    // 抓取模板数据
                    var template = $('#complaintsTable').html();
                    // 编译模板
                    template = Handlebars.compile(template);
                    // 把数据传送到模板
                    var html = template(data.data);
                    $content.html(html);

                    laypage({
                        cont: 'complaintsPage', //容器。值支持id名、原生dom对象，jquery对象,
                        pages: data.data.pages, //总页数
                        curr: pageNum || 1,
                        skip: true, //是否开启跳页
                        skin: 'molv', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
                        groups: 7, //连续显示分页数
                        jump:function(obj,first){
                            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                loadContent(obj.curr);
                            }
                        }

                    });

                } else {
                    layer.msg('没有更多数据了', function () {
                        //关闭后的操作
                    });
                }

            }
        });
    }


    loadContent();
})(jQuery);
