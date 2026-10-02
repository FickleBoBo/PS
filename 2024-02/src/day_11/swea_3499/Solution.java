package day_11.SWEA_D3_3499;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());    // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){               // tc : 각 테스트 케이스

            int N = Integer.parseInt(sc.nextLine());                            // 뒤에 String 입력 받을거라 input 에러 없애기 위해 통일
            String[] input = sc.nextLine().split(" ");                   // input : 입력 값을 일단 String 배열로 받음
            String[] tmp1 = Arrays.copyOfRange(input, 0, (N+1)/2);    // tmp1 : 앞 부분에 해당하는 범위를 메서드로 불러와 저장
            String[] tmp2 = Arrays.copyOfRange(input, (N+1)/2, N);        // tmp2 : 뒷 부분에 해당하는 범위를 메서드로 불러와 저장

            System.out.printf("#%d ", tc);    // 각 테스트 케이스에 대한 출력 파트
            for(int i=0 ; i<N/2 ; i++){       // 일단 짝수개라 가정하고 출력
                System.out.print(tmp1[i] + " ");
                System.out.print(tmp2[i] + " ");
            }

            if(input.length % 2 == 1){    // 홀수개면 앞쪽 배열만 하나 더 출력
                System.out.println(tmp1[(N+1)/2-1]);
            }
            else{                         // 짝수개면 그냥 넘어감
                System.out.println();
            }
        }
        sc.close();
    }
}
