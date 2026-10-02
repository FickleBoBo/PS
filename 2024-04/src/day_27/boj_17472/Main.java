package day_27.BOJ_G1_17472;

import java.util.*;

public class Main {

    // 간선 클래스 (출발 노드, 도착 노드, 가중치)
    static class Edge implements Comparable<Edge>{
        int x, y, v;

        public Edge(int x, int y, int v) {
            this.x = x; this.y = y; this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }

    // BFS 준비
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) {

        // step1 - 입력 받아서 정리하기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        /* step2 - 각 섬에 번호를 붙여 준다
         *
         * BFS를 통해 각 섬에 순서대로 번호를 부여한다
         * 그러면 각 섬을 하나의 노드로 간주할 수 있다!!
         * visited 없이 map을 바로 바꿀 수 있을 줄 알았는데, 복잡해질거 같아서 포기
         */
        int num = 1;    // 각 섬의 번호
        visited = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(visited[i][j]==0 && map[i][j]==1){
                    BFS(i, j, num++);
                }
            }
        }

        /* step3 - 각 섬에 대해서 다른 섬과의 거리를 구해서 간선 리스트에 저장한다
         *
         * 여기가 좀 어려웠는데, 가로 한번 세로 한번 쭉 돌면서 다리가 만들어지면 일단 다 넣었음
         * 바다를 기준으로 투포인터를 만들어서 좌우로 섬을 찾을 때까지 쭉 직진시키는 방식으로 함
         * 이러면 발생할 수 있는 상황이 3가지라고 생각됨
         *     1. 왼쪽(위쪽) 끝이 맵의 경계일 경우
         *     2. 오른쪽(아래쪽) 끝이 맵의 경계일 경우
         *     3. 양쪽 끝이 각각 섬을 찾은 경우 - 간선 리스트에 추가
         */
        List<Edge> edges = new ArrayList<>();

        // 세로 다리 찾기
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(visited[i][j]==0){
                    int start = j;
                    int end = j;

                    // 일단 상하로 각각 직진 시키기
                    while(start > 0 && visited[i][start]==0){
                        start--;
                    }
                    while(end < M-1 && visited[i][end]==0){
                        end++;
                    }

                    // 발생 가능한 상황
                    if(visited[i][start]==0){    // case1
                        j = end;
                    }
                    else if(visited[i][end]==0){    // case2
                        break;
                    }
                    else{    // case3
                        int x = visited[i][start];
                        int y = visited[i][end];
                        int v = end - start - 1;    // 다리의 길이가 가중치!!
                        if(v>1){    // 길이 1인 다리는 못 놓는다
                            edges.add(new Edge(x, y, v));
                            edges.add(new Edge(y, x, v));
                        }
                        j = end;
                    }
                }
            }
        }

        // 가로 다리 찾기
        for(int j=0 ; j<M ; j++){
            for(int i=0 ; i<N ; i++){
                if(visited[i][j]==0){
                    int start = i;
                    int end = i;
                    while(start > 0 && visited[start][j]==0){
                        start--;
                    }
                    while(end < N-1 && visited[end][j]==0){
                        end++;
                    }
                    if(visited[start][j]==0){
                        i = end;
                    }
                    else if(visited[end][j]==0){
                        break;
                    }
                    else{
                        int x = visited[start][j];
                        int y = visited[end][j];
                        int v = end - start - 1;
                        if(v>1){
                            edges.add(new Edge(x, y, v));
                            edges.add(new Edge(y, x, v));
                        }
                        i = end;
                    }
                }
            }
        }

        // 크루스칼 할거라 정렬 해줌
        Collections.sort(edges);

        // p배열 준비
        p = new int[num];    // num이 지금 섬의 개수 보다 1 크게 되는데 딱 0은 패딩자리라 최적화
        for(int i=1 ; i<num ; i++){
            p[i] = i;
        }

        // step4 - 크루스칼 돌리기
        int ans = 0;
        int cnt = 0;
        for(int i=0 ; i<edges.size() ; i++){
            int x = find(edges.get(i).x);
            int y = find(edges.get(i).y);
            if(x!=y){
                union(x, y);
                ans += edges.get(i).v;
                cnt++;
                if(cnt==num-1-1) break;    // num-1이 정점의 수라 num-2가 MST
            }
        }

        // step5 - 출력하기
        if(cnt!=num-2) System.out.println(-1);    // 크루스칼에서 break로 종료되어야 MST임
        else System.out.println(ans);

        sc.close();
    }

    static int[] p;

    private static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

    private static void BFS(int r, int c, int num){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = num;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 & nc<M && visited[nr][nc]==0 && map[nr][nc]==1){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = num;
                }
            }
        }
    }

}
