package day_19.BOJ_G2_2637;

import java.io.*;
import java.util.*;

public class Main {

    // 부품의 정보를 담는 클래스로 부품의 번호 v, 부품의 개수 cnt로 구성
    static class Node{
        int v;
        int cnt;

        public Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 진입차수, 진출차수 저장
        int[] indegree = new int[1+N];
        int[] outdegree = new int[1+N];

        for(int i=1 ; i<=M ; i++){
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            adj[X].add(new Node(Y, K));
            indegree[Y]++;
            outdegree[X]++;
        }

        // Queue를 활용한 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        // 조립에 필요한 최소 부품 수를 저장하는 dp 테이블
        int[] dp = new int[1+N];

        // 진입차수가 0인 작업을 Queue에 넣음(이 문제는 N번만 완제품)
        q.offer(N);
        dp[N] = 1;

        while(!q.isEmpty()){
            int node = q.poll();

            for(Node next : adj[node]){
                indegree[next.v]--;

                if(indegree[next.v] == 0){
                    q.offer(next.v);
                }

                // 해당 부품의 개수와 해당 부품을 이루는 기본/중간 부품의 수를 곱해서 갱신
                dp[next.v] += dp[node] * next.cnt;
            }
        }

        // 진출차수가 0인 부품이 기본 부품
        for(int i=1 ; i<=N ; i++){
            if(outdegree[i] == 0){
                sb.append(i).append(" ").append(dp[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
