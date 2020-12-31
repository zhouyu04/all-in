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

    <link rel="stylesheet" href="/viewer/css/viewer.css">
    <link rel="stylesheet" href="/viewer/css/main.css">
    <link rel="stylesheet" href="/swiper/package/swiper-bundle.min.css">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>love_secret</title>
</head>
<body>

<form method="post" action="/pic/upload" enctype="multipart/form-data">


    <div class="page-header">
        <div class="form-group">
            <%--<label for="files">上传</label>--%>
            <input type="file" multiple="multiple" name="files" id="files">
        </div>
        <button type="submit" class="btn btn-primary" style="width: 5%">提交</button>


        <%--<jsp:forward page="index2.html"/>--%>
        <button id="year" type="button" class="btn btn-default" style="width: 5%">一点小惊喜呀</button>
    </div>
    <hr/>

    <div class="row swiper-container" id="swiper">
        <div class="swiper-wrapper">

            <ul class="docs-pictures clearfix">
                <div class="col-xs-6 col-md-3">
                    <a class="thumbnail">
                        <li><img id="m1" src="/static/Koala.jpg" alt="Cuo Na Lake"
                                 class="img-thumbnail">
                        </li>
                    </a>
                </div>
                <div class="col-xs-6 col-md-3">
                    <a class="thumbnail">
                        <li><img id="m2" src="/static/Koala.jpg" alt="Tibetan Plateau"
                                 class="img-thumbnail">
                        </li>
                    </a>
                </div>
                <div class="col-xs-6 col-md-3">
                    <a class="thumbnail">
                        <li><img id="m3" src="/static/Koala.jpg" alt="Jokhang Temple"
                                 class="img-thumbnail">
                        </li>
                    </a>
                </div>
                <div class="col-xs-6 col-md-3">
                    <a class="thumbnail">
                        <li><img id="m4" src="/static/Koala.jpg" alt="Potala Palace 1"
                                 class="img-thumbnail">
                        </li>
                    </a>
                </div>
                <div>
                    <input id="page" type="text" value="1">
                </div>
            </ul>
        </div>
        <hr/>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
    </div>



</form>




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

    var pre = "http://121.4.27.171/images/";

    var swiper = new Swiper('.swiper-container', {
        slidesPerView: 3,
        spaceBetween: 30,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        on: {
            //初始化页面数据
            init: function () {
                //去后台获取数据
                $.get("/pic/list", {"pageindex": "1","pagesize":"4"}, function (data, status, xhr) {

                    $.each(data, function (i, val) {
                        var index = i + 1
                        $("#m" + index).attr("src", pre + val.filename)
                    })
                })

                $("#page").attr("value", 1)
                //加载viewer
                fn()
            },
            touchEnd: function (swiper, event) {

                var dir = swiper.swipeDirection
                console.log(dir)
                
                if (dir == undefined) {
                    return
                }
                
                //先将图片都初始化
                var arr = [1, 2, 3, 4];
                $.each(arr, function (i, val) {
                    $("#m" + i).attr("src", "/static/Koala.jpg")
                });

                
                var page = parseInt($("#page").attr("value"))

                if (dir == "next") {
                    console.log(page + 1)
                    //去后台获取数据
                    $.get("/pic/list", {"pageindex": page + 1,"pagesize":"4"}, function (data, status, xhr) {

                        if (data.length >= 4) {
                            $.each(data, function (i, val) {
                                var index = i + 1
                                $("#m" + index).attr("src", pre + val.filename)
                            })
                        } else {
                            $.each(data, function (i, val) {
                                var index = i + 1
                                $("#m" + index).attr("src", pre + val.filename)
                            })
                            for (var i = data.length + 1; i <= 4; i++) {
                                $("#m" + i).attr("src", "/static/Koala.jpg")
                            }

                        }


                    })
                    $("#page").attr("value", page + 1)

                    //加载viewer
                    fn()
                }

                if (dir == "prev") {
                    //去后台获取数据
                    $.get("/pic/list", {"pageindex": page - 1,"pagesize":"4"}, function (data, status, xhr) {

                        if (data.length >= 4) {
                            $.each(data, function (i, val) {
                                var index = i + 1
                                $("#m" + index).attr("src", pre + val.filename)
                            })
                        } else {
                            $.each(data, function (i, val) {
                                var index = i + 1
                                $("#m" + index).attr("src", pre + val.filename)
                            })
                            for (var i = data.length + 1; i <= 4; i++) {
                                $("#m" + i).attr("src", "/static/Koala.jpg")
                            }

                        }

                    })
                    if (page - 1 <= 0) {
                        $("#page").attr("value", 1)
                    } else {
                        $("#page").attr("value", page - 1)
                    }

                    //加载viewer
                    fn()
                }


            }
        }

    });


</script>

<script type="application/javascript">

    $("#year").click(function () {

        window.location.href = "/year/year.html"

    })

</script>

</body>


</html>
