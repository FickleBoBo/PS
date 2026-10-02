package day_23.BOJ_G4_14499_Fail;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    // 패딩 + 우(1) + 좌(2) + 상(3) + 하(4)
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        int front = 0;
        int back = 0;

        while(st.hasMoreTokens()){

            int dir = Integer.parseInt(st.nextToken());

            if(((dir==1) && (y==M-1)) ||
                    ((dir==2) && (y==0)) ||
                    ((dir==3) && (x==0)) ||
                    ((dir==4) && (x==N-1))) continue;


            int nx = x + dr[dir];
            int ny = y + dc[dir];
            int newPos = map[nx][ny];

            // 오른쪽으로 갈 경우
            if(dir==1){
                int tmp = right;
                right = front;
                front = left;
                left = back;
                back = newPos;

                y++;
            }
            // 왼쪽으로 갈 경우
            else if(dir==2){
                int tmp = left;
                left = front;
                front = right;
                right = back;
                back = newPos;

                y--;
            }
            // 위로 갈 경우
            else if(dir==3){
                int tmp = up;
                up = front;
                front = down;
                down = back;
                back = newPos;

                x--;
            }
            // 아래로 갈 경우
            else if(dir==4){
                int tmp = down;
                down = front;
                front = up;
                up = back;
                back = newPos;

                x++;
            }

            if(map[nx][ny]==0){
                map[nx][ny] = back;
            }
            else{
                back = map[nx][ny];
                map[nx][ny] = 0;
            }



            System.out.println(front);

//            System.out.printf("x: %d y: %d\n", x, y);
//            System.out.printf("%d %d %d %d %d %d\n", front, back, up, down, left, right);
//            for(int i=0 ; i<N ; i++){
//                for(int j=0 ; j<M ; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

        }
        sc.close();
    }
}
