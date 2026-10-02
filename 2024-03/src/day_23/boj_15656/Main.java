package day_23.BOJ_S3_15656;

import java.util.Arrays;
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
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        sel = new int[M];

        permutationWithRepetition(0);

        System.out.println(sb.toString());
    }

    private static void permutationWithRepetition(int sidx){
        if(sidx == M){
            for(int i=0 ; i<M ; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0 ; i<N ; i++){
            sel[sidx] = arr[i];
            permutationWithRepetition(sidx+1);
        }

    }

}
