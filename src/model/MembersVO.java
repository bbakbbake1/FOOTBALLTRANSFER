package model;

public class MembersVO {
  private int mNo;
  private int tNo;
  private String mId;
  private String mPw;
  private String mBalance;
  private int mIsAdmin;

  public MembersVO() {
  }

  public MembersVO(int mNo, int tNo, String mId, String mPw, String mBalance, int mIsAdmin) {
    this.mNo = mNo;
    this.tNo = tNo;
    this.mId = mId;
    this.mPw = mPw;
    this.mBalance = mBalance;
    this.mIsAdmin = mIsAdmin;
  }

  public int getmNo() {
    return mNo;
  }

  public void setmNo(int mNo) {
    this.mNo = mNo;
  }

  public int gettNo() {
    return tNo;
  }

  public void settNo(int tNo) {
    this.tNo = tNo;
  }

  public String getmId() {
    return mId;
  }

  public void setmId(String mId) {
    this.mId = mId;
  }

  public String getmPw() {
    return mPw;
  }

  public void setmPw(String mPw) {
    this.mPw = mPw;
  }

  public String getmBalance() {
    return mBalance;
  }

  public void setmBalance(String mBalance) {
    this.mBalance = mBalance;
  }

  public int getmIsAdmin() {
    return mIsAdmin;
  }

  public void setmIsAdmin(int mIsAdmin) {
    this.mIsAdmin = mIsAdmin;
  }

  @Override
  public String toString() {
    return "mNo=" + mNo + ", tNo=" + tNo + ", mId=" + mId + ", mPw=" + mPw + ", mBalance=" + mBalance
        + ", mIsAdmin=" + mIsAdmin;
  }
}