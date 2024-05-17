package conteoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerDAO {
  // 관리자 선수생성
  public static void adminPlayerCreate() {
    String sql = "";

    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
