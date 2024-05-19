package view.login;

import java.util.Scanner;

public class LoginMenuViewer {
    public static Scanner sc = new Scanner(System.in);
    public static void loginMenu() {
        System.out.println("로그인 메뉴");
        System.out.println("1. 내 팀 정보 보기");
        System.out.println("2. 선수영입");
        System.out.println("3. 선수 판매");
        System.out.println("4. 종료");
    }
}
