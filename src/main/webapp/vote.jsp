<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<%@include file="common/top.jsp" %>

<script type="text/javascript">
  $(function(){
	 //获取uploadTest.jsp传递的参数 
	 var vsid=$.getUrlParam("vsid");
	 //加载详情
	 $.getJSON("detailSubject.action",{"VoteSubject.vsid":vsid},function(res){
		
		 if(res.code==200){
			 $("#vote h4").html(res.data.vatitle);
			 $("#vote .info").html("共有 "+res.data.optionNum+"个选项，已有"+res.data.itemNum +" 个网友参与了投票");
		 }
		 
	 });
  });


</script>


</head>
<body>
<div id="header" class="wrap"><img src="images/logo.png" /></div>
<div class="tree"><ul id="mytree" ></ul></div>



<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
			<h4>admin</h4>
			<p class="info"></p>
			<form method="post" action="vote!save.action" onsubmit="return validate();">
				<input type="hidden" name="subject.id" value="1" id="subject_id"/>
				<ol>
				   
					<li><input type="radio" name="options"  value="2"/>123</li>
				   
					<li><input type="radio" name="options"  value="3"/>12</li>
				  	
				</ol>
				<p class="voteView">
					<button>投票</button>
					<a href="vote_result.jsp">查看</a>
				</p>
			</form>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
<script>
$(function(){
	$(".voteView").children("button").button({
		icons: {
			primary: "ui-icon-locked"
		}
	}).next().button({
		icons: {
			primary: "ui-icon-locked"
		}
	});
})

function validate(){
	var options = $("input[name='options']:checked").val();
	if(options== null || options=="undefined" || options.length==0){
		alert("请至少选择一个投票项！");
		return false;
	}
	return true;
}
</script>
</body>
</html>
