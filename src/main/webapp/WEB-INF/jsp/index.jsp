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
    <link rel="stylesheet" href="/swiper/package/swiper-bundle.min.css">
</head>
<body>
<%--大爷进来玩啊！！！--%>

<br/>

<div class="row">
    <div class="row">
        <div class="col-md-4">这是图片</div>
        <div class="col-md-4">这是打牌</div>
        <div class="col-md-4">.col-md-4</div>
    </div>
</div>


<%--<div class="swiper-container">--%>
<%--<div class="swiper-wrapper">--%>
<%--<div class="swiper-slide">Slide 1</div>--%>
<%--<div class="swiper-slide">Slide 2</div>--%>
<%--<div class="swiper-slide">Slide 3</div>--%>
<%--</div>--%>
<%--<!-- 如果需要分页器 -->--%>
<%--&lt;%&ndash;<div class="swiper-pagination"></div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- 如果需要导航按钮 -->&ndash;%&gt;--%>
<%--<div class="swiper-button-prev"></div>--%>
<%--<div class="swiper-button-next"></div>--%>

<%--&lt;%&ndash;<!-- 如果需要滚动条 -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="swiper-scrollbar"></div>&ndash;%&gt;--%>

<%--</div>--%>
<link rel="stylesheet" href="/bootstrap/js/bootstrap.min.js">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/swiper/package/swiper-bundle.min.js"></script>

<script>
    var mySwiper = new Swiper('.swiper-container', {
        direction: 'vertical', // 垂直切换选项
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
            el: '.swiper-pagination',
        },

        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // 如果需要滚动条
        scrollbar: {
            el: '.swiper-scrollbar',
        },
    })
</script>

</body>

<script>


</script>
</html>
