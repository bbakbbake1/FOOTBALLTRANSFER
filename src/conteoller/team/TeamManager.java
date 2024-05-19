package conteoller.team;

import java.util.Scanner;

public class TeamManager {
  public static Scanner sc = new Scanner(System.in);

  // 멤버가 사용할 팀 리스트 불러오기
  public void getteamList() {
    TeamDAO tdao = new TeamDAO();
    System.out.println("팀 리스트 목록");
    System.out.println(tdao.teamList());// 팀 리스트 출력
  }

  // 관리자 팀 생성
  public void adminCreateTeam() {
    TeamDAO tdao = new TeamDAO();
    System.out.println("생성할 팀이름을 입력해주세요.");
    String tName = sc.nextLine();
    int result = tdao.createTeam(tName);
    if (result == 1) {
      System.out.println("팀 생성 성공");
    } else {
      System.out.println("팀 생성 실패");
    }
  }

  // 관리자 팀 삭제
  public void adminDeleteTeam() {
    TeamDAO tdao = new TeamDAO();
    getteamList();
    System.out.println("삭제하실 팀 번호를 입력해주세요.");
    int tNo = sc.nextInt();
    sc.nextLine();
    int result = tdao.deleteTeam(tNo);
    if (result == 1) {
      System.out.println("팀 삭제 성공");
    } else {
      System.out.println("팀 삭제 실패");
    }
  }

}
