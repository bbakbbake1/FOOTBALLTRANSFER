package conteoller.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conteoller.DBUtill;
import model.PlayerVO;

public class PlayerDAO {

  // 모든 선수 정보 전달
  public ArrayList<PlayerVO> getPlayerList() {
    ArrayList<PlayerVO> playerList = new ArrayList<>();
    String sql = "SELECT * FROM PLAYER";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        int pNo = rs.getInt("P_NO");
        String pName = rs.getString("P_NAME");
        int pBackNum = rs.getInt("P_BACKNUM");
        String pPosition = rs.getString("P_POSITION");
        int pShot = rs.getInt("P_SHOT");
        int pPass = rs.getInt("P_PASS");
        int pDefense = rs.getInt("P_DAFENSE");
        int pPrice = rs.getInt("P_PRICE");
        PlayerVO pvo = new PlayerVO(pNo, pName, pBackNum, pPosition, pShot, pPass, pDefense, pPrice);
        playerList.add(pvo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return playerList;
  }

  // 관리자 선수생성
  public int adminPlayerCreate(int tNo, String pName, int pBacknum, String pPosition, int pShot, int pPass,
      int pDefense,
      int pPrice) {
    int result = 0;
    String sql = "INSERT INTO PLAYER VALUES(PLAYER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, tNo);
      pstmt.setString(2, pName);
      pstmt.setInt(3, pBacknum);
      pstmt.setString(4, pPosition);
      pstmt.setInt(5, pShot);
      pstmt.setInt(6, pPass);
      pstmt.setInt(7, pDefense);
      pstmt.setInt(8, pPrice);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 관리자 선수 삭제
  public int adminDeletePlayer(int pNo) {
    int result = 0;
    String sql = "DELETE FROM PLAYER WHERE P_NO = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pNo);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

}
