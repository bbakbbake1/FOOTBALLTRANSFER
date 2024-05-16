package model;

public class TeamVO {
  private int t_no;
  private String c_teamName;

  
  public TeamVO() {
    super();
  }
  public TeamVO(int t_no, String c_teamName) {
    this.t_no = t_no;
    this.c_teamName = c_teamName;
  }
  public int getT_no() {
    return t_no;
  }
  public void setT_no(int t_no) {
    this.t_no = t_no;
  }
  public String getC_teamName() {
    return c_teamName;
  }
  public void setC_teamName(String c_teamName) {
    this.c_teamName = c_teamName;
  }
  @Override
  public String toString() {
    return "t_no=" + t_no + ", c_teamName=" + c_teamName + "\n";
  }

  
}
