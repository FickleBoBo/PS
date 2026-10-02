package day_24.BOJ_G4_14499;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    // 델타배열(dir 바로 넣으려고 패딩) : 패딩 + 우(1) + 좌(2) + 상(3) + 하(4)
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int K = sc.nextInt();    // 명령 개수인데 토크나이저로 받을거라 쓸 데 없음

        // map : 지도 정보 받아줌
        int[][] map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();    // 버퍼 안 먹어주면 토크나이저가 개행문자(\n)를 받는 듯?

        // 토크나이저로 이동 명령 받아주고 while문 돌릴 예정
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        // 주사위 초기 정보
        // deque로 할라다가 너무 복잡해서 포기
        int front = 0;
        int back = 0;
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;


        // 명령이 남아있는 동안 반복
        while(st.hasMoreTokens()){

            // dir : 방향 정보 토큰을 받아서 형변환
            int dir = Integer.parseInt(st.nextToken());

            // 이동 불가일때 continue로 명령 무시
            if(((dir==1) && (y==M-1)) ||
                    ((dir==2) && (y==0)) ||
                    ((dir==3) && (x==0)) ||
                    ((dir==4) && (x==N-1))) continue;

            // 델타용 좌표 계산
            int nx = x + dr[dir];
            int ny = y + dc[dir];
            int newPos = map[nx][ny];

            // 오른쪽으로 갈 경우
            if(dir==1) {
                int tmp = back;             // 임시변수에 back 정보 받아줌(3개를 스왑하는 개념)
                if(newPos==0){              // 다음 칸의 바닥면이 0이면
                    map[nx][ny] = right;    // 기존 주사위의 오른쪽면이 바닥으로 갈테니 덮어줌
                    back = right;           // 이거 찾는데 개오래 걸렸는데 새로운 바닥면에 기존의 오른쪽 숫자를 넣어줘야 함(right 대신 0 넣어서 테케 4가 계속 틀림)
                }
                else{
                    back = newPos;          // 다음 칸의 바닥면이 0이 아니면
                    map[nx][ny] = 0;        // 0으로 바꿔줌
                }
                right = front;
                front = left;
                left = tmp;

                y++;    // 계산 끝나면 좌표 갱신
            }
            // 왼쪽으로 갈 경우
            else if(dir==2){
                int tmp = back;
                if(newPos==0){
                    map[nx][ny] = left;
                    back = left;
                }
                else{
                    back = newPos;
                    map[nx][ny] = 0;
                }
                left = front;
                front = right;
                right = tmp;

                y--;    // 계산 끝나면 좌표 갱신
            }
            // 위로 갈 경우
            else if(dir==3){
                int tmp = back;
                if(newPos==0){
                    map[nx][ny] = up;
                    back = up;
                }
                else{
                    back = newPos;
                    map[nx][ny] = 0;
                }
                up = front;
                front = down;
                down = tmp;

                x--;    // 계산 끝나면 좌표 갱신
            }
            // 아래로 갈 경우
            else if(dir==4){
                int tmp = back;
                if(newPos==0){
                    map[nx][ny] = down;
                    back = down;
                }
                else{
                    back = newPos;
                    map[nx][ny] = 0;
                }
                down = front;
                front = up;
                up = tmp;

                x++;    // 계산 끝나면 좌표 갱신
            }

            System.out.println(front);    // 주사위 윗면 출력

//            맞게 했나 출력 확인용
//            System.out.printf("X: %d Y: %d\n", x, y);
//            System.out.printf("front: %d back: %d up: %d down: %d left: %d right: %d\n", front, back, up, down, left, right);
//            System.out.println();
//
//            for(int i=0 ; i<N ; i++){
//                for(int j=0 ; j<M ; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        sc.close();
    }
}
