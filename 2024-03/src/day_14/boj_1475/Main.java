package day_14.BOJ_S5_1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        int[] countingArr = new int[10];

        for(char c : input){
            countingArr[c-'0']++;
        }
        countingArr[6] += countingArr[9];
        countingArr[6] = (countingArr[6] + 1) / 2;

        int max = 0;
        for(int i=0 ; i<9 ; i++){
            max = max > countingArr[i] ? max : countingArr[i];
        }

        System.out.println(max);

        sc.close();
    }
}
