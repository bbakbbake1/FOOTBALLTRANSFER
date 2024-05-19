package view.admin;

import java.util.Scanner;

public class AdminMenuViewer {
  public static Scanner sc = new Scanner(System.in);

  // 관리자 메뉴
  public static void adminMenu() {
    System.out.println("==========ADMIN MENU==========");
    System.out.println("1.팀 생성");
    System.out.println("2.선수 생성");
    System.out.println("3.팀 삭제");
    System.out.println("4.선수 삭제");
    System.out.println("5.선수 목록");
    System.out.println("6.팀 목록");
    System.out.println("7.관리자 메뉴 종료");

  }

}
