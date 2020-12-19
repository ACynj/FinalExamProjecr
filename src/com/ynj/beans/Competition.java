package com.ynj.beans;

import java.util.ArrayList;
import java.util.List;

public class Competition {
	//赛事名称
private String name=null;
   //比赛人数
private Integer number=0;
   //比赛内容
private String content=null;
  //是否启动
private Boolean avalible=null;
public Competition() {
	
}
//参赛人员信息
private List<User> usersList=new ArrayList<User>();
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Boolean getAvalible() {
	return avalible;
}
public void setAvalible(Boolean avalible) {
	this.avalible = avalible;
}
public List<User> getUsersList() {
	return usersList;
}
public void setUsersList(List<User> usersList) {
	this.usersList = usersList;
}
@Override
public String toString() {
	return "Competition [name=" + name + ", content=" + content + ", avalible=" + avalible + "]";
}
public Competition(String name, String content) {
	super();
	this.name = name;
	this.content = content;
}



}
