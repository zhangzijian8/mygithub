package service;

import entity.VoteSubject;
import vo.PageSupport;

public interface VoteSubjectService {

	 public PageSupport<VoteSubject> findPage(int pageNo,int pageSize,String searchText);
     
     public boolean addSubject(VoteSubject voteSubject);
     
     public boolean UpdateSubject(VoteSubject voteSubject);
     
     public VoteSubject findById(int id);
     public int delete(int id);
     public int findId();
}
