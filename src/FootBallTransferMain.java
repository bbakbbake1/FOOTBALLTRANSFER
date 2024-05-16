import java.util.Scanner;

import conteoller.MemberManager;
import view.MENU_CHOICE;
import view.MenuViewer;

public class FootBallTransferMain {
    public static Scanner input = new Scanner(System.in);
  public static void main(String[] args){
    mainMenu();
  }

  private static void mainMenu() {
  int choiceNum;

    while(true){
      MenuViewer.mainMenuViewer();
      choiceNum = MenuViewer.choice.nextInt();
      MenuViewer.choice.nextLine();

      switch(choiceNum){
        case MENU_CHOICE.JOIN:
        joinMenu();
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
  //관리자 로그인 메뉴
  private static void adminLoginMenu() {
  
    MemberManager mm = new MemberManager();
    mm.verifyAdmin();

    int choiceNum;


  }

  //로그인 메뉴
  private static void loginMenu() {
    
  }
  //회원가입 메뉴
  public static void joinMenu() {
    MemberManager mm = new MemberManager();
    mm.joinMember();
  }
}
