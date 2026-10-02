package day_29.BOJ_G3_2206;

import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int r;
        int c;
        int breakWall;    // 벽은 부순 횟수

        public Node(int r, int c, int breakWall) {
            this.r = r;
            this.c = c;
            this.breakWall = breakWall;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0 ; i<N ; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = BFS();
        System.out.println(ans);
    }

    private static int BFS(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));

        // 노드의 행 위치, 노드의 열 위치, 노드가 벽을 부순 횟수에 대한 방문 체크 배열
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        // 거리
        int dist = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                Node node = q.poll();
                if((node.r==N-1) && (node.c==M-1)) return dist;    // 종료 조건

                for(int dir=0 ; dir<4 ; dir++){
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];
                    int breakWall = node.breakWall;

                    if(nr>=0 && nr<N && nc>=0 && nc<M){
                        // 이동할 수 있는 칸이면 벽을 부순 횟수를 그대로 가져감
                        if(map[nr][nc]=='0'){
                            if(!visited[nr][nc][breakWall]){
                                q.offer(new Node(nr, nc, breakWall));
                                visited[nr][nc][breakWall] = true;
                            }
                        }
                        // 이동할 수 없는 칸이면 벽을 더 부술 수 있으면 부수고 이동
                        else{
                            if((breakWall < 1) && !visited[nr][nc][breakWall+1]){
                                q.offer(new Node(nr, nc, breakWall+1));
                                visited[nr][nc][breakWall+1] = true;
                            }
                        }
                    }
                }
            }

            dist++;
        }

        return -1;
    }

}
