package conteoller;

import java.util.Scanner;

import model.MembersVO;

public class MemberManager {
  public static Scanner sc = new Scanner(System.in);

  // 관리자 로그인
  public void verifyAdmin() {
    MembersDAO mdao = new MembersDAO();
    boolean isAdmin = false;
    do {
      System.out.println("관리자 아이디 입력 : ");
      String adminId = sc.nextLine();
      System.out.println("비밀번호 입력 : ");
      String adminPw = sc.nextLine();
      isAdmin = mdao.adminCheck(adminId, adminPw); // 검증하는 메소드 호출
      if (!isAdmin) {
        System.out.println("올바른 정보를 입력해주세요.");
      }
    } while (!isAdmin);
  }

  // 회원가입
  public void joinMember() {
    MembersDAO mdao = new MembersDAO();
    TeamManager tmm = new TeamManager();
    MembersVO mvo = new MembersVO();
    boolean idOverlap = false;
    String memberId;
    do {
      System.out.println("사용하실 아이디를 입력하세요.");
      memberId = sc.nextLine();
      idOverlap = mdao.memberIdCheck(memberId);// 아이디 중복을 처리하는 함수
      if (idOverlap) {
        System.out.println("아이디가 중복되었습니다.");
        System.out.println("재입력 바람.");
      }
    } while (idOverlap);
    System.out.println("사용하실 비밀번호를 입력하세요.");
    String memberPw = sc.nextLine();
    tmm.getteamList();
    System.out.println("사용하실 팀이름을 입력해주세요.");
    String memberTeamName = sc.nextLine();
    mvo.setEmailId(memberId);
    mvo.setPw(memberPw);
    mvo.setTeamname(memberTeamName);
    mdao.joinAdd(mvo.getEmailId(), mvo.getPw(), mvo.getTeamname());// 회원가입 하면서 입력받은 유저의 정보를 DB에 MEMBERS테이블에 저장.
  }

  // 관리자 선수 생성
  public void createPlayer() {
    do{
      PlayerDAO.adminPlayerCreate();

    }while()

  }

}
