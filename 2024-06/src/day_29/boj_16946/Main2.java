package day_29.BOJ_G2_16946;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;
    static int[][] numberingMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 덧셈 연산을 위해 int[][] 배열로 초기화
        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            char[] input = br.readLine().toCharArray();

            for(int j=0 ; j<M ; j++){
                map[i][j] = input[j] - '0';
            }
        }

        numberingMap = new int[N][M];
        Map<Integer, Integer> cntMap = new HashMap<>();
        visited = new boolean[N][M];

        // 방문안한 칸에 대해 BFS
        int num = 1;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(!visited[i][j] && map[i][j]==0){
                    cntMap.put(num, BFS(num, i, j));
                    num++;
                }
            }
        }

        // 각각의 벽마다 사방탐색으로 이동할 수 있는 칸으로 이루어진 그룹을 탐색
        // 같은 그룹을 중복으로 세지 않게 Set으로 중복 제거
        Set<Integer> set;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] == 1){
                    set = new HashSet<>();

                    for(int dir=0 ; dir<4 ; dir++){
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];

                        if(nr>=0 && nr<N && nc>=0 && nc<M && numberingMap[nr][nc]>0){
                            set.add(numberingMap[nr][nc]);
                        }
                    }

                    for(int key : set){
                        map[i][j] += cntMap.get(key);
                    }
                }
            }
        }

        // 조건 맞춰서 출력
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                sb.append(map[i][j] % 10);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // numberingMap에 그룹별 번호를 num으로 붙이고 그룹의 원소 개수를 반환
    private static int BFS(int num, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        // 해당 위치에서 방문 가능한 칸의 개수
        int cnt = 1;

        while(!q.isEmpty()){
            int[] node = q.poll();
            numberingMap[node[0]][node[1]] = num;

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]==0){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }

        }

        return cnt;
    }

}
