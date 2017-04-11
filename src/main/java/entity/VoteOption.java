package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="voteoption",catalog="tpxt")
public class VoteOption {
   private int voId;
   private String vooption;
   private String vsid;
   private String voorder;
   
   
   @Id
   @GenericGenerator(name="generator", strategy = "native")
   @GeneratedValue(generator="generator")
   @Column(name="voId")   
public int getVoId() {
	return voId;
}
public void setVoId(int voId) {
	this.voId = voId;
}
@Column(name="vooption",length=100,nullable=false)
public String getVooption() {
	return vooption;
}
public void setVooption(String vooption) {
	this.vooption = vooption;
}
@Column(name="vsid",length=100,nullable=true)
public String getVsid() {
	return vsid;
}
public void setVsid(String vsid) {
	this.vsid = vsid;
}
@Column(name="voorder",length=100,nullable=false)
public String getVoorder() {
	return voorder;
}
public void setVoorder(String voorder) {
	this.voorder = voorder;
}
   
	
	
}
