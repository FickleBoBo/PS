package day_08.BOJ_G4_16234;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        while(true){
            flag = false;
            visited = new boolean[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if(!visited[i][j]){
                        BFS(i, j);
                    }
                }
            }
            if(!flag) break;
            ans++;
        }

//        printMap();
        System.out.println(ans);

        sc.close();
    }

    private static void BFS(int r, int c){
//        System.out.printf("r : %d, c : %d\n", r, c);
        int sum = map[r][c];
//        System.out.println(sum);
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.offer(new int[]{r, c});
        q2.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){
                    int diff = Math.abs(map[nr][nc] - map[item[0]][item[1]]);
//                    System.out.println(map[nr][nc] + " " + map[item[0]][item[1]] + " " + diff);
                    if(diff >= L && diff <= R){
                        sum += map[nr][nc];
                        q.offer(new int[]{nr, nc});
                        q2.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        int newN = sum / q2.size();
//        System.out.println(newN);
//        System.out.println(q2.size());
        if(q2.size() > 1){
            flag = true;
        }
        while(!q2.isEmpty()){
            int[] item = q2.poll();
            map[item[0]][item[1]] = newN;
        }

//        printMap();
    }

    private static void printMap(){
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
