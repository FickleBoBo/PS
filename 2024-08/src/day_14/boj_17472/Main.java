package day_14.BOJ_G1_17472;

import java.io.*;
import java.util.*;

public class Main {

    // 유니온 파인드 알고리즘의 부모 배열
    static int[] p;

    // find-set
    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union-set
    private static void union(int x, int y){
        p[y] = x;
    }

    // BFS 준비
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    // 격자의 좌표를 저장하는 노드 클래스
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 두 섬과 거리를 저장하는 간선 클래스
    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // step.1 - 입력 값을 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // step.2 - BFS 알고리즘으로 각 섬에 번호를 부여
        // num : 섬의 번호
        visited = new boolean[N][M];
        int num = 1;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] == 0) continue;
                if(visited[i][j]) continue;

                BFS(i, j, num);
                num++;
            }
        }

        // step.3 - 바다를 기준으로 두 섬을 연결하는 다리가 있으면 간선 우선순위 큐에 넣어줌
        // edges : 크루스칼 알고리즘에 사용할 간선 우선순위 큐
        // 세로 방향 다리를 먼저 탐색하고 이후 가로 방향 다리를 탐색함
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i=1 ; i<N-1 ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] > 0) continue;

                if(map[i-1][j] > 0){
                    int k = 1;
                    int len = 1;

                    while(i+k < N && map[i+k][j] == 0){
                        k++;
                        len++;
                    }

                    if(i+k == N) continue;    // 한쪽 끝이 격자 밖인지 판단
                    if(len == 1) continue;    // 다리의 길이는 2 이상

                    edges.add(new Edge(map[i-1][j], map[i+k][j], len));
                }
            }
        }

        for(int i=0 ; i<N ; i++){
            for(int j=1 ; j<M-1 ; j++){
                if(map[i][j] > 0) continue;

                if(map[i][j-1] > 0){
                    int k = 1;
                    int len = 1;

                    while(j+k < M && map[i][j+k] == 0){
                        k++;
                        len++;
                    }

                    if(j+k == M) continue;    // 한쪽 끝이 격자 밖인지 판단
                    if(len == 1) continue;    // 다리의 길이는 2 이상

                    edges.add(new Edge(map[i][j-1], map[i][j+k], len));
                }
            }
        }

        // make-set
        p = new int[num];
        for(int i=1 ; i<num ; i++) p[i] = i;

        int sum = 0;
        int cnt = 0;

        // step.4 - 크루스칼 알고리즘으로 모든 섬을 연결하는 다리 길이의 최솟값 탐색
        while(!edges.isEmpty()){
            Edge e = edges.poll();

            int x = find(e.x);
            int y = find(e.y);

            if(x == y) continue;

            union(x, y);
            sum += e.w;
            cnt++;

            if(cnt == num-2) break;    // num이 섬의 개수 + 1이라서 num-2 개의 다리를 연결
        }

        System.out.println(cnt == num-2 ? sum : -1);
    }

    private static void BFS(int r, int c, int num){
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(r, c));
        visited[r][c] = true;
        map[r][c] = num;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc] > 0){
                    q.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                    map[nr][nc] = num;
                }
            }
        }
    }

}
