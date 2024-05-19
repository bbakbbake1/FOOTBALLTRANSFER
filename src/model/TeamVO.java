package model;

import java.util.ArrayList;

public class TeamVO {
  private int tNo;
  private String tName;
  private ArrayList<PlayerVO> playerList;
  private int balance;

  public TeamVO() {
  }

  public TeamVO(String tName, int balance) {
    this.tName = tName;
    this.balance = balance;
    this.playerList = new ArrayList<>();
  }

  public TeamVO(int tNo, String tName) {
    this.tNo = tNo;
    this.tName = tName;
  }

  public int gettNo() {
    return tNo;
  }

  public void settNo(int tNo) {
    this.tNo = tNo;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public ArrayList<PlayerVO> getPlayerList() {
    return playerList;
  }

  public void setPlayerList(ArrayList<PlayerVO> playerList) {
    this.playerList = playerList;
  }

  public void addPlayer(PlayerVO pvo) {
    this.playerList.add(pvo);
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
  
  public String myTeamInfo() {
    return "팀 번호 : " + tNo + " 팀 이름 : " + tName + " 자산 : " + balance + "\n" + playerList;
  }

  @Override
  public String toString() {
    return "팀 번호 : " + tNo + " 팀 이름 : " + tName + "\n";
  }
}
