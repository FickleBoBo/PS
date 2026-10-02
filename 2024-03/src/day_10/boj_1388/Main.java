package day_10.BOJ_S4_1388;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // step1 - 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] floor = new char[N][M];
        int cnt = 0;

        for(int i=0 ; i<N ; i++){
            floor[i] = sc.next().toCharArray();
        }

        // step2 - 행우선순회로 '-' 장식 개수 세기
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if((j<M) && (floor[i][j] == '-')){    // while문 때문에 j == M 가능
                    cnt++;
                    while((j<M) && (floor[i][j] == '-')){    // 인덱스 범위 넘지 않게 조건
                        j++;
                    }
                }
            }
        }

        // step3 - 열우선순회로 '|' 장식 개수 세기
        for(int j=0 ; j<M ; j++){
            for(int i=0 ; i<N ; i++){
                if((i<N) && (floor[i][j] == '|')){
                    cnt++;
                    while((i<N) && (floor[i][j] == '|')){
                        i++;
                    }
                }
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}
