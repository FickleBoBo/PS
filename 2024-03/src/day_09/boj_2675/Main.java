package day_09.BOJ_B2_2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();    // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){    // 각각의 테스트 케이스
            int R = sc.nextInt();
            char[] S = sc.next().toCharArray();    // 문자열을 char[] 변환해서 받음
            for(char c : S){    // 각각의 문자에 대해서
                for(int i=0 ; i<R ; i++) {    // R번 반복해서 출력
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
