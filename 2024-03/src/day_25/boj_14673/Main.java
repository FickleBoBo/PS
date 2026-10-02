package day_25.BOJ_G4_14673;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int M;
    static int N;
    static int[][] map;
    static int[][] copyMap;
    static int ans = 0;

    static int[] sel = new int[3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N+2][M+2];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        permutation(0);

        System.out.println(ans);

        sc.close();
    }

    private static void printCopyMap(){
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                System.out.print(copyMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void copyOriginMap(){
        copyMap = new int[N+2][M+2];
        for(int i=1 ; i<=N ; i++){
            copyMap[i] = Arrays.copyOf(map[i], M+2);
        }
    }

    private static void dropPuzzle(){
        for(int j=1 ; j<=M ; j++){
            out:
            for(int i=N ; i>=1 ; i--){
                if(copyMap[i][j]==0){
                    for(int k=i-1 ; k>=1 ; k--){
                        if(copyMap[k][j] != 0){
                            int tmp = copyMap[k][j];
                            copyMap[k][j] = copyMap[i][j];
                            copyMap[i][j] = tmp;
                            break;
                        }
                        if(k == 1){
                            break out;
                        }
                    }
                }
            }
        }
    }

    private static void permutation(int sidx){
        if(sidx == 3){
            int cnt = 0;
            copyOriginMap();
            for(int i=0 ; i<3 ; i++){
                cnt += BFS(sel[i]);
                dropPuzzle();
            }
            ans = Math.max(ans, cnt);
            return;
        }

        for(int i=0 ; i<N*M ; i++){
            sel[sidx] = i;
            permutation(sidx+1);
        }
    }

    private static int BFS(int n){
        int cnt = 0;
        int r = n / M + 1;
        int c = n % M + 1;
        int value = copyMap[r][c];
        if(value == 0){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        cnt++;
        copyMap[r][c] = 0;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(copyMap[nr][nc] == value){
                    q.offer(new int[] {nr, nc});
                    cnt++;
                    copyMap[nr][nc] = 0;
                }
            }
        }
        return (int) Math.pow(cnt, 2);
    }
}
