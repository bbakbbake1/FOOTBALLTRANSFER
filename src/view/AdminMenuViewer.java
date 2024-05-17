package view;

import java.util.Scanner;

public class AdminMenuViewer {
  public static Scanner choice = new Scanner(System.in);

  // 관리자 메뉴
  public static void adminMenu() {
    System.out.println("==========ADMIN MENU==========");
    System.out.println("1.선수 생성");
    System.out.println("2.팀 생성");
    System.out.println("3.선수 삭제");
    System.out.println("4.팀 삭제");
    System.out.println("5.관리자 메뉴 종료");

  }

}
