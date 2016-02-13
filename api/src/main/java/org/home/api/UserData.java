package org.home.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "User")
public class UserData {
static List<UserData> u = new ArrayList<UserData>();

private String name;
private int balance;


public UserData(){
	
}

public UserData(String name, int balance){
	this.balance = balance;
	this.name = name;
	
}

@XmlElement(name = "Name")
public String getName() {
	return name;
}
public void setName(String name){
	this.name = name;	
}
@XmlElement(name = "Deposit")
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance += balance;
}	
	
	
}
