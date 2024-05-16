package model;

public class MembersVO {
private int no;
private String emailId;
private String pw;
private String teamname;
private String balance;
private int isAdmin;


public MembersVO(int no, String emailId, String pw, String teamname, String balance, int isAdmin) {
  this.no = no;
  this.emailId = emailId;
  this.pw = pw;
  this.teamname = teamname;
  this.balance = balance;
  this.isAdmin = isAdmin;
}
public MembersVO() {
super();
}
public int getNo() {
  return no;
}
public void setNo(int no) {
  this.no = no;
}
public String getEmailId() {
  return emailId;
}
public void setEmailId(String emailId) {
  this.emailId = emailId;
}
public String getPw() {
  return pw;
}
public void setPw(String pw) {
  this.pw = pw;
}
public String getTeamname() {
  return teamname;
}
public void setTeamname(String teamname) {
  this.teamname = teamname;
}
public String getBalance() {
  return balance;
}
public void setBalance(String balance) {
  this.balance = balance;
}
public int getIsAdmin() {
  return isAdmin;
}
public void setIsAdmin(int isAdmin) {
  this.isAdmin = isAdmin;
}
@Override
public String toString() {
  return "no=" + no + ", emailId=" + emailId + ", pw=" + pw + ", teamname=" + teamname + ", balance="
      + balance + ", isAdmin=" + isAdmin + "\n";
}



}
