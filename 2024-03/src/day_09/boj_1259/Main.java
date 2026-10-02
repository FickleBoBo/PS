package day_09.BOJ_B1_1259;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();    // 일단 하나 입력 받고 시작

        while(s != 0){    // 종료 조건
            char[] input = (s+"").toCharArray();    // int -> String -> char[]
            boolean flag = true;    // 팰린드롬수가 아니면 false로 바꾸기
            for(int i=0 ; i<input.length/2 ; i++){    // 반만 확인해도 됨
                if(input[i] != input[input.length-1-i]){
                    flag = false;
                }
            }

            if(flag) System.out.println("yes");
            else System.out.println("no");
            s = sc.nextInt();    // 입력 갱신
        }

        sc.close();
    }
}
