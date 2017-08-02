/**
 * Created by yeli on 05/07/2017.
 */
(function ($){
    var pageNum = 0,
        $tiles = $('#tiles'),
        $handler = $('li', $tiles),
        $main = $('#main'),
        $window = $(window),
        $document = $(document),
        options = {
            autoResize: true, // This will auto-update the layout when the browser window is resized.
            container: $main, // Optional, used for some extra CSS styling
            offset: 20, // Optional, the distance between grid items
            itemWidth:300 // Optional, the width of a grid item
        };

    function loadContent(pageNum) {
        layer.load();
        $.ajax({
            type:"get",
            url:"corporation/list",
            data:{pageNum:pageNum||1,name:$("input[name='name']").val()},
            dataType:"json",
            complete: function(XMLHttpRequest, textStatus) {},
            success:function(data){
                layer.closeAll('loading');
                console.log(data);
                if(data){
                    // 抓取模板数据
                    var template = $('#indexLi').html();
                    // 编译模板
                    template = Handlebars.compile(template);
                    // 把数据传送到模板
                    var html = template(data.data);
                    $tiles.html(html);

                    applyLayout();
                    laypage({
                        cont: 'indexPage', //容器。值支持id名、原生dom对象，jquery对象,
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
                }else{
                    layer.msg('没有更多数据了', function(){
                        //关闭后的操作
                    });
                }

            }
        });
    }

    /**
     * Reinitializes the wookmark handler after all images have loaded
     */
    function applyLayout() {
        $tiles.imagesLoaded(function() {
            // Destroy the old handler
            if ($handler.wookmarkInstance) {
                $handler.wookmarkInstance.clear();
            }

            // Create a new layout handler.
            $handler = $('li', $tiles);
            $handler.wookmark(options);
        });
    }

    // Call the layout function for the first time
    applyLayout();
    loadContent();

    // Capture scroll event.
    // $window.bind('scroll.wookmark', onScroll);
})(jQuery);