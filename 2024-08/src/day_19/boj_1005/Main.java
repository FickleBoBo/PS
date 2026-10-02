package day_19.BOJ_G3_1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // Darr : 각 건물당 걸리는 시간 저장
            int[] Darr = new int[1+N];
            st = new StringTokenizer(br.readLine());
            for(int i=1 ; i<=N ; i++){
                Darr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] adj = new ArrayList[1+N];
            for(int i=1 ; i<=N ; i++){
                adj[i] = new ArrayList<>();
            }

            // 진입차수 저장
            int[] indegree = new int[1+N];

            for(int i=0 ; i<K ; i++){
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                adj[X].add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            // Queue를 활용한 위상 정렬
            Queue<Integer> q = new ArrayDeque<>();
            int[] dp = new int[1+N];

            for(int i=1 ; i<=N ; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                    dp[i] = Darr[i];
                }
            }

            while(!q.isEmpty()){
                int node = q.poll();

                for(int next : adj[node]){
                    indegree[next]--;

                    if(indegree[next] == 0){
                        q.offer(next);
                    }

                    // dp 테이블 갱신
                    dp[next] = Math.max(dp[next], dp[node] + Darr[next]);
                }
            }

            sb.append(dp[W]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
