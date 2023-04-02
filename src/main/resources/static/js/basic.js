$(function () {
    // $("#delbasic").click(setDelete);
    // $("#editbasic").click(edit);
    $("#search").click(search);
    // $("#export").click(exporta);

});
$('#btn_submit2').on('click', function () {
    var id = $("#id").val();
    if (id == "") {
        $.alert({
            title: '提示信息',
            content: '内部错误!',
            buttons: {
                确定: function () {
                    $("#year").focus();

                }
            },

        });
        return;
    }
    var year = $("#year1").val();
    if (year == "") {
        $.alert({
            title: '提示信息',
            content: '年份不能为空!',
            buttons: {
                确定: function () {
                    $("#year").focus();

                }
            },

        });
        return;
    }
    var province = $("#province1").val();
    if (province == "") {
        $.alert({
            title: '提示信息',
            content: '省份不能为空!',
            buttons: {
                确定: function () {
                    $("#province").focus();

                }
            },

        });
        return;
    }
    var  economy = $("#economy1").val();
    var population = $("#population1").val();
    $.confirm({
        title: '提示信息',
        content: '确认要修改吗？',
        icon: 'fa fa-question-circle',
        animation: 'scale',
        closeAnimation: 'scale',
        // opacity: 0.5,
        buttons: {
            'confirm': {
                text: '确定',
                btnClass: 'btn-blue',
                action: function () {
                    //layer.load();

                    $.post(
                        "/basic/update",
                        {
                            id: id,
                            year: year,
                            province: province,
                           economy:economy,
                            population:population
                        },
                        function (data) {
                            data = $.parseJSON(data);
                            if (data.code == 0) {
                                $.alert({
                                    title: '提示信息',
                                    content: '修改成功!',
                                    buttons: {
                                        确定: function () {
                                            window.location.reload();
                                        }
                                    },

                                });
                            } else {
                                alert(data.msg);
                            }
                        }
                    )

                },
            },
            取消: function () {
                //$.alert('你点击了<strong>取消</strong>');
            }
        }
    });
});

function exporta() {
    $.get(
        "/excel/export/basic"
    )
}

// 删除
function setDelete(id) {
    $.post(
        "/basic/del",
        {"id": id},
        function (data) {
            data = $.parseJSON(data);
            if (data.code == 0) {
                location.href = "/basic/list";
            } else {
                alert(data.msg);
            }
        }
    );
}


//修改
function edit(id) {
    $.post(
        "/basic/findById",
        {"id": id},
        function (data) {
            $('#id').attr("value", data.id);
            $('#year1').attr("value", data.year);
            $('#province1').attr("value", data.province);
            $('#economy1').attr("value", data.economy);
            $('#population1').attr("value", data.population);
            $('#updateModal').modal('show');
        }
    );
}

/*加载添加用户信息模态框*/
$("#btn_add").click(function () {
    $("#addModalLabel").text("添加");
    $('#addModal').modal();
});


/*点击关闭模态框后重载页面*/
$("#refresh,#close1,#close2").click(function () {
    window.location.reload();
});

/*点击添加用户模态框的提交按钮*/
$('#btn_submit1').on('click', function () {

        var year = $("#year").val();
        if (year == "") {
            $.alert({
                title: '提示信息',
                content: '年份不能为空!',
                buttons: {
                    确定: function () {
                        $("#year").focus();

                    }
                },

            });
            return;
        }
        var province = $("#province").val();
        if (province == "") {
            $.alert({
                title: '提示信息',
                content: '省份不能为空!',
                buttons: {
                    确定: function () {
                        $("#province").focus();

                    }
                },

            });
            return;
        }
        var  economy = $("#economy").val();
        var population = $("#population").val();
        $.post(
            "/basic/add",
            {
                year: year,
                province: province,
                economy:economy,
                population:population
            },
            function (data) {
                data = $.parseJSON(data);
                // 在提示框中显示返回消息

                if (data.code == 0) {
                    $.alert({
                        title: '提示信息',
                        content: '添加成功!',
                        buttons: {
                            确定: function () {
                                window.location.reload();
                            }
                        },

                    });
                }
            }
        )

    }
)


