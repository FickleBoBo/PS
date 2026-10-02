package day_30.BOJ_G2_17822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
    	
    	// step1 - 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int T = Integer.parseInt(input[2]);
        map = new int[1+N+1][M];
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N+T ; i++){
            sb.append(br.readLine()+" ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // step2 - 쭉 돌리기
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int n=1 ; n<=N ; n++){
                if(n%num==0){
                    rotateMap(n, d, k);    // 회전을 먼저 처리해주고
                }
            }
            boolean deleted = deleteNum();    // 삭제하는데 삭제됐는지 여부를 리턴
            if(!deleted){
                reAdjust();    // 삭제 안됐으면 재조정
            }
        }

        // step3 - 남은 숫자 더하기
        int sum = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<M ; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);

        br.close();
    }

    private static void rotateMap(int n, int d, int k){
        if(d==0){    // 시계 방향 회전
            while(k>0){
                int num = map[n][M-1];
                for(int i=M-1 ; i>=1 ; i--){
                    map[n][i] = map[n][i-1];
                }
                map[n][0] = num;
                k--;
            }
        }
        else{    // 반시계 방향 회전
            while(k>0){
                int num = map[n][0];
                for(int i=0 ; i<M-1 ; i++){
                    map[n][i] = map[n][i+1];
                }
                map[n][M-1] = num;
                k--;
            }
        }

//        System.out.println("회전 시킨 후");
//        for(int i=0 ; i< map.length ; i++){
//            for(int j=0 ; j<map[i].length ; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    }

    private static boolean deleteNum(){
        boolean deleted = false;
        boolean flag = false;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] != 0){
                    for(int dir=0 ; dir<4 ; dir++){
                        int nr = i + dr[dir];
                        int nc = (M + j + dc[dir]) % M;
                        if(map[nr][nc] == map[i][j]){
                            flag = true;
                        }
                    }
                    if(flag){
                        BFS(i, j);
                        deleted = true;
                        flag = false;
                    }
                }
            }
        }

//        System.out.println("삭제 시킨 후");
//        for(int i=0 ; i< map.length ; i++){
//            for(int j=0 ; j<map[i].length ; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        return deleted;
    }

    private static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        int value = map[r][c];
        map[r][c] = 0;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = (M + item[1] + dc[dir]) % M;
                if(map[nr][nc] == value){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = 0;
                }
            }
        }
    }

    private static void reAdjust() {
        int sum = 0;
        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<M ; j++){
                if (map[i][j] != 0) {
                    sum += map[i][j];
                    cnt++;
                }
            }
        }
        double avg = (double) sum /cnt;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<M ; j++){
                if (map[i][j] != 0) {
                    if(map[i][j] > avg){
                        map[i][j]--;
                    }
                    else if(map[i][j] < avg){
                        map[i][j]++;
                    }
                }
            }
        }

//        System.out.println("조정 시킨 후");
//        System.out.println(sum);
//        System.out.println(cnt);
//        for(int i=0 ; i< map.length ; i++){
//            for(int j=0 ; j<map[i].length ; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    }

}
