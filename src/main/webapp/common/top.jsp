<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%
	//url : http://ip:port/项目名称		
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
%>
<base href="<%=basePath %>"/>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<!-- bootstrap css-->
    <link rel="stylesheet" href="component/dist/css/bootstrap.css"/>
    <!-- jQuery 库-->
    <script src="jq/1.11.1/jquery.min.js"></script>
    <!-- bootstrap 核心库-->
    <script src="component/dist/js/bootstrap.js"></script>

    <!-- bootstrp table-->
    <link rel="stylesheet" href="component/bootstrap-table/bootstrap-table.css"/>
    <script src="component/bootstrap-table/bootstrap-table.js"></script>
    <script src="component/bootstrap-table/bootstrap-table-zh-CN.js"></script>

    <!--bootstrap-date -->
    <link rel="stylesheet" href="component/bootstrap-date/bootstrap-datetimepicker.css"/>
    <script src="component/bootstrap-date/moment-with-locales.js" type="text/javascript"></script>
    <script src="component/bootstrap-date/bootstrap-datetimepicker.js" type="text/javascript"></script>

    <!-- bootstrap-fileupload-->
    <link rel="stylesheet" href="component/bootstrap-fileinput/css/fileinput.css"/>
    <script src="component/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
    <script src="component/bootstrap-fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>

      <!-- 所见即所得tinymce -->
      <script src="component/tinymce/js/tinymce/tinymce.min.js"></script>
     
    <!-- 自定义组件-->
    <script src="component/my/myAlert.js"></script>
     <script src="component/my/date_format.js"></script>
    <style>
        #accordion .panel-body li {
            line-height: 30px;
        }
    </style>
