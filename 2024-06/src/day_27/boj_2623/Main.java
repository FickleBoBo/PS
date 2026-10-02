package day_27.BOJ_G3_2623;

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
            st.nextToken();    // 담당한 가수의 수는 필요가 없어서 버려줌

            int A = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int B = Integer.parseInt(st.nextToken());

                adj[A].add(B);
                indegree[B]++;

                A = B;    // 새로 토큰으로 뽑을 가수의 이전 가수를 저장
            }
        }

        // 큐를 활용한 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        // 정렬한 가수의 수
        int cnt = 0;

        // 진입차수가 0인 가수를 큐에 넣음
        for(int i=1 ; i<=N ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 가수를 하나씩 꺼내고 개수를 세고 후순위 가수의 진입차수를 갱신해줌
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            sb.append(node).append("\n");

            for(int next : adj[node]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        // 가수의 순서를 정할 수 있는 경우 순서 출력
        if(cnt == N){
            bw.write(sb.toString());
        }
        else{
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }
}
