package day_17.BOJ_G5_2166;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] posArr = new int[N+1][2];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            posArr[i][0] = Integer.parseInt(st.nextToken());
            posArr[i][1] = Integer.parseInt(st.nextToken());
        }
        posArr[N][0] = posArr[0][0];
        posArr[N][1] = posArr[0][1];

        double ans = shoelaceFormula(N, posArr);

        System.out.printf("%.1f", ans);
    }

    private static double shoelaceFormula(int N, int[][] arr){
        long area = 0;

        for(int i=0 ; i<N ; i++){
            area += (long) arr[i][0] * arr[i+1][1] - (long) arr[i][1] * arr[i+1][0];
        }

        return Math.abs(0.5 * area);
    }

}
