package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.ResposeInfo;
import entity.VoteUser;
import service.VoteUserService;
import service.impl.VoteUserServiceImpl;

public class VoteUserAction extends BaseAction{
	
	//��¼�ķ���
	public String login() throws Exception {
		if(voteUserService.login(voteUser.getVuusername(), voteUser.getVupassword())){
			 return "login_success";	
		}else{
			this.session.put("loginError", "�û�����������󣡵�¼ʧ��!");
			return "login_error";
			
		}
				
	}

	
	//�첽ע��ķ���
     public String register() throws Exception {
    	 if(voteUserService.register(voteUser)){
    		  resposeInfo.setCode(200);
    		  resposeInfo.setMsg("ע��ɹ�");
    	 }else{
    		
    		  resposeInfo.setCode(500);
    		  resposeInfo.setMsg("ע��ʧ��");
    		
    	 }
    	 return "json_success";
	}

	
     
     
}
