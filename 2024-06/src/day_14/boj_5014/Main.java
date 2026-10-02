package day_14.BOJ_S1_5014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int ans = BFS(S, G, F, U, D);
        if(ans >= 0){    // S == G 인 케이스가 테케 30% 에 있음
            System.out.println(ans);
        }
        else{
            System.out.println("use the stairs");
        }
    }

    private static int BFS(int curr, int target, int height, int up, int down){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(curr);

        boolean[] visited = new boolean[1+height];
        visited[curr] = true;

        int ans = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                // 목표층에 도달하면 종료
                if(node == target){
                    return ans;
                }

                // 다음 층이 건물에 있는 층이면서 방문 안한 층이면 Queue에 넣어줌
                int nextUp = node + up;
                if((nextUp <= height) && (!visited[nextUp])){
                    q.offer(nextUp);
                    visited[nextUp] = true;
                }
                int nextDown = node - down;
                if((nextDown >= 1) && (!visited[nextDown])){
                    q.offer(nextDown);
                    visited[nextDown] = true;
                }
            }

            ans++;
        }

        // G층에 도달할 수 없으면 음수를 리턴해서 조건문에 활용
        return -1;
    }

}
