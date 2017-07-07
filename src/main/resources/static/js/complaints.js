/**
 * Created by yeli on 07/07/2017.
 */
var pageNum = 0;
var $content = $(".container-fluid.table-responsive");
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
                Handlebars.registerHelper("addOne", function (index, options) {
                    return parseInt(index) + 1;
                });
                // 把数据传送到模板
                var html = template(data.data);
                $content.html(html);
                $('#pageToolbar').Paging({pagesize:data.data.size,count:data.data.totalElements,toolbar:true});
            } else {
                layer.msg('没有更多数据了', function () {
                    //关闭后的操作
                });
            }

        }
    });
}


$(function () {
    loadContent();
});