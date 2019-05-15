$(function () {
   $('#grid').datagrid({
       url:'orders_listByPage?t1.type=1',
       columns:[[
           {field:'uuid',title:'编号',width:100},
           {field:'createtime',title:'生成日期',width:100,formatter:formatDate},
           {field:'checktime',title:'审核日期',width:100,formatter:formatDate},
           {field:'starttime',title:'确认日期',width:100,formatter:formatDate},
           {field:'endtime',title:'入库或出库日期',width:100,formatter:formatDate},
           {field:'creater',title:'下单员',width:100},
           {field:'checker',title:'审核员',width:100},
           {field:'starter',title:'采购员',width:100},
           {field:'ender',title:'库管员',width:100},
           {field:'supplieruuid',title:'供应商或客户',width:100},
           {field:'totalmoney',title:'合计金额',width:100},
           {field:'state',title:'状态',width:100,formatter:getState},
           {field:'waybillsn',title:'运单号',width:100},

           {field:'-',title:'操作',width:200,formatter: function(value,row,index){
                   var oper = "<a href=\"javascript:void(0)\" onclick=\"edit(" + row.uuid + ')">修改</a>';
                   oper += ' <a href="javascript:void(0)" onclick="del(' + row.uuid + ')">删除</a>';
                   return oper;
               }}
       ]]
   });
});
//格式化时间
function formatDate(value) {
    return new Date(value).Format('yyyy-MM-dd');
}

/**
 * 获取订单的状态
 * 1:已审核, 2:已确认, 3:已入库；
 */
function getState(value) {
    switch (value * 1) {
        case 0:return '未审核';
        case 1:return '已审核';
        case 2:return '已确认';
        case 3:return '已入库';
        defaule:return '';
    }
}

