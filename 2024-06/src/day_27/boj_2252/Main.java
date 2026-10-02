package day_27.BOJ_G3_2252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 진입차수 저장 배열
        int[] indegree = new int[1+N];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            indegree[B]++;
        }

        // 큐를 활용한 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        // 진입차수가 0인 학생을 큐에 넣음
        for(int i=1 ; i<=N ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 학생을 하나씩 꺼내고 후순위 학생의 진입차수를 갱신해줌
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node).append(" ");

            for(int next : adj[node]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
