$(function () {
    // $("#delEnergy").click(setDelete);
    // $("#editEnergy").click(edit);
    $("#search").click(search);
    // $("#export").click(exporta);

});
    $('#btn_submit2').on('click', function () {
        var id = $("#id").val();
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
        var coal = $("#coal1").val();
        if (coal == "") {
            $.alert({
                title: '提示信息',
                content: '煤炭不能为空!',
                buttons: {
                    确定: function () {
                        $("#coal").focus();

                    }
                },

            });
            return;
        }
        var oil = $("#oil1").val();
        if (oil == "") {
            $.alert({
                title: '提示信息',
                content: '石油不能为空!',
                buttons: {
                    确定: function () {
                        $("#oil").focus();

                    }
                },

            });
            return;
        }
        var gas = $("#gas1").val();
        if (gas == "") {
            $.alert({
                title: '提示信息',
                content: '天然气不能为空!',
                buttons: {
                    确定: function () {
                        $("#gas").focus();
                    }
                },

            });
            return;
        }
        var total = $("#total1").val();
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
                            "/energy/update",
                            {
                                id: id, year: year, province: province, coal: coal, oil: oil, gas: gas,total:total
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
            "/excel/export/energy"
        )
    }

// 删除
    function setDelete(id) {
        $.post(
            "/energy/del",
            {"id": id},
            function (data) {
                data = $.parseJSON(data);
                if (data.code == 0) {
                    location.href = "/energy/list";
                } else {
                    alert(data.msg);
                }
            }
        );
    }


//修改
    function edit(id) {
        $.post(
            "/energy/findById",
            {"id":id},
            function (data) {

                $('#year1').attr("value", data.year);
                $('#province1').attr("value", data.province);
                $('#coal1').attr("value", data.coal);
                $('#gas1').attr("value", data.gas);
                $('#oil1').attr("value", data.oil);
                $('#total1').attr("value", data.total);
                $('#id').attr("value", data.id);
                $('#updateModal').modal('show');
            }
        );
    }

    /*加载添加用户信息模态框*/
    $("#btn_add").click(function () {
        $("#addModalLabel").text("添加用户信息");
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
            var coal = $("#coal").val();
            if (coal == "") {
                $.alert({
                    title: '提示信息',
                    content: '煤炭不能为空!',
                    buttons: {
                        确定: function () {
                            $("#coal").focus();

                        }
                    },

                });
                return;
            }
            var oil = $("#oil").val();
            if (oil == "") {
                $.alert({
                    title: '提示信息',
                    content: '石油不能为空!',
                    buttons: {
                        确定: function () {
                            $("#oil").focus();

                        }
                    },

                });
                return;
            }
            var gas = $("#gas").val();
            if (gas == "") {
                $.alert({
                    title: '提示信息',
                    content: '天然气不能为空!',
                    buttons: {
                        确定: function () {
                            $("#gas").focus();
                        }
                    },

                });
                return;
            }
        var total = $("#total").val();
            $.post(
                "/energy/add",
                {
                    year: year,
                    province: province,
                    coal: coal,
                    gas: gas,
                    oil: oil,
                    total:total
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


