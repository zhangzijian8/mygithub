<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@ include file="common/top.jsp" %>

<script >
  $(function(){
	  $("#submitB").click(function(){   	     	
			$.getJSON("addSubject.action",$("#addFrom").serialize(),function(data){
				if(data.code==200){
					longAlert("添加成功", data.msg , myClass[0], 3000);
					
				}else{
					longAlert("添加失败", data.msg , myClass[2], 3000);
				}	
				
			});
			
		});

	  
	  
  });



</script>

</head>


<body>
<div id="header" class="wrap"><img src="images/logo.png" /></div>
<div class="tree"><ul id="mytree" ></ul></div>



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
            
<div class="addVote">
	<h2>发布新投票</h2>
	<div class="vote-content">
		<form method="post" action="#"  id="addFrom" >
			<dl>
				<dt>投票内容：</dt>
				<dd>
				   <input id="voteTitle" type="text" class="input-text" name="voteSubject.vstitle"  value="" title="填入投票内容"/>
				</dd>
				<dt>投票类型：</dt>
				<dd>
		  		   <input type="radio" name="voteSubject.vstype" value="1" />单选
				   <input type="radio" name="voteSubject.vstype" value="2" />多选
				</dd>
				<dt>投票选项：</dt>
				<dd id="voteoptions">
					<p><input type="text" class="input-text" name="option" /></p>
					<p><input type="text" class="input-text" name="option" /></p>
				</dd>
				<dt></dt>
				<dd class="button">
					<input type="button" id="submitB"   style="background-image:url(images/button_submit.gif);width:80px;height:31px;"/>
					<a id="addOption" href="javascript:void(0);" >增加选项</a>
					<a href="subject!list.action">取消操作</a>
				</dd>
			</dl>
		</form>
	</div>
</div>
<div id="dialog-message" title="警告" style="height:80px;width:130px;display:none">
	<p>投票内容不能为空</p>
</div>
<script>
$("#voteTitle").blur(function(){
	var v = $(this).val();
	validateTitle(v);
});
$("#addOption").click(function(){
	var $p=$('<p></p>');
	var $text=$('<input type="text" class="input-text" name="options" />');
	var $del=$('<input type="button" value="删除"/>');
	$del.click(function(){
		$(this).parent().remove();
	});
	$p.append($text).append($del);
	$("#voteoptions").append($p);
});

function validate(){
	  var voteTitle = $('#voteTitle').val();
	
	  return validateTitle(voteTitle);
	
}
 function validateTitle(v){
	if(null==v||''==v){
		$("#dialog-message").dialog({
			modal: true,
			buttons: {
				Ok: function() {
					$(this).dialog( "close" );
				}
			}
		});
		return false;
	}
	return true;
};

 


</script>

        </div>
    </div>
</div>

<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
</body>
</html>