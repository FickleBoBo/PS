package day_31.SWEA_D4_1210;

import java.util.Scanner;

public class Solution {

    static int[][] table = new int[100][1+100+1];    // 좌우 패딩을 줘서 Index 예외처리 해결
    static int xpos;                                 // xpos : 현재 x 좌표 위치
    static int ypos;                                 // ypos : 현재 y 좌표 위치

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){

            int N = sc.nextInt();                  // N : 더미 하나 받는 역할
            for(int r=0 ; r<100 ; r++){
                for(int c=1 ; c<=100 ; c++){
                    table[r][c] = sc.nextInt();    // 열심히 테이블 채우기
                }
            }

            xpos = 99;                             // static 변수 초기화
            for(int idx=1 ; idx<=100 ; idx++){     // static 변수 초기화
                if(table[99][idx] == 2){
                    ypos = idx;
                    break;                         // 시작점 찾으면 break하면 됨(아래에서부터 위로 찾아나갈 예정)
                }
            }

            while(xpos > 0){
                if(table[xpos][ypos-1]==0 && table[xpos][ypos+1]==0){
                    goStraight();                        // 좌우가 모두 0이면 위로 직진
                }
                if(table[xpos][ypos-1]==1){
                    goLeft();                            // 왼쪽으로 갈 수 있으면 가기
                    xpos -= 1;                           // 한 칸 올라가야 다시 오른쪽으로 가는거 방지
                } else if(table[xpos][ypos+1]==1){
                    goRight();                           // 오른쪽으로 갈 수 있으면 가기
                    xpos -= 1;                           // 한 칸 올라가야 다시 왼쪽으로 가는거 방지
                }
            }
            System.out.printf("#%d %d\n", N, ypos-1);    // 패딩 고려해서 1 빼주기
        }
        sc.close();
    }

    public static void goStraight(){
        xpos -= 1;           // 조건문에서 고려했으므로 한 칸 이동
        while(table[xpos][ypos-1]==0 && table[xpos][ypos+1]==0){
            if(xpos > 0){    // 올라가다 도착하면 멈추는 역할
                xpos -= 1;
            } else{
                break;
            }
        }
    }

    public static void goLeft(){
        ypos -= 1;    // 조건문에서 고려했으므로 한 칸 이동
        while(table[xpos][ypos-1]==1){
            ypos -= 1;
        }
    }

    public static void goRight(){
        ypos += 1;    // 조건문에서 고려했으므로 한 칸 이동
        while(table[xpos][ypos+1]==1){
            ypos += 1;
        }
    }

}