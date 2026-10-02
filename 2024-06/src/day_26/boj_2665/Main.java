package day_26.BOJ_G4_2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            String[] input = br.readLine().split("");
            for(int j=0 ; j<N ; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int ans = BFS(N, map);
        System.out.println(ans);
    }

    private static int BFS(int N, int[][] map){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));

        int[][] visited = new int[N][N];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<N){
                    if(map[nr][nc] == 1){
                        if(visited[nr][nc] == -1){
                            visited[nr][nc] = node.cnt;
                            q.offer(new Node(nr, nc, node.cnt));
                        }
                        else{
                            if(visited[nr][nc] > node.cnt){
                                visited[nr][nc] = node.cnt;
                                q.offer(new Node(nr, nc, node.cnt));
                            }
                        }
                    }
                    else{
                        if(visited[nr][nc] == -1){
                            visited[nr][nc] = node.cnt + 1;
                            q.offer(new Node(nr, nc, node.cnt + 1));
                        }
                        else{
                            if(visited[nr][nc] > node.cnt + 1){
                                visited[nr][nc] = node.cnt + 1;
                                q.offer(new Node(nr, nc, node.cnt + 1));
                            }
                        }
                    }
                }

            }

//            printVisited(N, visited);
        }

//        printVisited(N, visited);
        return visited[N-1][N-1];
    }

    private static void printVisited(int N, int[][] arr){
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
