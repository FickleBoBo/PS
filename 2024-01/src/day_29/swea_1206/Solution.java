package day_29.SWEA_D3_1206;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){    // tc : 테스트 케이스 10개
            int N = sc.nextInt();         // N : 건물의 개수
            int[] arr = new int[N];       // arr[] : 건물의 높이를 담을 배열
            int ans = 0;                  // ans : 조망권이 확보된 세대의 수

            for(int i=0 ; i<N ; i++){
                arr[i] = sc.nextInt();    // 일단 건물의 높이를 배열에 담는다
            }

            // 해당 건물과 좌우 총 4개의 건물에 대해 해당 건물이 가장 높을 때, 2번째로 높은 건물과의 높이차가 조망권이 확보된 세대의 수
            for(int idx=2 ; idx<N-2 ; idx++){
                if((arr[idx] <= arr[idx-2]) || (arr[idx] <= arr[idx-1]) || (arr[idx] <= arr[idx+1]) || (arr[idx] <= arr[idx+2])){
                    continue;
                } else {
                    int max = Integer.MIN_VALUE;
                    max = max>arr[idx-2] ? max : arr[idx-2];
                    max = max>arr[idx-1] ? max : arr[idx-1];
                    max = max>arr[idx+1] ? max : arr[idx+1];
                    max = max>arr[idx+2] ? max : arr[idx+2];
                    ans += arr[idx]-max;
                }
            }

            System.out.printf("#%d %d\n", tc, ans);

        }
    }
}
