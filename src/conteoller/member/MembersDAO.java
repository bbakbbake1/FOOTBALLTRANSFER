package conteoller.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conteoller.DBUtill;
import conteoller.OwnerDAO;
import model.PlayerVO;
import model.TeamVO;

public class MembersDAO {
  // 관리자 검증
  public boolean adminCheck(String adminId, String adminPw) {
    boolean loginSuccess = false;
    int check;
    String sql = "select M_ISADMIN from members WHERE M_ID = ? and M_PW = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, adminId);
      pstmt.setString(2, adminPw);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        check = rs.getInt("M_ISADMIN");
        if (check == 1) {
          System.out.println("관리자 로그인 성공");
          loginSuccess = true;
        } else {
          System.out.println("관리자 로그인 실패");
        }
      } else {
        System.out.println("관리자 계정이 존재하지 않습니다.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return loginSuccess;
  }

  // 아이디 중복 체크
  public boolean mIdCheck(String mId) {
    boolean mNo = false;
    String sql = "SELECT M_ID FROM MEMBERS WHERE M_ID = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mId);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        mNo = true; // DB상에 이미 객체가 존재함으로 중복이 된다.
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mNo;
  }

  // 회원가입하면서 받은 유저의 정보들을 DB에 MEMBERS 테이블에 저장
  public void joinAdd(int memberTno, String memberId, String memberPw) {
    int result = 0;
    int mNo = 0;
    String sql = "INSERT INTO MEMBERS(M_NO, T_NO, M_ID, M_PW) VALUES(MEMBERS_seq.nextval, ?, ?, ?)";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql, new String[] { "M_NO" });
      pstmt.setInt(1, memberTno);
      pstmt.setString(2, memberId);
      pstmt.setString(3, memberPw);
      int i = pstmt.executeUpdate();
      if (i == 1) {
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
          mNo = rs.getInt(1);
        }
        result = OwnerDAO.initPlayer(mNo, memberTno); // 멤버가 선택한 팀 선수를 오너테이블에 추가
        if (result > 0) {
          System.out.println(memberId + " 회원가입 성공");
        } else {
          System.out.println(memberId + " 회원가입 실패");
        }
      } else {
        System.out.println(memberId + " 회원가입 실패");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 멤버로그인 확인
  public int login(String mId, String mPw) {
    int mNo = 0;
    String sql = "SELECT M_NO, M_ID, M_PW FROM MEMBERS WHERE M_ID = ? AND M_PW = ?";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      pstmt.setString(1, mId);
      pstmt.setString(2, mPw);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        mNo = rs.getInt("M_NO");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mNo;
  }

  // 사용자 팀 정보 불러오기
  public TeamVO memberTeamInfo(int mNo) {
    TeamVO tvo = null;
    String sql = "SELECT T.T_NAME, P.P_NO, P.P_NAME, P.P_BACKNUM, P.P_POSITION, P.P_SHOT, P.P_PASS, P.P_DAFENSE, P.P_PRICE, M.M_BALANCE "
        + "FROM OWNER O INNER JOIN PLAYER P ON O.P_NO = P.P_NO INNER JOIN MEMBERS M ON O.M_NO = M.M_NO INNER JOIN TEAM T ON M.T_NO = T.T_NO WHERE M.M_NO = ?";
    try (Connection con = DBUtill.makeConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, mNo);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        if (tvo == null) {
          tvo = new TeamVO(rs.getString("T_NAME"), rs.getInt("M_BALANCE"));
        }
        int pNo = rs.getInt("P_NO");
        String pName = rs.getString("P_NAME");
        int pBackNum = rs.getInt("P_BACKNUM");
        String pPosition = rs.getString("P_POSITION");
        int pShot = rs.getInt("P_SHOT");
        int pPass = rs.getInt("P_PASS");
        int pDefense = rs.getInt("P_DAFENSE");
        int pPrice = rs.getInt("P_PRICE");
        PlayerVO pvo = new PlayerVO(pNo, pName, pBackNum, pPosition, pShot, pPass, pDefense, pPrice);
        tvo.addPlayer(pvo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tvo;
  }

  // 선수 영입
  public int buyPlayer(int pNo, int mNo) {
    int result = 0;
    String sql = "UPDATE MEMBERS SET M_BALANCE = M_BALANCE - NVL((SELECT P_PRICE FROM PLAYER WHERE P_NO = ?), 99999999) WHERE M_NO = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pNo);
      pstmt.setInt(2, mNo);
      result = pstmt.executeUpdate();
      if (result == 1) {
        OwnerDAO odao = new OwnerDAO();
        result = odao.buyPlayer(mNo, pNo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 선수 판매
  public int sellPlayer(int pNo, int mNo) {
    int result = 0;
    String sql = "UPDATE MEMBERS SET M_BALANCE = M_BALANCE + NVL((SELECT P_PRICE FROM PLAYER WHERE P_NO = ?), 99999999) WHERE M_NO = ?";
    try (Connection con = DBUtill.makeConnection()) {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pNo);
      pstmt.setInt(2, mNo);
      result = pstmt.executeUpdate();
      if (result == 1) {
        OwnerDAO odao = new OwnerDAO();
        result = odao.sellPlayer(mNo, pNo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // 관리자 선수생성
  public void createPlayer() {

    

  }
}
