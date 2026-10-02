package day_09.BOJ_B2_2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] countingArr = new int[10];    // 각 자릿수 카운팅 배열

        char[] arr = ((A * B * C)+"").toCharArray();    // 세 숫자의 곱을 char[]로 받음
        for(char c : arr){
            countingArr[Character.getNumericValue(c)]++;    // char int 에서 필수 메서드(getNumericValue)
        }

        for(int i=0 ; i<10 ; i++){
            System.out.println(countingArr[i]);
        }

        sc.close();
    }
}
