package day_01.BOJ_G4_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;                 // map : 집
    static int R;                       // R : 행(세로 길이)
    static int C;                       // C : 열(가로 길이)
    static int T;                       // T : 주어진 시간
    static int posUp;                   // posUp : 공기청정기의 위쪽 행 좌표(열은 0 고정)
    static int posDown;                 // posDown : 공기청정기의 아래쪽 행 좌표(열은 0 고정)
    static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌 델타배열
    static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌 델타배열

    public static void main(String[] args) throws IOException {

        /*
        step1 - R, C, T 입력 받기
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);
//        System.out.printf("R: %d, C: %d, T: %d\n", R, C, T);

        /*
        step2 - 집과 미세먼지 정보를 입력받으려고 StringBuilder 사용(시간 제한 1초라서 써봄)
        */
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<R ; i++){
            sb.append(br.readLine() + " ");    // 입력 받고 끝에 공백 안넣어주면 다음 줄이랑 붙어버림
        }
//        System.out.println(sb.toString());

        /*
        step3 - StringBuilder를 StringTokenizer로 쪼개서 2차원 배열로 저장
        */
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");
//        while(st.hasMoreTokens()){
//            System.out.print(st.nextToken() + " ");
//        }

        map = new int[R][C];
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        printMap();

        /*
        step4 - 공기청정기의 좌표를 받아줌
        */
        for(int i=0 ; i<R ; i++){
            if(map[i][0] == -1){
                posUp = i;
                posDown = i+1;
                break;
            }
        }
//        System.out.printf("공청기 위쪽: (%d, 0), 공청기 아래쪽: (%d, 0)\n", posUp, posDown);

        /*
        step5 - T초만큼 미세먼지를 퍼트리고(=spreadDust()) 공기청정기를 돌림(=runAirCleaner())
        */
        while(T > 0){
            spreadDust();
//            printMap();
//            System.out.println(countDust());
            runAirCleaner();
//            printMap();
            T--;
        }

        /*
        step6 - 출력
        */
        System.out.println(countDust());

        br.close();
    }

    /*
    맵을 출력해서 로직에 맞게 잘 작동하나 확인하려고 만든 임시 메서드
    먼지 퍼트리기와 공청기 돌려서 먼지 이동시키기에서 요긴함
    */
    static void printMap(){
        System.out.println("맵 출력");
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    먼지를 퍼트리고, 퍼트린 정보를 다시 원본 집에 저장하는 메서드
    1. 원본 집과 같은 크기의 임시 집을 만들어주고 공청기 위치에는 -1을 넣어준다
    2. 원본 집을 돌며 먼지를 만나면 사방탐색을 하며 퍼트릴 수 있는 공간의 수(집안 && 공청기X)를 센다
    3. 먼지를 퍼트린 후 데이터를 임시 집에 넣어준다(원본 집을 쭉 돌며 반복) -> 원본 집에 이거 하면 데이터가 바뀌어서 안될듯?
    4. 다 끝나면 원본 집에 임시 집의 데이터를 덮어 씌운다(임시 집 = 먼지 퍼트린 후 원본 집)
    */
    static void spreadDust(){
        int[][] afterMap = new int[R][C];
        afterMap[posUp][0] = -1;
        afterMap[posDown][0] = -1;

        int cnt = 0;
        for(int r=0 ; r<R ; r++){
            for(int c=0 ; c<C ; c++){
                if(map[r][c] > 0){    // 원본 집에서 먼지를 찾으면
                    for(int dir=0 ; dir<4 ; dir++){    // 사방 탐색
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        if((nr>=0) && (nc>=0) && (nr<R) && (nc<C) &&    // 먼지를 퍼트릴 수 있으면
                                (map[nr][nc] != -1)){
                            afterMap[nr][nc] += (map[r][c] / 5);    // 임시 집에 퍼트림
                            cnt++;
                        }
                    }
                    afterMap[r][c] += map[r][c] - (map[r][c] / 5 * cnt);    // 퍼트린 먼지만큼 뺀 값도 임시 집에 넣어줌
                    cnt = 0;
                }
            }
        }

        // 원본 집에 임시 집 데이터 넣어주기
        for(int i=0 ; i<R ; i++){
            map[i] = Arrays.copyOf(afterMap[i], C);
        }

    }

    /*
    공기청정기를 돌리고 난 후 상황으로 원본 집을 갱신하는 메서드
    1. 공청기 바로 앞 먼지는 빨아주고 이후 시계 or 반시계로 돌며 먼지를 이동시켜주면 됨
    2. 한 바퀴만 돌아서 달팽이 배열처럼 안하고 그냥 무식하게 함
    3. 한 바퀴 다 돌고 공청기에서 집으로 나가는 공기는 0으로 만들어줘야 하는데 이거를 놓쳐서 디버깅 좀 걸림
    */
    static void runAirCleaner(){
        int r;
        int c;
        int nr;
        int nc;

        // 공청기 위쪽 한 바퀴 휘 돌기
        r = posUp - 1;
        c = 0;
        nr = r - 1;
        nc = 0;
        map[r][c] = 0;
        while(nr >= 0){
//            System.out.printf("위로 가는 중 - r: %d, c: %d, nr: %d, nc: %d\n", r, c, nr, nc);
//            printMap();
            map[r][c] = map[nr][nc];
            nr -= 1;
            r -= 1;
            if(nr == -1){
                nr = 0;
                nc = 1;
                break;
            }
        }
        while(nc < C){
//            System.out.printf("오른쪽으로 가는 중 - r: %d, c: %d, nr: %d, nc: %d\n", r, c, nr, nc);
//            printMap();
            map[r][c] = map[nr][nc];
            nc += 1;
            c += 1;
            if(nc == C){
                nr = 1;
                nc = C-1;
                break;
            }
        }
        while(nr <= posUp){
            map[r][c] = map[nr][nc];
            nr += 1;
            r += 1;
            if(nr == posDown){
                nr = posUp;
                nc = C-2;
                break;
            }
        }
        while(nc > 0){
            map[r][c] = map[nr][nc];
            nc -= 1;
            c -= 1;
            if(nc == 0){
                break;
            }
        }
        map[r][c] = 0;



        // 공청기 아래쪽 한바퀴 휘 돌기
        r = posDown + 1;
        c = 0;
        nr = r + 1;
        nc = 0;
        map[r][c] = 0;
        while(nr < R){
            map[r][c] = map[nr][nc];
            nr += 1;
            r += 1;
            if(nr == R){
                nr = R-1;
                nc = 1;
                break;
            }
        }
        while(nc < C){
            map[r][c] = map[nr][nc];
            nc += 1;
            c += 1;
            if(nc == C){
                nr = R-2;
                nc = C-1;
                break;
            }
        }
        while(nr >= posDown){
            map[r][c] = map[nr][nc];
            nr -= 1;
            r -= 1;
            if(nr == posUp){
                nr = posDown;
                nc = C-2;
                break;
            }
        }
        while(nc > 0){
            map[r][c] = map[nr][nc];
            nc -= 1;
            c -= 1;
            if(nc == 0){
                break;
            }
        }
        map[r][c] = 0;

    }

    // 원본 집 돌며 먼지 수 세서 리턴하는 메서드
    static int countDust(){
        int ans = 0;
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                if(map[i][j] > 0){
                    ans += map[i][j];
                }
            }
        }
        return ans;
    }

}
