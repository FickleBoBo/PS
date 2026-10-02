package day_20.BOJ_G2_16985;

import java.io.*;
import java.util.*;

// 1300ms 언저리
public class Main {

    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    static final int N = 5;

    // 최단거리를 구하니까 최댓값으로 초기화
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // map에는 1과 0을 boolean 타입으로 바꿔서 저장
        // 갈 수 있는 칸 : true
        // 갈 수 없는 칸 : false
        boolean[][][] map = new boolean[N][N][N];

        // 입력 받아서 기본 미로 세팅
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<N ; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
        }

        // perm 메서드를 통해 0 ~ 4의 길이 5짜리 순열의 모든 경우의 수를 perm_0_4에 담음(각 면의 순서를 의미)
        // permWithRep 메서드를 통해 0 ~ 3의 길이 5짜리 중복순열의 모든 경우의 수를 perm_0_3 담음(각 면의 회전을 의미)
        sel = new int[5]; visited = new boolean[5]; perm(0);
        sel = new int[5]; permWithRep(0);

        // 순서와 회전에 대한 2중 for문으로 copyMap을 얻어내고 BFS를 돌림
        for (int[] order : perm_0_4) {
            for (int[] rotation : perm_0_3) {
                boolean[][][] copyMap = setting(map, order, rotation);

                // 출발지가 들어갈 수 없는 칸이면 continue
                if(!copyMap[0][0][0]) continue;

                // 도착지가 들어갈 수 없는 칸일때 continue(해도 시간 차이 별로 없음)
                // if(!copyMap[N-1][N-1][N-1]) continue;

                // 목적지에 갈 수 없으면 continue
                int result = BFS(copyMap);
                if(result == -1) continue;

                // ans 갱신
                ans = Math.min(ans, result);
            }
        }

        // 목적지에 도달한 적이 있으면 최단거리 출력하고 없으면 -1 출력
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // 일반적인 최단 거리 BFS로 원본 맵의 복사본에 대한 BFS라서 복사복 자체를 바꾸면서 방문 체크
    private static int BFS(boolean[][][] map){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        // 방문 가능하면 true, 방문 불가능하면 false로 설정
        map[0][0][0] = false;

        // 최단 거리
        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int[] item = q.poll();

                // 목적지에 도달하면 최단 거리 반환하고 종료
                if(item[0]==N-1 && item[1]==N-1 && item[2]==N-1){
                    return dist;
                }

                // 6방 탐색
                for(int dir=0 ; dir<6 ; dir++){
                    int nh = item[0]+ dh[dir];
                    int nr = item[1]+ dr[dir];
                    int nc = item[2]+ dc[dir];

                    if(nh>=0 && nh<N && nr>=0 && nr<N && nc>=0 && nc<N && map[nh][nr][nc]){
                        q.offer(new int[]{nh, nr, nc});
                        map[nh][nr][nc] = false;
                    }
                }
            }

            dist++;
        }

        return -1;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // 입력 받은 순서와 회전 배열로 복사본을 반환
    private static boolean[][][] setting(boolean[][][] map, int[] order, int[] rotation){
        boolean[][][] copy = new boolean[N][N][N];

        // 순서 설정
        // clone은 내부 객체는 얕은 복사라서 한번 더 복사를 해줘야 함(안하면 바로 틀림)
        // -> 2차원 배열의 참조값은 달라도 내부 1차원 배열의 참조값은 같음
        for(int h=0 ; h<N ; h++){
            copy[h] = map[order[h]].clone();
            for(int i=0 ; i<N ; i++){
                copy[h][i] = map[order[h]][i].clone();
            }
        }

        // 회전 설정
        for(int i=0 ; i<N ; i++){
            copy[i] = rotateMap(copy[i], rotation[i]);
        }

        return copy;
    }

    // 2차원 배열을 n번 회전시켜서 반환하는 메서드
    // 0 -> 0도
    // 1 -> 90도
    // 2 -> 180도
    // 3 -> 270도
    private static boolean[][] rotateMap(boolean[][] copy, int n){
        // 0이면 바로 리턴
        if(n == 0) return copy;

        // 0이 아니면 90도 회전시킨 애랑 n-1을 재귀로 리턴
        return rotateMap(rotateMap90(copy), n-1);
    }

    // 반시계 방향 90도 회전시킨 결과를 리턴하는 메서드
    private static boolean[][] rotateMap90(boolean[][] copy){
        boolean[][] result = new boolean[N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                result[i][j] = copy[N-j-1][i];
            }
        }

        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    static List<int[]> perm_0_4 = new ArrayList<>();
    static List<int[]> perm_0_3 = new ArrayList<>();
    static int[] sel;
    static boolean[] visited;

    // 순열로 뽑은 모든 경우의 수를 perm_0_4에 저장
    // 순열은 방문 체크 필요하고 perm_0_4에 넣을 때 참조값을 바꿔서 넣어야 함
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

    // 중복 순열로 뽑은 모든 경우의 수를 perm_0_3에 저장
    // 중복 순열은 방문 체크 필요없고 perm_0_3에 넣을 때 참조값을 바꿔서 넣어야 함
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////

}
