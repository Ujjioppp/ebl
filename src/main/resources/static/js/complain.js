/**
 * Created by yeli on 05/07/2017.
 */
$.validator.setDefaults({
    submitHandler: function () {
        var params = $('#publishForm').serialize();
        layer.load();
        $.ajax({
            type: "put",
            url: "complaints/add",
            data: params,
            dataType: "json",
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                layer.closeAll('loading');
                alert(data.suc);
                if (data && data.suc) {
                    location.href = "complaints/" + data.data;
                } else {

                }

            }
        });
        return false;
    }
});
(function ($) {
    $('#publishForm').validate({
        debug: true,
        rules: {
            'corporation.name': 'required',
            title: {
                required: true,
                maxlength: 255
            },
            content: 'required'
        },
        messages: {
            'corporation.name': '必填项',
            title: {
                required: '必填项',
                maxlength: '长度要小于255'
            },
            content: '必填项'
        }
    });

    $('#name').autocomplete({
        source: function (query, process) {
            var matchCount = this.options.items;//返回结果集最大数量
            $.get("/corporation/allList", function (respData) {
                return process(respData.data);
            });
        },
        formatItem: function (item) {
            return item.name;
        },
        setValue: function (item) {
            return {'data-value': item.name, 'real-value': item.id};
        },
        delay: 1000
    });


})(jQuery);