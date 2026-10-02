package day_27.BOJ_P5_2887_Fail;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine());
            sb.append(" ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int[][] coordinate = new int[1+N][3];
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<3 ; j++){
                coordinate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int[] dist = new int[1+N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        boolean[] visited = new boolean[1+N];

        int ans = 0;
        int cnt = 0;
        while(true){
            Node node = pq.poll();

            if(visited[node.to]) continue;

            visited[node.to] = true;
            ans += node.dist;

            for(int i=1 ; i<=N ; i++){
                if(!visited[i]){
                    int tmp = Distance(coordinate[i], coordinate[node.to]);
                    if(tmp <= dist[i]){
                        pq.offer(new Node(i, tmp));
                        dist[i] = tmp;
                    }
                }
            }

            if(++cnt == N) break;
        }

        System.out.println(ans);
    }

    private static int Distance(int[] arr1, int[] arr2){
        int dx = Math.abs(arr1[0] - arr2[0]);
        int dy = Math.abs(arr1[1] - arr2[1]);
        int dz = Math.abs(arr1[2] - arr2[2]);
        return Math.min(dx, Math.min(dy, dz));
    }

}
