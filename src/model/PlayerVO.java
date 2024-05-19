package model;

public class PlayerVO {
  private int pNo;
  private int tNo;
  private String pName;
  private int pBackNum;
  private String pPosition;
  private int pShot;
  private int pPass;
  private int pDefense;
  private int pPrice;

  public PlayerVO(int pNo, String pName, int pBackNum, String pPosition, int pShot, int pPass, int pDefense,
      int pPrice) {
    this.pNo = pNo;
    this.pName = pName;
    this.pBackNum = pBackNum;
    this.pPosition = pPosition;
    this.pShot = pShot;
    this.pPass = pPass;
    this.pDefense = pDefense;
    this.pPrice = pPrice;
  }

  public int getpNo() {
    return pNo;
  }

  public void setpNo(int pNo) {
    this.pNo = pNo;
  }

  public int gettNo() {
    return tNo;
  }

  public void settNo(int tNo) {
    this.tNo = tNo;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public int getpBackNum() {
    return pBackNum;
  }

  public void setpBackNum(int pBackNum) {
    this.pBackNum = pBackNum;
  }

  public int getpShot() {
    return pShot;
  }

  public void setpShot(int pShot) {
    this.pShot = pShot;
  }

  public int getpPass() {
    return pPass;
  }

  public void setpPass(int pPass) {
    this.pPass = pPass;
  }

  public int getpDefense() {
    return pDefense;
  }

  public void setpDefense(int pDefense) {
    this.pDefense = pDefense;
  }

  public String getpPosition() {
    return pPosition;
  }

  public void setpPosition(String pPosition) {
    this.pPosition = pPosition;
  }

  public int getpPrice() {
    return pPrice;
  }

  public void setpPrice(int pPrice) {
    this.pPrice = pPrice;
  }

  @Override
  public String toString() {
    return "pNo=" + pNo + ", pName=" + pName + ", pBackNum=" + pBackNum + ", pShot=" + pShot + ", pPass="
        + pPass + ", pDefense=" + pDefense + ", pPosition=" + pPosition + ", pPrice=" + pPrice + "\n";
  }

}
