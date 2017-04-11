package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="voteItem",catalog="tpxt")
public class VoteItem {
   private int viid;
   private int voId;
   private  int vsid;
   private int vuuserid;
   
 @Id
 @GenericGenerator(name="generator", strategy = "native")
 @GeneratedValue(generator="generator")
 @Column(name="viid")
public int getViid() {
	return viid;
}
public void setViid(int viid) {
	this.viid = viid;
}
@Column(name="voId",nullable=false)
public int getVoId() {
	return voId;
}
public void setVoId(int voId) {
	this.voId = voId;
}
@Column(name="vsid",nullable=true)
public int getVsid() {
	return vsid;
}
public void setVsid(int vsid) {
	this.vsid = vsid;
}
@Column(name="vuuserid",nullable=true)
public int getVuuserid() {
	return vuuserid;
}
public void setVuuserid(int vuuserid) {
	this.vuuserid = vuuserid;
}
   
   
	 
}
