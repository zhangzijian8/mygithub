package action;


import java.util.Map;

import org.hysc_common.vo.PageSupport;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;

import dao.VoteSubjectDao;
import dao.impl.VoteSubjectDaoImpl;
import entity.VoteSubject;

public class VoteSubjectAction extends BaseAction  {
	
	protected vo.PageSupport<VoteSubject>  pageSupport;
	private  int pageSize;//����
	private  int pageNumber;//ҳ��
	private  String searchText;

    
   public String load(){
	   pageSupport=this.voteSubjectService.findPage( pageNumber ,pageSize,"" );
	       return "json_success";
	   
   }


 //�첽��ӵķ���
   public String add() throws Exception {
  	 if(voteSubjectService.addSubject(voteSubject)){
  		  resposeInfo.setCode(200);
  		  resposeInfo.setMsg("��ӳɹ�");
  	 }else{
  		
  		  resposeInfo.setCode(500);
  		  resposeInfo.setMsg("���ʧ��");
  		
  	 }
  	 return "resposeInfo_success";
	}

   
   
   
 //���ͶƱѡ��
  public  String addOption(){
	  if(voteOptionService.addVoteOption(voteOption)){
		  
	  }else{
		  
		  
	  }
	  
	return "resposeInfo_success";
	  
  }
   
  
  
  
  //����ͶƱ
  public String detail(){
	  int id=voteSubject.getVsid();
	  VoteSubject voteSubject=this.voteSubjectService.findById(id); 
	
	  if(voteSubject!=null){
		  resposeInfo.setCode(200);
  		  resposeInfo.setMsg("�ɹ�");
	  }else{
		  resposeInfo.setCode(500);
  		  resposeInfo.setMsg("ʧ��");
	  }
	  return "json_success";
  }
  
  
  
  
public vo.PageSupport<VoteSubject> getPageSupport() {
	
	return pageSupport;
}




public void setPageSupport(vo.PageSupport<VoteSubject> pageSupport) {
	this.pageSupport = pageSupport;
}




public int getPageSize() {
	return pageSize;
}


public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}


public int getPageNumber() {
	return pageNumber;
}


public void setPageNumber(int pageNumber) {
	this.pageNumber = pageNumber;
}


public String getSearchText() {
	return searchText;
}


public void setSearchText(String searchText) {
	this.searchText = searchText;
}




    
}
