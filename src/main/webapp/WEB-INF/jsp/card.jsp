<%--
  Created by IntelliJ IDEA.
  User: zzyy
  Date: 2018/11/9
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <!-- Bootstrap -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>love_secret</title>
</head>
<body>

${user.username}&nbsp${user.nickname}
<button id="quit">退出</button>
<hr>
<!--显示房间号 -->
<div class="row">
    <div class="col-md-6">
        <table class="table table-bordered">
            <tr>
                <td>
                    房间号:<input id="num" type="text" readonly="readonly">
                </td>
                <td>
                    <div class="col-md-2">房间人:</div>
                    <div class="col-md-4">
                        <input id="people" value="" readonly="readonly">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    状态:<input id="stu" type="text" readonly="readonly">
                </td>
                <td>
                    <button id="join">加入房间</button>
                </td>
            </tr>
        </table>

    </div>

    <div class="col-md-6">
        <table class="table table-bordered">
            <tr>
                <td>局数:<input id="times" type="number"></td>
            </tr>
            <tr>
                <td>
                    <button id="add">创建房间</button>
                </td>
            </tr>
        </table>
    </div>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/bootstrap/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>


<script src="/viewer/js/viewer.js"></script>
<script src="/viewer/js/main.js"></script>

<!-- Swiper JS -->
<script src="/swiper/package/swiper-bundle.min.js"></script>


<!-- Initialize Swiper -->
<script>
    $.get("/card/getHouse", null, function (data) {
        console.log(data)

        var id = data.id;
        if (id > 0) {
            $("#num").val(data.id);
            $("#people").val(data.usernames);
            if (data.status == 0) {
                $("#stu").val("等待中")
            } else if (data.status == 1) {
                $("#stu").val("游戏中")
            } else {
                $("#stu").val("懒得分配状态中")
            }
        }
    })

</script>

<script>

    $("#quit").click(function () {
        $.get("/quit", null, function (data) {
            if (data) {
                window.location.href = "/toCard";
            }

        })

    });

    $("#join").click(function () {
        var num = $("#num").val();
        window.location.href = "/card/join?num=" + num;
    });

    $("#add").click(function () {
        var times = $("#times").val();
        window.location.href = "/card/add?times=" + times;
    })


</script>

</body>


</html>
