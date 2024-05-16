package conteoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembersDAO {
  //관리자 검증
  public boolean adminCheck(String adminId, String adminPw) {
    boolean loginSuccess = false;
    int check;
    String sql = "select IS_ADMIN from members WHERE EMAIL_ID = ? and PW = ?";
    try (Connection con = DBUtill.makeConnection()){
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, adminId);
      pstmt.setString(2, adminPw);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
        check = rs.getInt("IS_ADMIN");
        if(check == 1){
          System.out.println("관리자 로그인 성공");
          loginSuccess = true;
        }else{
          System.out.println("관리자 로그인 실패");
        }
      }else{
        System.out.println("관리자 계정이 존재하지 않습니다.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return loginSuccess;
  }
  //아이디 중복 체크
  public boolean memberIdCheck(String memberId) {
    boolean idCheck = false;
    String sql = "SELECT EMAIL_ID FROM MEMBERS WHERE EMAIL_ID = ?";
    try (Connection con = DBUtill.makeConnection()){
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, memberId);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
        idCheck = true; //DB상에 이미 객체가 존재함으로 중복이 된다. 
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return idCheck;
  }
  //회원가입하면서 받은 유저의 정보들을 DB에 MEMBERS 테이블에 저장
  public void joinAdd(String memberId, String memberPw, String memberTeamName) {
    String sql = "INSERT INTO MEMBERS(M_NO,EMAIL_ID,PW,TEAMNAME) VALUES(MEMBERS_seq.nextval,?,?,?)";
    try (Connection con = DBUtill.makeConnection()){
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, memberId);
      pstmt.setString(2, memberPw);
      pstmt.setString(3, memberTeamName);
      int i = pstmt.executeUpdate();
      if(i == 1){
        System.out.println(memberId + " 회원가입 성공");
      }else{
        System.out.println(memberId + " 회원가입 실패");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
}
