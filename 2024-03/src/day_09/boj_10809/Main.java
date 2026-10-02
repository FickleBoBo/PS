package day_09.BOJ_B2_10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] countingArr = new int[26];    // 알파벳 카운팅 배열
        Arrays.fill(countingArr, -1);    // -1로 채우기

        char[] S = sc.next().toCharArray();    // 입력을 char[]로 받음
        for(int i=0 ; i<S.length ; i++){
            if(countingArr[(int) (S[i]-'a')] == -1){    // 채울 곳이 -1이면(=채운 적이 없으면)
                countingArr[(int) (S[i]-'a')] = i;    // 인덱스 넣기
            }
        }

        for(int i=0 ; i<26 ; i++){
            System.out.print(countingArr[i] + " ");
        }

        sc.close();
    }
}
