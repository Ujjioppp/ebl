/**
 * Created by yeli on 05/07/2017.
 */
(function ($){
    $('#name').autocomplete({
        source:function(query,process){
            var matchCount = this.options.items;//返回结果集最大数量
            $.get("/corporation/allList",function(respData){
                return process(respData.data);
            });
        },
        formatItem:function(item){
            return item.name;
        },
        setValue:function(item){
            return {'data-value':item.name,'real-value':item.id};
        },
        delay:1000
    });
})(jQuery);
