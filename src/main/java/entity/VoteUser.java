package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="voteuser",catalog="tpxt")
public class VoteUser {
   private int vuuserid;
   private String vuusername;//ÓÃ»§Ãû
   private  String vupassword;//ÃÜÂë
   
   
   
 @Id
 @GenericGenerator(name="generator", strategy = "native")
 @GeneratedValue(generator="generator")
 @Column(name="vuuserid")
public int getVuuserid() {
	return vuuserid;
}
 
public void setVuuserid(int vuuserid) {
	this.vuuserid = vuuserid;
}

 @Column(name="vuusername",length=100,nullable=false)
public String getVuusername() {
	return vuusername;
}
public void setVuusername(String vuusername) {
	this.vuusername = vuusername;
}

@Column(name="vupassword",length=100,nullable=false)
public String getVupassword() {
	return vupassword;
}
public void setVupassword(String vupassword) {
	this.vupassword = vupassword;
}
 
   
}
