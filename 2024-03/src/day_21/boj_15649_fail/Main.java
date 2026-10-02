package day_21.BOJ_S3_15649_Fail;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] sArr;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        sArr = new int[M];

        combination(1, 0);

        System.out.print(sb.toString());

        sc.close();
    }

    static void combination(int idx, int sidx){
        if(sidx == M){
            for(int i=0 ; i<sidx ; i++){
                sb.append(sArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx ; i<=N ; i++){
            sArr[sidx] = i;
            if(sidx == i) combination(i+1, sidx+1);
            else combination(i, sidx+1);
        }
    }

}
