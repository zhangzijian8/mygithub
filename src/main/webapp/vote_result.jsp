<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="jq/1.11.1/jquery.min.js"></script>
</head>
<body>
<div id="header" class="wrap"><img src="images/logo.png" /></div>
<div class="tree"><ul id="mytree" ></ul></div>



<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		<li>
			<h4>admin</h4>
			<p class="info">共有 2 个选项，已有 0 个网友参与了投票。</p>
			<ol>
			   
				<li>
					<div class="rate">
						<div class="ratebg" data=""></div>
						<p>票<span>(%)</span></p>
					</div>
				</li>
			   
				<li>
					<div class="rate">
						<div class="ratebg" data=""></div>
						<p>票<span>(%)</span></p>
					</div>
				</li>
			  	
			</ol>
			<div class="goback"><a href="vote_list.jsp">返回投票列表</a></div>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
<script>
$(".ratebg").each(function(i,ele){
	var v = parseInt($(ele).attr("data"));
	$(ele).progressbar({
		value: v
	});
});
</script>
</body>
</html>
