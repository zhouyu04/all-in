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

    <!--jqueryui-->
    <link href="//cdn.bootcss.com/jqueryui/1.12.0-rc.2/jquery-ui.min.css" rel="stylesheet">
    <!--jqgrid的css-->
    <link href="//cdn.bootcss.com/jqgrid/4.6.0/css/ui.jqgrid.css" rel="stylesheet">


    <!--jquery-->
    <script src="//cdn.bootcss.com/jquery/3.0.0-beta1/jquery.min.js"></script>
    <!--locale-->
    <script src="//cdn.bootcss.com/jqgrid/4.6.0/js/i18n/grid.locale-en.js"></script>
    <!--jqgrid的js-->
    <script src="//cdn.bootcss.com/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>


    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>love_secret</title>
</head>
<body>

${user.username}&nbsp${user.nickname}

<hr>
<!--显示房间号 -->
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
                <button id="join">开始游戏</button>
            </td>
        </tr>
    </table>

</div>
<hr>
<table style="text-align: center" id="list2"></table>
<input type="BUTTON" id="bedata" value="Edit Selected"/>
<%--<div id="jqGridPager"></div>--%>
<hr>
<div class="form-group">
    <label for="exampleInputEmail1">第${cardNum}局</label>
    <input id="newScore" type="number" class="form-control" id="exampleInputEmail1" placeholder="注意正负数">
    <button id="addNew" type="submit" class="btn btn-default">Submit</button>
</div>

</body>

<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>


<script type="text/javascript">
    var card_num = 0;

    $.get("/card/getHouse", null, function (data) {
        console.log(data)


        $("#num").val(data.id);
        card_num = card_num + data.id;
        console.log("get:" + card_num);
        $("#people").val(data.usernames);
        if (data.status == 0) {
            $("#stu").val("等待中")
        } else if (data.status == 1) {
            $("#stu").val("游戏中")
        } else {
            $("#stu").val("懒得分配状态中")
        }

        pageInit(card_num);
    });


    function pageInit(card_num) {

        $("#list2").jqGrid({
            url: "/card/getRecord?num=" + card_num,
            datatype: "json",
            colModel: [
                {label: 'ID', name: 'id', index: 'id'},
                {label: '局数', name: 'index', index: 'index'},
                {
                    label: '军师',
                    name: 'zy',
                    editable: true,
                    editrules: {edithidden: true, required: true, number: true},
                    index: 'zy'
                },
                {
                    label: '院长',
                    name: 'zk',
                    editable: true,
                    editrules: {edithidden: true, required: true, number: true},
                    index: 'zk'
                },
                {
                    label: '舒放',
                    name: 'sf',
                    editable: true,
                    editrules: {edithidden: true, required: true, number: true},
                    index: 'sf'
                }
            ],
            jsonReader: {//来跟服务器端返回的数据做对应
                root: "rows",//包含实际数据的数组
                page: "page",//当前页
                total: "total",//总页数
                records: "records"//查询出的记录数
            },
            autowidth: true,
            gridComplete: completeMethod,

            editurl: "/card/edit",

            footerrow: true,
            caption: "战绩"
        });
    };


    /*统计功能 */
    function completeMethod() {
        var c1 = $("#list2").getCol('zy', false, 'sum');
        var c2 = $("#list2").getCol('zk', false, 'sum');
        var c3 = $("#list2").getCol('sf', false, 'sum');
        $("#list2").footerData('set', {"id": '合计', zy: c1, zk: c2, sf: c3});

    };


    $("#bedata").click(function () {
        var gr = jQuery("#list2").jqGrid('getGridParam', 'selrow');
        console.log(gr)
        if (gr != null)
            jQuery("#list2").jqGrid('editGridRow', gr, {
                height: 300,
                reloadAfterSubmit: true
            });
        else
            alert("Please Select Row");
    });


    $("#addNew").click(function () {

        var val = $("#newScore").val();
        //保存去后台


    })



</script>

<script>


</script>


</html>
