<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@ include file="common/top.jsp" %>
<script >
  $(function(){
	//表格
	     var param = {
	        url: 'loadSubject.action', 
	        pagination: true,
	        method: 'get',
	        toolbar: '#search',
	        striped: true,
	        pageList: [2, 10, 15],
	        clickToSelect: true,
	        pageSize:5,
	        queryParamsType:"undefined",
	        queryParams:function(params){
	        	var tmp = {
	        		pageSize:params.pageSize,
	        		pageNumber:params.pageNumber,
	        		//searchText:$("#searchText").val()
	        	};                	
	        	return tmp;
	        },
	        
	        sidePagination: "server",//分页类型：客户端（client），服务端(server)
	        pageNumber: 1,
	        uniqueId: "id", //每一行的唯一标识，一般为主键列
	        cache: false,     
	        columns: [
		                  {
		                      align: 'center',
		                      radio: true,
		                      title: '选择'
		                  }, 
	                      {
	                          sortable:true,
	                          align: 'center',
	                          field: 'vstitle',
	                          title: '投票标题'
	                      },
	                      {
	                          align: 'center',
	                          field: 'optionNum',
	                          title: '选项数',
	                          titleTooltip: "this is name"
	                      },
	                      {
	                          align: 'center',
	                          field: 'itemNum',
	                          title: '投票人数'
	                      },
	                      {
	                          align: 'center',
	                          formatter:function (value, row, index) {
	                        	  //列的格式化函数 在数据从服务端返回装载前进行处理	                        	  
	                              var tmp='<a href="vote.jsp?vsid="'+row.vsid+'>参加投票</a>';
	                              return tmp;
	                          },
	                          title: '操作'
	                      }]
	                  
	    };
	   var userTable = $("#mygrid").bootstrapTable(param); 
	  
  });


</script>

</head>
<body>
<div id="header" class="wrap"><img src="images/logo.png" /></div>
<div class="tree">
<!--树 -->
<ul id="mytree" ></ul></div>



<div id="index" class="content wrap">
    <div id="tabs">
        <ul>
            <li><a href="vote_list.jsp">返回列表</a></li>
            <li><a href="vote_update.jsp">发布新投票</a></li>
            <li><a href="vote.jsp">参与投票</a></li>
            <li style="float:right;margin:5px 10px 0 0">您好，admin</li>
        </ul>
        <div id="tabs-1">
	        <div class="info">
		        <div class="search">
		            <input id="keywords" class="autoComplete" type="text" name="keywords" value=""/>
		            <input id="gridSearch" class="gridSearch" type="button" name="search" value="搜索" />
		        </div>
		    </div>
        	<table id="mygrid"></table>
        </div>
        <div id="tabs-2">
       
        </div>
    </div>
</div>

<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
</body>
</html>