package day_28.SWEA_D3_1217;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){
            sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.printf("#%d %d\n", tc, powMethod(N, M));
        }
        sc.close();
    }

    // 오늘 배운 분할정복으로 재귀 돌려줌
    private static int powMethod(int n, int m) {
        if(m == 1) return n;

        int tmp = powMethod(n, (m/2));

        if(m % 2 == 0) return tmp * tmp;
        else return tmp * tmp * n;
    }

}
