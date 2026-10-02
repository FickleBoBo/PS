package day_10.BOJ_S4_9372;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            for(int j=0 ; j<M ; j++){
                sc.nextInt();
                sc.nextInt();
            }

            /* 모든 국가 여행 가능 = 모든 노드 연결
            *  N개의 노드에 N-1개의 간선으로 연결 가능
            */
            System.out.println(N-1);
        }
        sc.close();
    }
}
