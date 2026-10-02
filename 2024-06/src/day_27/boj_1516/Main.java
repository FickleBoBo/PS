package day_27.BOJ_G3_1516;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 건설에 걸리는 시간을 저장하는 배열
        int[] w = new int[1+N];

        // 진입차수 저장 배열
        int[] indegree = new int[1+N];

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int node = Integer.parseInt(st.nextToken());

                if(node == -1) break;    // 종료 조건

                adj[node].add(i);
                indegree[i]++;
            }
        }

        // 큐를 활용한 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        // 건설을 완료하는데 걸리는 최소 시간을 저장하는 배열
        int[] dp = new int[1+N];

        // 진입차수가 0인 작업을 큐에 넣음
        for(int i=1 ; i<=N ; i++){
            if(indegree[i] == 0){
                q.offer(i);
                dp[i] = w[i];
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next : adj[node]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }

                // 건설을 완료하는데 걸리는 최소 시간 갱신
                dp[next] = Math.max(dp[node] + w[next], dp[next]);
            }
        }

        for(int i=1 ; i<=N ; i++){
            bw.write(dp[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
