package day_10.BOJ_B2_1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        for(int i=0 ; i<N ; i++){
            int num = sc.nextInt();
            boolean isPrime = true;
            for(int j=2 ; j<=Math.sqrt(num) ; j++){    // 소수의 정의
                if(num % j == 0){
                    isPrime = false;
                }
            }
            if(isPrime){
                if(num != 1){    // 1도 소수로 카운트 돼서 예외처리(약간 불편)
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
