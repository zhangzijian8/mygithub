package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="voteSubject",catalog="tpxt")
public class VoteSubject {
   private int vsid;//票号从一开始
   private String vstitle;//投票内容
   private String vstype;//按票类型 1单选 2多选
   //临时属性
   private int optionNum;//选项数
   private int itemNum;//投票数
   private List <VoteOption>options; 
   
   
   
@Transient
public int getOptionNum() {
	return optionNum;
}

@Transient
public List<VoteOption> getOptions() {
	return options;
}
public void setOptions(List<VoteOption> options) {
	this.options = options;
}
public void setOptionNum(int optionNum) {
	this.optionNum = optionNum;
}

@Transient
public int getItemNum() {
	return itemNum;
}
public void setItemNum(int itemNum) {
	this.itemNum = itemNum;
}
@Id
@GenericGenerator(name="generator", strategy = "native")
@GeneratedValue(generator="generator")
@Column(name="vsid")
public int getVsid() {
	return vsid;
}
public void setVsid(int vsid) {
	this.vsid = vsid;
}
@Column(name="vstitle",length=100,nullable=false)
public String getVstitle() {
	return vstitle;
}
public void setVstitle(String vstitle) {
	this.vstitle = vstitle;
}

@Column(name="vstype",length=100,nullable=false)
public String getVstype() {
	return vstype;
}
public void setVstype(String vstype) {
	this.vstype = vstype;
}
	 
}
