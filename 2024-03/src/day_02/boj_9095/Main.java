package day_02.BOJ_S3_9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int n = sc.nextInt();
            System.out.println(recursion(n));
        }
        sc.close();
    }

    // An = An-1 + An-2 + An-3 규칙(왜 그런진 잘 모름)
    static int recursion(int n) {
        // 종료 조건
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else if (n == 3) return 4;
        return recursion(n-3) + recursion(n-2) + recursion(n-1);
    }

}
