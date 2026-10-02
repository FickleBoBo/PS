package day_09.BOJ_B3_2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 최댓값과 인덱스 초기 설정
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;

        // 돌면서 찾기
        for(int i=0 ; i<9 ; i++){
            int n = sc.nextInt();
            if(n > max){
                max = n;
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx+1);

        sc.close();
    }
}
