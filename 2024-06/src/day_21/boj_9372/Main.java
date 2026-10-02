package day_21.BOJ_S4_9372;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i=0 ; i<M ; i++){
                br.readLine();    // 그냥 버리는 값
            }

            // 문제 조건을 통해 그래프를 연결하는데 필요한 최소 간선의 수를 구하면 된다
            // MST 개념에 따라 N개의 노드는 N-1개의 간선으로 연결 가능
            System.out.println(N-1);
        }

    }
}
