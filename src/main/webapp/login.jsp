<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="jq/1.11.1/jquery.min.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.png" />
</div>
<div id="login" class="wrap">
	<div class="main">
		<div class="corner"></div>
		<div class="introduce">
			<h2>合众艾特</h2>
			<p>网上调查系统...</p>
		</div>
		<div class="login">
			<h2>用户登录</h2>
			<form method="post" action="loginUser.action">
				<dl id="loginBox">
					<dt>用户名：</dt>
					<dd><input type="text" class="input-text" name="voteUser.vuusername"  /></dd>
					<dt>密　码：</dt>
					<dd><input type="password" class="input-text" name="voteUser.vupassword"  /></dd>
					<dt></dt>
					<dd><input type="submit" class="input-button" value="登录" /> <a href="register.jsp">新用户注册</a></dd>
				</dl>
			</form>
			<div class="error">${loginError}</div>
		</div>
	</div>
</div>
<div class="wrap">
</div>
<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
</body>
</html>