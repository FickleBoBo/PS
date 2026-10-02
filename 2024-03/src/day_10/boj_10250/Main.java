package day_10.BOJ_B3_10250;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int frontN = N % H;    // 계산식
            int backN = N / H + 1;    // 계산식
            if(frontN == 0) {    // 모듈러 연산 예외처리
                frontN = H;
                backN--;
            }
            if(backN < 10){
                System.out.println(frontN + "0" + backN);
            }
            else{
                System.out.println(frontN + "" + backN);    // 출력 양식
            }
        }
        sc.close();
    }
}
