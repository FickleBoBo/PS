package day_28.SWEA_D3_1873;

import java.util.Scanner;

public class Solution {

    // 반환형 void인 메서드로 다룰거라 static 변수로 해주는게 편해보였음
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int row;
    static int col;
    static int dir;
    static String[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){

            // step1 - 맵 입력 받기
            int H = sc.nextInt();
            int W = sc.nextInt();
            map = new String[H][W];
            for(int i=0 ; i<H ; i++){
                map[i] = sc.next().split("");
            }

            // step2 - 전차의 데이터를 입력받기(전차의 위치에는 평지를 넣고 static으로 받은 전차 데이터만으로 다룰 예정
            out:
            for(int i=0 ; i<H ; i++){
                for(int j=0 ; j<W ; j++){
                    if(map[i][j].equals("^")){
                        row = i;
                        col = j;
                        dir = 1;
                        map[i][j] = ".";
                        break out;
                    }
                    else if(map[i][j].equals(">")){
                        row = i;
                        col = j;
                        dir = 2;
                        map[i][j] = ".";
                        break out;
                    }
                    else if(map[i][j].equals("v")){
                        row = i;
                        col = j;
                        dir = 3;
                        map[i][j] = ".";
                        break out;
                    }
                    else if(map[i][j].equals("<")){
                        row = i;
                        col = j;
                        dir = 4;
                        map[i][j] = ".";
                        break out;
                    }
                }
            }

            // step3 - 커맨드 입력 받음
            int n= sc.nextInt();
            char[] inputArr = sc.next().toCharArray();
            for(int i=0 ; i<n ; i++){
                action(inputArr[i]);
            }

            // step4 - 출력 단계(전차 데이터를 맵에 다시 넣어줌)
            if(dir == 1){
                map[row][col] = "^";
            }
            else if(dir == 2){
                map[row][col] = ">";
            }
            else if(dir == 3){
                map[row][col] = "v";
            }
            else if(dir == 4){
                map[row][col] = "<";
            }

            System.out.print("#" + tc + " ");
            for(int i=0 ; i<H ; i++){
                for(int j=0 ; j<W ; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }
        sc.close();
    }

    // 입력받은 커맨드를 수행하는 메서드
    private static void action(char input) {
        int H = map.length;
        int W = map[0].length;

        if(input=='U'){
            dir = 1;
            int nrow = row + dr[dir];
            int ncol = col + dc[dir];

            if((nrow>=0) && (ncol>=0) && (nrow<H) && (ncol<W) &&
                    (map[nrow][ncol].equals("."))){
                row = nrow;
                col = ncol;
            }
        }
        else if(input=='D'){
            dir = 3;
            int nrow = row + dr[dir];
            int ncol = col + dc[dir];

            if((nrow>=0) && (ncol>=0) && (nrow<H) && (ncol<W) &&
                    (map[nrow][ncol].equals("."))){
                row = nrow;
                col = ncol;
            }
        }
        else if(input=='L'){
            dir = 4;
            int nrow = row + dr[dir];
            int ncol = col + dc[dir];

            if((nrow>=0) && (ncol>=0) && (nrow<H) && (ncol<W) &&
                    (map[nrow][ncol].equals("."))){
                row = nrow;
                col = ncol;
            }
        }
        else if(input=='R'){
            dir = 2;
            int nrow = row + dr[dir];
            int ncol = col + dc[dir];

            if((nrow>=0) && (ncol>=0) && (nrow<H) && (ncol<W) &&
                    (map[nrow][ncol].equals("."))){
                row = nrow;
                col = ncol;
            }
        }
        // Shoot이 까다로움
        else if(input=='S'){
            int rowShootDir = row + dr[dir];
            int colShootDir = col + dc[dir];

            // 벽을 만나거나 밖으로 나갈때까지 임시 좌표 갱신
            while((rowShootDir>=0) && (colShootDir>=0) &&
                    (rowShootDir<H) && (colShootDir<W) &&
                    (!(map[rowShootDir][colShootDir].equals("*"))) &&
                    (!(map[rowShootDir][colShootDir].equals("#")))){
                rowShootDir += dr[dir];
                colShootDir += dc[dir];
            }

            // 해당 임시좌표가 돌벽이면 부셔서 땅으로 만듦(밖으로 나갈때랑 철벽일때는 안바꿀거라 고려할 필요 없음)
            if((rowShootDir>=0) && (colShootDir>=0) &&
                    (rowShootDir<H) && (colShootDir<W) &&
                    (map[rowShootDir][colShootDir].equals("*"))){
                map[rowShootDir][colShootDir] = ".";
            }

        }
    }

}
