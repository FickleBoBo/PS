package day_16.BOJ_B1_2999;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] code = sc.next().split("");    // 입력 받아서 String 배열로 일단 저장
        int N = code.length;
        int C = (int) Math.sqrt(N);    // 제곱근으로 초기화해서 시간 단축 노려봄
        int R = 0;

        // 암호를 푸는 것이므로 C >= R임을 주의
        while(C > 0){
            if(N % C == 0){
                R = N / C;
                break;
            }
            C--;
        }

        String[][] msg = new String[R][C];    // 암호 메시지를 담을 2차원 배열
        int idx = 0;
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                msg[i][j] = code[idx++];    // 행렬로 일단 옮겨줌
            }
        }

        for(int i=0 ; i<C ; i++){
            for(int j=0 ; j<R ; j++){
                System.out.print(msg[j][i]);    // 조건 맞춰서 출력
            }
        }
        sc.close();
    }
}
