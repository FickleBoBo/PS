package day_20.BOJ_G4_1846;

import java.io.*;

// 조건을 만족하는 배치를 딱 하나만 찾으면 되니까 재귀 완탐 없이 가능
// 게임판을 위쪽과 아래쪽으로 나눠서 대각선만 잘 피하면 됨
// 잘 풀면 N이 짝수인지 홀수인지 상관없이 하나의 식으로 풀이가능(정수 나눗셈의 소수점 버림 활용)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 배치가 불가능한 경우는 N = 3 일때 하나만 있음
        if(N == 3){
            sb.append("-1");
        }
        else{
            // 자주 사용되는 값이라 변수로 빼둠
            int turningPoint = (N+1)/2;

            // 위쪽 배치
            for(int i=2 ; i<=turningPoint ; i++){
                sb.append(i).append("\n");
            }
            sb.append("1\n");

            // 아래쪽 배치
            for(int i=turningPoint+2 ; i<=N ; i++){
                sb.append(i).append("\n");
            }
            sb.append(turningPoint+1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
