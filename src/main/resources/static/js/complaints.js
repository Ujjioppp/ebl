/**
 * Created by yeli on 05/07/2017.
 */
(function ($){
    var pageNum = 0,
        $content = $("#content"),
        $main = $('#main'),
        $window = $(window),
        $document = $(document);

    function loadContent() {
        layer.load();
        $.ajax({
            type: "get",
            url: "list",
            data: {pageNum: pageNum++,id:$("#target").val()},
            dataType: "json",
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                layer.closeAll('loading');
                if (data && data.data.content) {
                    // 抓取模板数据
                    var template = $('#complaintsTable').html();
                    // 编译模板
                    template = Handlebars.compile(template);
                    // 把数据传送到模板
                    var html = template(data.data);
                    $content.append(html);
                    if(data.data.last) {
                        console.log('unbind');
                        //最后一页,解绑翻页
                        $window.unbind('scroll.wookmark', onScroll);
                    }
                } else {
                    layer.msg('没有更多数据了', function () {
                        //关闭后的操作
                    });
                }

            }
        });
    }

    /**
     * When scrolled all the way to the bottom, add more tiles
     */
    function onScroll() {
        // Check if we're within 100 pixels of the bottom edge of the broser window.
        var winHeight = window.innerHeight ? window.innerHeight : $window.height(), // iphone fix
            closeToBottom = ($window.scrollTop() + winHeight > $document.height() - 100);

        if (closeToBottom) {
            loadContent();
        }
    };

    loadContent();

    // Capture scroll event.
    $window.bind('scroll.wookmark', onScroll);
})(jQuery);
