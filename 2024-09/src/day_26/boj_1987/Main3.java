package day_26.BOJ_G4_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R;
    static int C;
    static char[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[1+R][1+C];
        for(int i=1 ; i<=R ; i++){
            String input = br.readLine();
            for(int j=1 ; j<=C ; j++){
                map[i][j] = input.charAt(j-1);
            }
        }

        DFS(1, 1, 1, 1 << (map[1][1] - 'A'));

        System.out.println(ans);
    }

    private static void DFS(int r, int c, int cnt, int visit){
        ans = Math.max(ans, cnt);

        for(int dir=0 ; dir<4 ; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if((visit & (1 << (map[nr][nc] - 'A'))) == 0 && nr>=1 && nr<=R && nc>=1 && nc<=C){
                DFS(nr, nc, cnt+1, (visit | (1 << map[nr][nc] - 'A')));
            }
        }

    }
}
