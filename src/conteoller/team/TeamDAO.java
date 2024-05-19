package conteoller.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conteoller.DBUtill;
import model.TeamVO;

public class TeamDAO {

  public ArrayList<TeamVO> teamList() {
    ArrayList<TeamVO> teamList = new ArrayList<>();
    String sql = "SELECT * FROM TEAM";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        int tNo = rs.getInt("T_NO");
        String tName = rs.getString("T_NAME");
        TeamVO tvo = new TeamVO(tNo, tName);
        teamList.add(tvo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return teamList;
  }

  // 관리자 팀 생성
  public int createTeam(String tName) {
    int result = 0;
    String sql = "INSERT INTO TEAM VALUES(TEAM_SEQ.NEXTVAL, ?)";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, tName);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 관리자 팀 삭제
  public int deleteTeam(int tNo) {
    int result = 0;
    String sql = "DELETE FROM TEAM WHERE T_NO = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, tNo);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}