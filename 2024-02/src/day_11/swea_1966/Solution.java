package day_11.SWEA_D2_1966;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                // T : 테스트 케이스의 수

        for (int tc = 1; tc <= T; tc++) {    // tc : 각 테스트 케이스
            int N = sc.nextInt();            // N : 정렬할 배열의 길이
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);                // 배열을 정렬해주는 메소드 사용해봄
            System.out.printf("#%d ", tc);
            for(int i=0 ; i<N ; i++){
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}
