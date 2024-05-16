package conteoller;

public class TeamManager {
  //멤버가 사용할 팀 리스트 불러오기
  public void getteamList() {
    TeamDAO tdao = new TeamDAO();
    System.out.println("팀 리스트 목록");
    tdao.teamList();//팀 리스트 출력
  }

}
