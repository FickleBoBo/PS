package day_28.BOJ_S2_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = BFS(A, B);

        System.out.println(ans);
    }

    private static int BFS(int A, int B){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(A);

        // 배열로 방문 체크
        boolean[] visited = new boolean[1+B];
        visited[A] = true;

        int ans = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                if(node == B) return ans;    // 종료 조건

                // 2를 곱하는 경우
                if((node*2 <= B) && !visited[node*2]){
                    q.offer(node*2);
                    visited[node*2] = true;
                }
                // 1을 수의 가장 오른쪽에 추가하는 경우
                // 10을 곱하고 1을 더해야해서 int형의 범위를 넘어갈 수 있음
                if(((node*10L+1) <= B) && !visited[node*10+1]){
                    q.offer(node*10+1);
                    visited[node*10+1] = true;
                }
            }

            ans++;
        }

        return -1;    // 못 찾은 경우
    }

}
