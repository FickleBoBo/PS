package day_23.BOJ_S3_15652;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[] sel;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        sel = new int[M];

        combination(1, 0);

        System.out.println(sb.toString());

    }

    private static void combination(int idx, int sidx){
        if(sidx == M){
            for(int i=0 ; i<M ; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx ; i<=N ; i++){
            sel[sidx] = i;
            combination(i, sidx+1);
        }

    }

}
