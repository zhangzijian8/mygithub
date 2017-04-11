package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.VoteSubjectDao;
import dao.VoteUserDao;
import dao.impl.VoteSubjectDaoImpl;
import dao.impl.VoteUserDaoImpl;
import entity.ResposeInfo;
import entity.VoteItem;
import entity.VoteOption;
import entity.VoteSubject;
import entity.VoteUser;
import service.VoteItemService;
import service.VoteOptionService;
import service.VoteSubjectService;
import service.VoteUserService;
import service.impl.VoteItemServiceImpl;
import service.impl.VoteOptionServiceImpl;
import service.impl.VoteSubjectServiceImpl;
import service.impl.VoteUserServiceImpl;

public class BaseAction extends ActionSupport  implements SessionAware{

	protected ResposeInfo resposeInfo=new ResposeInfo();
	protected VoteUserService voteUserService=new VoteUserServiceImpl(); 
	protected VoteUser voteUser;
	protected Map<String, Object> session;
	protected VoteSubjectService voteSubjectService =new VoteSubjectServiceImpl() ;	
	protected VoteSubject voteSubject;
	protected VoteOptionService voteOptionService =new VoteOptionServiceImpl() ;
	protected VoteOption  voteOption;
	protected VoteItemService voteItemService =new VoteItemServiceImpl() ;
	protected VoteItem  voteItem;
	
	public ResposeInfo getResposeInfo() {
		return resposeInfo;
	}

	public void setResposeInfo(ResposeInfo resposeInfo) {
		this.resposeInfo = resposeInfo;
	}

	public VoteSubjectService getVoteSubjectService() {
		return voteSubjectService;
	}

	public void setVoteSubjectService(VoteSubjectService voteSubjectService) {
		this.voteSubjectService = voteSubjectService;
	}

	public VoteUserService getVoteUserService() {
		return voteUserService;
	}

	public void setVoteUserService(VoteUserService voteUserService) {
		this.voteUserService = voteUserService;
	}

	public VoteUser getVoteUser() {
		return voteUser;
	}

	public void setVoteUser(VoteUser voteUser) {
		this.voteUser = voteUser;
	}
  
	
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public VoteSubject getVoteSubject() {
		return voteSubject;
	}

	public void setVoteSubject(VoteSubject voteSubject) {
		this.voteSubject = voteSubject;
	}

	public VoteOptionService getVoteOptionService() {
		return voteOptionService;
	}

	public void setVoteOptionService(VoteOptionService voteOptionService) {
		this.voteOptionService = voteOptionService;
	}

	public VoteOption getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(VoteOption voteOption) {
		this.voteOption = voteOption;
	}

	public VoteItemService getVoteItemService() {
		return voteItemService;
	}

	public void setVoteItemService(VoteItemService voteItemService) {
		this.voteItemService = voteItemService;
	}

	public VoteItem getVoteItem() {
		return voteItem;
	}

	public void setVoteItem(VoteItem voteItem) {
		this.voteItem = voteItem;
	}

	
	
}
