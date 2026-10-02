package day_06.BOJ_G3_9466;

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
            int N = Integer.parseInt(br.readLine());

            // 인접리스트
            List<Integer>[] adj = new ArrayList[1+N];
            for(int i=1 ; i<=N ; i++) adj[i] = new ArrayList<>();

            // 진입차수 배열
            int[] indegree = new int[1+N];

            // 인접리스트와 진입차수 배열 갱신
            st = new StringTokenizer(br.readLine());
            for(int i=1 ; i<=N ; i++){
                int n = Integer.parseInt(st.nextToken());

                adj[i].add(n);
                indegree[n]++;
            }

            // 위상 정렬(순환 그래프 부분의 노드 수가 프로젝트 팀을 이룬 학생의 수)
            int ans = 0;
            Queue<Integer> q = new ArrayDeque<>();

            for(int i=1 ; i<=N ; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                    ans++;
                }
            }

            while(!q.isEmpty()){
                int node = q.poll();

                for(int next : adj[node]){
                    indegree[next]--;

                    if(indegree[next] == 0){
                        q.offer(next);
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
