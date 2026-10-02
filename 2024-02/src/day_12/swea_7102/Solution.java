package day_12.SWEA_D3_7102;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();               // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){       // tc : 각각의 테스트 케이스
            int N = sc.nextInt();           // N : 첫번째 카드 세트
            int M = sc.nextInt();           // M : 두번째 카드 세트
            int[] arr = new int[1+N+M];     // arr : counting 배열
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=M ; j++){
                    arr[i+j] += 1;          // 여기가 포인트
                }
            }

            int max = Integer.MIN_VALUE;    // max : 카운팅 배열에서 최댓값(최빈수) 찾기
            for(int i=0 ; i<N+M+1 ; i++){
                if(arr[i] > max){
                    max = arr[i];
                }
            }

            System.out.printf("#%d ", tc);
            for(int i=0 ; i<N+M+1 ; i++){
                if(arr[i] == max){    // 같은 빈도수까지 출력 가능
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
