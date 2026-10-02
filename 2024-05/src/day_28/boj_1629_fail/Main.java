package day_28.BOJ_S1_1629_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] dp = new int[5];
        dp[0] = A;

        for(int i=1 ; i<=4 ; i++){
            dp[i] = dp[i-1] * A % C;
        }

        System.out.println(dp[B%4]);

//        System.out.println(calculate(A, B, C) % C);
    }

//    private static long calculate(int a, int b, int c) {
//        if (b == 1) return a % c;
//
//        if(b % 2 == 0){
//            return (calculate(a, b/2, c) % c) * (calculate(a, b/2, c) % c);
//        }
//        else{
//            return (calculate(a, b/2, c) % c) * (calculate(a, b/2, c) % c) * a % c;
//        }
//    }
}
