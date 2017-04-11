<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注   册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@ include file="common/top.jsp" %>

 <!-- 自定义组件-->
<script type="text/javascript" >
   var isOk=true;

     $(function(){
    	//密码验证
    	$("#pwd").blur(function(){    		
    		checkPwd();
    		
    	});

    	//密码确认验证
    	$("#rpwd").blur(function(){    		
    		checkRpwd();	
    		
    	});
    	
    	//提交
    	if(isOk){
    		$("#submitB").click(function(){   	     	
        		checkPwd();
        		checkRpwd();
        		$.getJSON("registerUser.action",$("#reg").serialize(),function(data){
        			if(data.code==200){
    					longAlert("注册成功", data.msg , myClass[0], 3000);
    					setTimeout(function(){
    						window.location.href="vote_list.jsp";
    						
    					}, 3000);
    				}else{
    					longAlert("失败", data.msg , myClass[2], 3000);
    				}	
        			
        		});
        		
        	});
    	}
    	
    	
     });
     //密码验证
     function checkPwd(){
    	var pwd= $("#pwd").val();
    	var pwd2=/^\w{1,6}$/;//验证
    	if(!pwd2.test(pwd)){
    		$("")
    		$("div .div").html("输入的密码不符合规定,必须为1-6位的任意数字字母下划线组成！！！");
    		return;
    	}
    	$("div .div").html("");
     };
     
   //密码确认验证
     function checkRpwd(){
    	var rpwd= $("#rpwd").val();
    	var pwd=$("#pwd").val();
    	if(rpwd!=pwd){
    		$("div .div2").html("前后密码不匹配!!!");
    		isOk=false;
    		return;
    	}else{
    		 isOk=true;
    		$("div .div2").html("");	
    	}
    	
     }
     
   
   
</script>
<style type="text/css">
    div .div{
       display:inline-block;
    }
   div .div2{
       display:inline-block;
    }

</style>
</head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.png" />
</div>

<div id="register" class="box wrap">
	<h2>新用户注册</h2>
	<div class="content">
	   <form method="post" action="#" id="reg">
			
				<dl>
				  <dt>用户名：</dt>
				     <dd><input type="text" id="user" class="input-text" name="voteUser.vuusername" value=""/>				      
				     </dd>
				     
				</dl>
				<dl>
				<dt>密码：</dt>
				<dd><input type="password"  id="pwd" class="input-text" name="voteUser.vupassword" value=""/>
				     <div class="div" style="color:red;"></div>
				</dd>
				</dl>
				<dl>
					<dt>确认密码：</dt>
					<dd>
						<input type="password" id="rpwd" class="input-text" name="confirmPassword"
							value="" />
					     <div style="color:red;" class="div2"></div>
					</dd>
				</dl>
				<dl>
				<dt></dt>
				<dd><input type="button" class="input-button" name="submit" id="submitB" value="" /></dd>
			</dl>
		</form>
		<div class="error"></div>
	</div>
</div>
<div id="footer" class="wrap">
	合众艾特 &copy; 版权所有
</div>
</body>
</html>
