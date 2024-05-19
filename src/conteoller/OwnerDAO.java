package conteoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OwnerDAO {

  public static int initPlayer(int mNo, int tNo) {
    int result = 0;
    String sql = "INSERT INTO OWNER SELECT ?, P_NO FROM PLAYER WHERE T_NO = ?";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, mNo);
      pstmt.setInt(2, tNo);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 선수 영입하면 유저가 보유중인 선수에 추가됌
  public int buyPlayer(int mNo, int pNo) {
    int result = 0;
    String sql = "INSERT INTO OWNER VALUES (?, ?)";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, mNo);
      pstmt.setInt(2, pNo);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 선수를 판매하면 유저가 보유중인 선수에서 삭제됌
  public int sellPlayer(int mNo, int pNo) {
    int result = 0;
    String sql = "DELETE FROM OWNER WHERE M_NO = ? AND P_NO = ?";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, mNo);
      pstmt.setInt(2, pNo);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}