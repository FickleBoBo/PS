package day_21.BOJ_S5_1475;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        // 숫자가 몇 번 쓰였는지 저장하는 카운팅 배열(인덱스 번호 == 사용한 숫자)
        int[] cntArr = new int[10];
        for(int i=0 ; i<N.length() ; i++){
            cntArr[N.charAt(i) - '0']++;
        }

        // 6이 사용된 개수를 일단 9로 옮겨준다
        cntArr[9] += cntArr[6];
        cntArr[6] = 0;

        // 0 ~ 8 중 가장 많이 사용된 숫자의 개수를 max에 저장
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<9 ; i++){
            if(cntArr[i] > max){
                max = cntArr[i];
            }
        }

        // 0 ~ 8 중 가장 많이 사용된 숫자의 개수와 9의 사용 개수 / 2 중 더 많은게 정답
        // 9의 사용 개수 / 2는 +1을 해주고 나눠야 하는데 홀수일때 반올림을 해줘야 하기 때문이다
        // 1116669999 -> 4가 나와야 함
        System.out.println(Math.max(max, ((cntArr[9] + 1) / 2)));
    }
}
