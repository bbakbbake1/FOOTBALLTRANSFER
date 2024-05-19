import java.util.Scanner;

import conteoller.member.MemberManager;
import conteoller.player.PlayerManager;
import conteoller.team.TeamManager;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.admin.ADMINMENU_CHOICE;
import view.admin.AdminMenuViewer;
import view.login.LOGIN_CHOICE;
import view.login.LoginMenuViewer;

public class FootBallTransferMain {
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    mainMenu();
  }

  private static void mainMenu() {
    MemberManager mm = new MemberManager();
    int choiceNum;
    while (true) {
      MenuViewer.mainMenuViewer();
      choiceNum = MenuViewer.choice.nextInt();
      MenuViewer.choice.nextLine();

      switch (choiceNum) {
        case MENU_CHOICE.JOIN:
          mm.joinMember();
          break;
        case MENU_CHOICE.LOGIN:
          loginMenu();
          break;
        case MENU_CHOICE.ADMINLOGIN:
          adminLoginMenu();
          break;
        case MENU_CHOICE.EXIT:
          System.out.println("프로그램 종료.");
          return;
        default:
          System.out.println("올바른 값을 입력해주세요.");
          break;
      }
    }
  }

  public static void loginMenu() {
    int mNo = 0;
    int choiceNum = 0;
    MemberManager mm = new MemberManager();
    mNo = mm.login();

    while (true) {
      LoginMenuViewer.loginMenu();
      choiceNum = LoginMenuViewer.sc.nextInt();
      LoginMenuViewer.sc.nextLine();

      switch (choiceNum) {
        case LOGIN_CHOICE.MY_TEAM_INFO:
          mm.myTeamInfo(mNo);
          break;
        case LOGIN_CHOICE.BUY_PLAYER:
          mm.buyPlayer(mNo);
          break;
        case LOGIN_CHOICE.SELL_PLAYER:
          mm.sellPlayer(mNo);
          break;
        case LOGIN_CHOICE.EXIT:
          System.out.println("로그인 메뉴 종료");
          return;
        default:
          System.out.println("올바른 값을 입력해주세요.");
          break;
      }
    }

  }

  // 관리자 로그인 메뉴
  public static void adminLoginMenu() {
    // 관리자 검증
    MemberManager mm = new MemberManager();
    mm.verifyAdmin();
    TeamManager tm = new TeamManager();
    PlayerManager pm = new PlayerManager();
    int choiceNum;
    while (true) {
      AdminMenuViewer.adminMenu();
      choiceNum = AdminMenuViewer.sc.nextInt();
      AdminMenuViewer.sc.nextLine();

      switch (choiceNum) {
        case ADMINMENU_CHOICE.TEAMCREATE:
          tm.adminCreateTeam();
          break;
        case ADMINMENU_CHOICE.PLAYERCREATE:
          pm.adminCreatePlayer();
          break;
        case ADMINMENU_CHOICE.TEAMDELETE:
          tm.adminDeleteTeam();
          break;
        case ADMINMENU_CHOICE.PLAYERDELETE:
          pm.adminDeletePlayer();
          break;
        case ADMINMENU_CHOICE.PLAYERLIST:
          pm.getPlayerList();
          break;
        case ADMINMENU_CHOICE.TEAMLIST:
          tm.getteamList();
          break;
        case ADMINMENU_CHOICE.EXIT:
          System.out.println("관리자 메뉴 종료");
          return;
        default:
          System.out.println("올바른 값을 입력해주세요.");
          break;
      }
    }
  }
}
