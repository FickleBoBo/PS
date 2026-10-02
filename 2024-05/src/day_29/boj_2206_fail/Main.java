package day_29.BOJ_G3_2206_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r;
        int c;
        boolean breakWall;

        public Node(int r, int c, boolean breakWall) {
            this.r = r;
            this.c = c;
            this.breakWall = breakWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<int[]> walls = new ArrayList<>();
        map = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine());
        }
        String[] input = sb.toString().split("");
        int idx = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = -1 * Integer.parseInt(input[idx++]);
                if(map[i][j] == -1){
                    walls.add(new int[]{i, j});
                }
            }
        }

        int ans = BFS();

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    private static int BFS(){
        int[][] visited = new int[N][M];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false));
        map[0][0] = 1;
        visited[0][0] = 1;
        int ans = 1;

        while(!q.isEmpty()){
            ans++;
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                Node item = q.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item.r + dr[dir];
                    int nc = item.c + dc[dir];
                    if(nr>=0 && nr<N && nc>=0 && nc<M){
                        if(visited[nr][nc] == 0){
                            if(map[nr][nc] == 0){
                                q.offer(new Node(nr, nc, item.breakWall));
                                map[nr][nc] = ans;
                                if(item.breakWall) visited[nr][nc] = 2;
                                else visited[nr][nc] = 1;
                            }
                            else{
                                if(item.breakWall){
                                    continue;
                                }
                                else{
                                    q.offer(new Node(nr, nc, true));
//                                    map[nr][nc] = ans;
                                    visited[nr][nc] = 2;
                                }
                            }
                        }
                        else if(visited[nr][nc] == 1){
                            continue;
                        }
                        else{
                            if(!item.breakWall){
                                if(map[nr][nc] >= 0){
                                    q.offer(new Node(nr, nc, false));
                                    map[nr][nc] = ans;
                                    visited[nr][nc] = 1;
                                }
                                else{
                                    q.offer(new Node(nr, nc, true));
//                                    map[nr][nc] = ans;
                                    visited[nr][nc] = 2;
                                }
                            }
                        }
                    }
                }



                if(map[N-1][M-1] != 0) break;
            }

//            for(int k=0 ; k<N ; k++){
//                for(int j=0 ; j<M ; j++){
//                    System.out.printf("%3d", map[k][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//            for(int i=0 ; i<N ; i++){
//                for(int j=0 ; j<M ; j++){
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<M ; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<M ; j++){
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(map[N-1][M-1] == 0) return Integer.MAX_VALUE;
        else return ans-1;
    }

}
