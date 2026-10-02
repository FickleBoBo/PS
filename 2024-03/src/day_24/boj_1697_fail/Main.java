package day_24.boj_1697_fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;

        if ((N != K) && (N == 0)) {
            N += 1;
            ans++;
        }

        while (N != K) {
            if (N > K) {
                ans = N - K;
                break;
            } else if (N * 2 < K) {
                N *= 2;
            } else {
                //
            }

            ans++;
        }


        System.out.println(ans);
    }

}
