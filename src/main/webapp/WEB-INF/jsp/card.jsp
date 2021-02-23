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
    <div class="col-md-4">
        房间号:<input id="num" value="">
    </div>
</div>
<div class="row">
    <div class="col-md-2">房间人:</div>
    <div class="col-md-4">
        <input id="people" value="">
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


<%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" crossorigin="anonymous"></script>--%>
<script src="/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/js/google-analytics.js" crossorigin="anonymous"></script>

<script src="/viewer/js/viewer.js"></script>
<script src="/viewer/js/main.js"></script>

<!-- Swiper JS -->
<script src="/swiper/package/swiper-bundle.min.js"></script>


<!-- Initialize Swiper -->
<script>
    function getHou() {
        $.get("/card/getHouse", null, function (data) {
            console.log(data)

            if (data == null || data.id == 0) {
                window.location.href = "/error/page"
            } else {
                $("num").attr(data.id);
                $("people").attr()
            }

        })
    }

</script>

<script>

    $("#quit").click(function () {
        $.get("/quit", null, function (data) {
            if (data) {
                window.location.reload();
                alert("操作成功")
            }

        })

    })
</script>

</body>


</html>
