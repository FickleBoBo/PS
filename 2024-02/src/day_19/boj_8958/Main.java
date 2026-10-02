package day_19.BOJ_B2_8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                               // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){                       // tc : 각각의 테스트 케이스
            String[] result = sc.next().split("");    // result : OX 값을 배열로 받음
            int[] prefixSum = new int[result.length+1];     // prefixSum : 누적합 배열 생성(패딩O)
            int ans = 0;                                    // ans : 점수의 총합

            for(int i=0 ; i< result.length ; i++){
                if(result[i].equals("O")){                // O를 만나면
                    prefixSum[i+1] = prefixSum[i] + 1;    // 누적합 갱신
                    ans += prefixSum[i+1];                // 점수의 총합 갱신
                }
            }
            System.out.println(ans);
        }
    sc.close();
    }
}
