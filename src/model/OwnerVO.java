package model;

public class OwnerVO {
  private int player_no;
  private int members_no;

  public OwnerVO() {
    super();
  }

  public OwnerVO(int player_no, int members_no) {
    this.player_no = player_no;
    this.members_no = members_no;
  }

  public int getPlayer_no() {
    return player_no;
  }

  public void setPlayer_no(int player_no) {
    this.player_no = player_no;
  }

  public int getMembers_no() {
    return members_no;
  }

  public void setMembers_no(int members_no) {
    this.members_no = members_no;
  }

  @Override
  public String toString() {
    return "OwnerVO [player_no=" + player_no + ", members_no=" + members_no + "]";
  }

}
