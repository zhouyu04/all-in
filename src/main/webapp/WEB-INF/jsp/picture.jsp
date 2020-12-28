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
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>多文件上传</title>
</head>
<body>

<form method="post" action="/pic/upload" enctype="multipart/form-data" class="form-inline">


    <div class="form-group">
        <%--<label for="files">上传</label>--%>
        <input type="file" multiple="multiple" name="files" id="files">
    </div>
    <button type="submit" class="btn btn-primary" style="width: 5%">提交</button>

    <br>

    <form class="form-inline">
        <div class="form-group">
            <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
            <div class="input-group">
                <div class="input-group-addon">$</div>
                <input type="text" class="form-control" id="exampleInputAmount" placeholder="Amount">
                <div class="input-group-addon">.00</div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Transfer cash</button>
    </form>

</form>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>


</body>

<script>


</script>
</html>
