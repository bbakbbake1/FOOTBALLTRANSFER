package conteoller.member;

import java.util.ArrayList;
import java.util.Scanner;

import conteoller.player.PlayerDAO;
import conteoller.team.TeamManager;
import model.PlayerVO;
import model.TeamVO;

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
    boolean idOverlap = false;
    String mId = null;
    do {
      System.out.println("사용하실 아이디를 입력하세요.");
      mId = sc.nextLine();
      idOverlap = mdao.mIdCheck(mId);// 아이디 중복을 처리하는 함수
      if (idOverlap) {
        System.out.println("아이디가 중복되었습니다.");
        System.out.println("재입력 바람.");
      }
    } while (idOverlap);
    System.out.println("사용하실 비밀번호를 입력하세요.");
    String mPw = sc.nextLine();
    tmm.getteamList();
    System.out.println("사용하실 팀번호를 입력해주세요.");
    int tNo = sc.nextInt();
    sc.nextLine();
    mdao.joinAdd(tNo, mId, mPw);// 회원가입 하면서 입력받은 유저의 정보를 DB에 MEMBERS테이블에 저장.
  }

  // 멤버 로그인
  public int login() {
    MembersDAO mdao = new MembersDAO();
    int mNo = 0;
    do {
      System.out.println("아이디를 입력해주세요.");
      String mId = sc.nextLine();
      System.out.println("비밀번호를 입력해주세요.");
      String mPw = sc.nextLine();
      mNo = mdao.login(mId, mPw);
    } while (mNo == 0);
    return mNo;
  }

  // 사용자 팀 정보 보기
  public void myTeamInfo(int mNo) {
    MembersDAO mdao = new MembersDAO();
    System.out.println("내 팀 정보");
    TeamVO tvo = mdao.memberTeamInfo(mNo);
    System.out.println(tvo.myTeamInfo());
  }

  // 유저 선수 영입
  public void buyPlayer(int mNo) {
    PlayerDAO pdao = new PlayerDAO();
    MembersDAO mdao = new MembersDAO();
    ArrayList<PlayerVO> playerList = pdao.getPlayerList();
    System.out.println(playerList);
    System.out.println("영입할 선수를 선택하세요.");
    int pNo = sc.nextInt();
    sc.nextLine();
    int result = mdao.buyPlayer(pNo, mNo);
    if (result == 1) {
      System.out.println("영입 성공");
    } else {
      System.out.println("영입 실패");
    }
  }

  // 유저 선수 판매
  public void sellPlayer(int mNo) {
    MembersDAO mdao = new MembersDAO();
    MemberManager mm = new MemberManager();
    mm.myTeamInfo(mNo);
    System.out.println("판매할 선수를 선택하세요.");
    int pNo = sc.nextInt();
    sc.nextLine();
    int result = mdao.sellPlayer(pNo, mNo);
    if (result == 1) {
      System.out.println("판매 성공");
    } else {
      System.out.println("판매 실패");
    }
  }

}
