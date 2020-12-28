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
    <link rel="stylesheet" type="text/css" media="screen" href="/jqgrid/css/jquery-ui-custom.css" />

    <link rel="stylesheet" type="text/css" media="screen" href="/jqgrid/css/ui.jqgrid.css" />

    <link rel="stylesheet" type="text/css" media="screen" href="/jqgrid/plugins/searchFilter.css" />

</head>
<body>
<%--大爷进来玩啊！！！--%>

<br/>

<table id="list2"></table>
<div id="pager2"></div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/jqgrid/js/jquery-ui-custom.min.js"></script>
<script src="/jqgrid/js/jquery.layout.js"></script>
<script src="/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script src="/jqgrid/js/jquery.jqGrid.js"></script>
<script src="/jqgrid/plugins/jquery.tablednd.js"></script>
<script src="/jqgrid/plugins/jquery.contextmenu.js"></script>



<script type="text/javascript">
    jQuery("#list2").jqGrid({
        url:'server.php?q=2',
        datatype: "json",
        colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
        colModel:[
            {name:'id',index:'id', width:55},
            {name:'invdate',index:'invdate', width:90},
            {name:'name',index:'name asc, invdate', width:100},
            {name:'amount',index:'amount', width:80, align:"right"},
            {name:'tax',index:'tax', width:80, align:"right"},
            {name:'total',index:'total', width:80,align:"right"},
            {name:'note',index:'note', width:150, sortable:false}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#pager2',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption:"JSON Example"
    });
    jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});

</script>

</body>

<script>


</script>
</html>
