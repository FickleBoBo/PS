package day_20.BOJ_G2_16985;

import java.io.*;
import java.util.*;

// 1300ms 언저리 별차이 없음
public class Main2 {

    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    static final int N = 5;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][][] map = new boolean[N][N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<N ; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
        }

        sel = new int[5]; visited = new boolean[5]; perm(0);
        sel = new int[5]; permWithRep(0);

        // 회전된 2차원 배열을 미리 구해서 사용
        boolean[][][][] rotatedMap = new boolean[5][4][N][N];
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<4 ; j++){
                rotatedMap[i][j] = rotateMap(map[i], j);
            }
        }

        for (int[] order : perm_0_4) {
            for (int[] rotation : perm_0_3) {

                // 미리 구한 것을 사용
                boolean[][][] copyMap = new boolean[N][N][N];
                for(int k=0 ; k<5 ; k++){
                    copyMap[k] = rotatedMap[order[k]][rotation[k]];
                }

                if(!copyMap[0][0][0]) continue;
                if(!copyMap[N-1][N-1][N-1]) continue;

                int result = BFS(copyMap);
                if(result == -1) continue;

                ans = Math.min(ans, result);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static int BFS(boolean[][][] map){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        // 원본을 얕은 참조해서 visited 사용
        boolean[][][] visited = new boolean[N][N][N];
        visited[0][0][0] = true;

        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int[] item = q.poll();

                if(item[0]==N-1 && item[1]==N-1 && item[2]==N-1){
                    return dist;
                }

                for(int dir=0 ; dir<6 ; dir++){
                    int nh = item[0]+ dh[dir];
                    int nr = item[1]+ dr[dir];
                    int nc = item[2]+ dc[dir];

                    if(nh>=0 && nh<N && nr>=0 && nr<N && nc>=0 && nc<N && !visited[nh][nr][nc] && map[nh][nr][nc]){
                        q.offer(new int[]{nh, nr, nc});
                        visited[nh][nr][nc] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }

    private static boolean[][] rotateMap(boolean[][] copy, int n){
        if(n == 0) return copy;

        return rotateMap(rotateMap90(copy), n-1);
    }

    private static boolean[][] rotateMap90(boolean[][] copy){
        boolean[][] result = new boolean[N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                result[i][j] = copy[N-j-1][i];
            }
        }

        return result;
    }

    static List<int[]> perm_0_4 = new ArrayList<>();
    static List<int[]> perm_0_3 = new ArrayList<>();
    static int[] sel;
    static boolean[] visited;

    private static void perm(int sidx){
        if(sidx == N){
            perm_0_4.add(sel.clone());
            return;
        }

        for(int i=0 ; i<N ; i++){
            if(visited[i]) continue;

            sel[sidx] = i;
            visited[i] = true;
            perm(sidx + 1);
            visited[i] = false;
        }
    }

    private static void permWithRep(int sidx){
        if(sidx == N){
            perm_0_3.add(sel.clone());
            return;
        }

        for(int i=0 ; i<N-1 ; i++){
            sel[sidx] = i;
            permWithRep(sidx+1);
        }
    }
}

