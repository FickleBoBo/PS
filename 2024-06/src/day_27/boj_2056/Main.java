package day_27.BOJ_G4_2056;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 작업에 걸리는 시간을 저장하는 배열
        int[] wArr = new int[1+N];

        // 진입차수 저장 배열
        int[] indegree = new int[1+N];

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            wArr[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());

            // 선행 작업에 대한 인접 리스트 갱신
            while(st.hasMoreTokens()){
                adj[Integer.parseInt(st.nextToken())].add(i);
            }
        }

        // 큐를 활용한 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        // 작업을 완료하는데 걸리는 최소 시간을 저장하는 배열
        int[] dp = new int[1+N];

        // 진입차수가 0인 작업을 큐에 넣음
        for(int i=1 ; i<=N ; i++){
            if(indegree[i] == 0){
                q.offer(i);
                dp[i] = wArr[i];
            }
        }

        // 큐가 빌 때까지 작업을 하나씩 꺼내고 후순위 작업의 진입차수를 갱신해줌
        while(!q.isEmpty()){
            int node = q.poll();

            for(int next : adj[node]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }

                // 작업을 완료하는데 걸리는 최소 시간 갱신
                dp[next] = Math.max(dp[node] + wArr[next], dp[next]);
            }
        }

        // 마지막 작업이 시간이 제일 오래 걸리는건 아님(테케 4%)
        int max = Integer.MIN_VALUE;
        for(int n : dp){
            max = Math.max(max, n);
        }

        System.out.println(max);
    }
}
