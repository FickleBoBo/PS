package day_22.SWEA_D2_10760;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[1+N+1][1+M+1];
            int ans = 0;

            Arrays.fill(map[0], Integer.MAX_VALUE);
            for(int i=1 ; i<=N ; i++){
                Arrays.fill(map[i], Integer.MAX_VALUE);
                for(int j=1 ; j<=M ; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            Arrays.fill(map[N+1], Integer.MAX_VALUE);

            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=M ; j++){
                    int cnt = 0;
                    for(int k=0 ; k<8 ; k++){
                        if(map[i][j] > map[i+dr[k]][j+dc[k]]){
                            cnt++;
                        }
                    }
                    if(cnt >= 4){
                        ans++;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }
}
