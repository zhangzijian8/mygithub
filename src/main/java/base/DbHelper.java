package base;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;


/**
 * ���ݲ���������
 * @author tanglc
 *
 */
public class DbHelper {
	protected Connection conn;
	protected QueryRunner queryRunner = new QueryRunner();
	//��
	public Connection openCon(){
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			//�������Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpxt?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "HZIT123456");
		   //System.out.println("kdkdkdk");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*public Connection openCon2(){
		InputStream io = DbHelper.class.getClassLoader().getResourceAsStream("jdbc.properties");
		return conn;
		
	}*/
	
	public void closeAll(){
		if(conn!=null){
			DbUtils.closeQuietly(conn);			
		}
	}

}
