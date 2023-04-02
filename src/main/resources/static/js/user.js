$(function () {
    // $("#deluser").click(setDelete);
    // $("#edituser").click(edit);
    $("#search").click(search);
    // $("#export").click(exporta);

});
$('#btn_submit2').on('click', function () {
    var id = $("#id").val();

    var  username = $("#username1").val();
    var password = $("#password1").val();
    var type = $("#type1").val();
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
                        "/user/update",
                        {
                            id: id,
                            username:username,
                            password:password,
                            type:type
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
        "/excel/export/user"
    )
}

// 删除
function setDelete(id) {
    $.post(
        "/user/del",
        {"id": id},
        function (data) {
            data = $.parseJSON(data);
            if (data.code == 0) {
                location.href = "/user/list";
            } else {
                alert(data.msg);
            }
        }
    );
}


//修改
function edit(id) {
    $.post(
        "/user/findById",
        {"id": id},
        function (data) {
            $('#id').attr("value", data.id);
            $('#username1').attr("value", data.username);
            $('#password1').attr("value", data.password);
            $('#type1').attr("value", data.type);
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


        var  username = $("#username").val();
    var  password = $("#password").val();
        var type = $("#type").val();
        $.post(
            "/user/add",
            {
                username:username,
                password:password,
                type:type
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


