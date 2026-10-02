package day_30.BOJ_G4_1261;

import java.io.*;
import java.util.*;

public class Main_0_1_BFS_visited {

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static final int INF = 1_000_000_000;
    static int N;
    static int M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int ans = BFS();
        System.out.println(ans);
    }

    // 0-1 BFS
    // 벽을 부술 때의 가중치 1, 부수지 않을 때 가중치 0 이어서 적용 가능
    // Deque을 통해 구현
    private static int BFS(){
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, 0));

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        // 해당 위치에 가기 위해 벽을 부순 횟수를 저장하는 배열
        int[][] breakWall = new int[N][M];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(breakWall[i], INF);
        }
        breakWall[0][0] = 0;

        while(!dq.isEmpty()){
            Node node = dq.pollFirst();    // 꺼내는건 앞에서 꺼냄
            if(breakWall[N-1][M-1] < INF) return breakWall[N-1][M-1];    // 한번이라도 갱신되면 그게 최솟값

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]){
                    // 빈칸이면서 벽을 덜 부수고 갈 수 있으면 덱의 앞에 넣음
                    if(map[nr][nc]=='0'){
                        if(breakWall[nr][nc] > breakWall[node.r][node.c]){
                            breakWall[nr][nc] = breakWall[node.r][node.c];
                            dq.offerFirst(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                    // 벽이면서 벽을 덜 부수고 갈 수 있으면 덱의 뒤에 넣음
                    else{
                        if(breakWall[nr][nc] > breakWall[node.r][node.c] + 1){
                            breakWall[nr][nc] = breakWall[node.r][node.c] + 1;
                            dq.offerLast(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }

        // 실제로 반환될 일은 없음
        return -1;
    }

}
