package view;

import java.util.Scanner;

public class MenuViewer {
  public static Scanner choice = new Scanner(System.in);

  public static void mainMenuViewer() {
    System.out.println();
    System.out.println("==========WELLCOME TO FOOTBALL TRANSFER MARKET========== ");
    System.out.println("1. 회원가입");
    System.out.println("2. 로그인");
    System.out.println("3. 관리자 로그인");
    System.out.println("4. 종료");
  }

}
