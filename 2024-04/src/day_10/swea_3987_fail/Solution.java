package day_10.SWEA_D3_3987_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int N;
    static int C;
    static int[] arr;
    static int[] sel;
    static long ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            N = sc.nextInt();
            C = sc.nextInt();
            arr = new int[N];
            for(int i=0 ; i<N ; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            ans = 0;

            for(int i=1 ; i<=N ; i++){
                sel = new int[i];
                combination(0, 0, i, 0, 0);
            }

            System.out.printf("#%d %d\n", tc, ans);
        }

        sc.close();
    }

    private static void combination(int idx, int sidx, int len, int c, int sum){
        if(c > C) return;

        if(sidx == len){
            ans = ans > sum ? ans : sum;
            return;
        }

        for(int i=idx ; i<N ; i++){
            sel[sidx] = arr[i];
            combination(i+1, sidx+1, len, c+sel[sidx], sum+sel[sidx]*sel[sidx]);
        }
    }

}
