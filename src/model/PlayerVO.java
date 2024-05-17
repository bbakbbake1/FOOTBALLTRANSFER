package model;

public class PlayerVO {
  private int p_no;
  private String name;
  private int back_Num;
  private int shot;
  private int pass;
  private int defense;
  private String position;

  public PlayerVO() {
    super();
  }

  public PlayerVO(int p_no, String name, int back_Num, int shot, int pass, int defense, String position) {
    this.p_no = p_no;
    this.name = name;
    this.back_Num = back_Num;
    this.shot = shot;
    this.pass = pass;
    this.defense = defense;
    this.position = position;
  }

  public int getP_no() {
    return p_no;
  }

  public void setP_no(int p_no) {
    this.p_no = p_no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBack_Num() {
    return back_Num;
  }

  public void setBack_Num(int back_Num) {
    this.back_Num = back_Num;
  }

  public int getShot() {
    return shot;
  }

  public void setShot(int shot) {
    this.shot = shot;
  }

  public int getPass() {
    return pass;
  }

  public void setPass(int pass) {
    this.pass = pass;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "p_no=" + p_no + ", name=" + name + ", back_Num=" + back_Num + ", shot=" + shot + ", pass=" + pass
        + ", defense=" + defense + ", position=" + position + "\n";
  }

}
