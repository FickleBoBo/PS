package day_23.BOJ_S2_15663_Fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static List<Integer> arr = new ArrayList<>();
    static int[] sel;
    static boolean[] visited;
    static boolean[] duplicatedNums;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        duplicatedNums = new boolean[N];
        sel = new int[M];
        visited = new boolean[N];
        for(int i=0 ; i<N ; i++){
            int num = sc.nextInt();
            if(arr.contains(num)){
                duplicatedNums[i] = true;
            }
            arr.add(num);
        }
        Collections.sort(arr);

        permutation(0);

        System.out.println(sb.toString());
    }

    private static void permutation(int sidx){
        if(sidx == M){
            for(int n : sel){
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0 ; i<N ; i++){
            if(!visited[i] && !duplicatedNums[i]){
                sel[sidx] = arr.get(i);
                visited[i] = true;
                permutation(sidx+1);
                visited[i] = false;
            }
        }

    }

}
