package conteoller.player;

import java.util.Scanner;

import conteoller.team.TeamManager;

public class PlayerManager {
  public static Scanner sc = new Scanner(System.in);

  public void adminCreatePlayer() {
    PlayerDAO pdao = new PlayerDAO();
    TeamManager tm = new TeamManager();
    tm.getteamList();
    System.out.println("생성할 선수의 팀번호를 입력하세요.");
    int tNo = sc.nextInt();
    sc.nextLine();
    System.out.println("생성할 선수의 이름을 입력하세요.");
    String pName = sc.nextLine();
    System.out.println("생성할 선수의  등번호를 입력하세요.");
    int pBacknum = sc.nextInt();
    sc.nextLine();
    System.out.println("생성할 선수의 포지션을 입력하세요.");
    String pPosition = sc.nextLine();
    System.out.println("생성할 선수의 슛 능력치를 입력하세요.");
    int pShot = sc.nextInt();
    sc.nextLine();
    System.out.println("생성할 선수의 패스 능력치를 입력하세요.");
    int pPass = sc.nextInt();
    sc.nextLine();
    System.out.println("생성할 선수의 수비 능력치를 입력하세요.");
    int pDefense = sc.nextInt();
    sc.nextLine();
    System.out.println("생성할 선수의 가격을 입력하세요.");
    int pPrice = sc.nextInt();
    sc.nextLine();
    int result = pdao.adminPlayerCreate(tNo, pName, pBacknum, pPosition, pShot, pPass, pDefense, pPrice);
    if (result == 1) {
      System.out.println("선수 생성 성공");
    } else {
      System.out.println("선수 생성 실패");
    }
  }

  // 관리자 선수 삭제
  public void adminDeletePlayer() {
    PlayerDAO pdao = new PlayerDAO();
    System.out.println(pdao.getPlayerList());
    System.out.println("삭제할 선수의 일련 번호를 입력하세요.");
    int pNo = sc.nextInt();
    sc.nextLine();
    int result = pdao.adminDeletePlayer(pNo);
    if (result == 1) {
      System.out.println("선수 삭제 성공");
    } else {
      System.out.println("선수 삭제 실패");
    }
  }

  // 관리자 선수 리스트
  public void getPlayerList() {
    PlayerDAO pdao = new PlayerDAO();
    System.out.println("선수 목록");
    System.out.println(pdao.getPlayerList());
  }

}
