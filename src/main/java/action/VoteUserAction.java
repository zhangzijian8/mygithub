package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.ResposeInfo;
import entity.VoteUser;
import service.VoteUserService;
import service.impl.VoteUserServiceImpl;

public class VoteUserAction extends BaseAction{
	
	//登录的方法
	public String login() throws Exception {
		if(voteUserService.login(voteUser.getVuusername(), voteUser.getVupassword())){
			 return "login_success";	
		}else{
			this.session.put("loginError", "用户名或密码错误！登录失败!");
			return "login_error";
			
		}
				
	}

	
	//异步注册的方法
     public String register() throws Exception {
    	 if(voteUserService.register(voteUser)){
    		  resposeInfo.setCode(200);
    		  resposeInfo.setMsg("注册成功");
    	 }else{
    		
    		  resposeInfo.setCode(500);
    		  resposeInfo.setMsg("注册失败");
    		
    	 }
    	 return "json_success";
	}

	
     
     
}
