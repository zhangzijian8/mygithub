package dao;

import java.util.List;



import entity.VoteUser;



public interface VoteUserDao {
	/**
	 * ���ݵ�¼���������ѯ�û���Ϣ
	 * @param loginCode ��¼��
	 * @param password ����
	 * @return
	 */
	public boolean findByLoginCodeAndPassword(String vuusername, String vupassword);
	public int addVoteUser(VoteUser voteUser); 
	public boolean findByLoginCode(String vuusername);
	
}
