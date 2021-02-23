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
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--大爷进来玩啊！！！--%>

<br/>

<div class="row">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <input id="username" name="username" type="text" value="" placeholder="请输入用户名">
            <input id="submit" type="submit" value="确定">
        </div>
        <div class="col-md-4"></div>
    </div>

</div>


<script src="/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>


<script>
    $("#submit").click(function () {
        var username = $('#username').val();
        $.get("/check/user", {"username": username}, function (data) {
            if (data == null || data.id == 0) {
                window.location.href = "/error/page"
            } else {
                window.location.href = "/card"
            }

        })
    })
</script>

</body>

<script>


</script>
</html>
