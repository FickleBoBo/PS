package day_26.BOJ_G4_1987;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R;
    static int C;
    static char[][] map;
    static Set<Character> visited = new HashSet<>();
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

        visited.add(map[1][1]);
        DFS(1, 1);

        System.out.println(ans);
    }

    private static void DFS(int r, int c){
        ans = Math.max(ans, visited.size());

        for(int dir=0 ; dir<4 ; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr>=1 && nr<=R && nc>=1 && nc<=C && !visited.contains(map[nr][nc])){
                visited.add(map[nr][nc]);
                DFS(nr, nc);
                visited.remove(map[nr][nc]);
            }
        }

    }
}
