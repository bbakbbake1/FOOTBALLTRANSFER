package conteoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TeamVO;

public class TeamDAO {

  public void teamList() {
    TeamVO tvo = new TeamVO();
    String sql = "SELECT C_TEAMNAME FROM TEAM";
    
    try (Connection con = DBUtill.makeConnection()){
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()){
        tvo.setC_teamName(rs.getString("C_TEAMNAME"));
        System.out.println(tvo.getC_teamName());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
}
