package day_16.BOJ_B2_3052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] cntArr = new int[42];    // 42로 나눈 나머지를 인덱스에 맞춰 저장할 카운팅 배열
        int ans = 0;

        for(int i=0 ; i<10 ; i++){
            cntArr[sc.nextInt()%42]++;    // 바로 입력 받아서 슛
        }
        for(int i=0 ; i<42 ; i++){
            if(cntArr[i] != 0){    // 배열이 차있다와 같은 말
                ans++;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
