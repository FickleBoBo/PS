package day_14.BOJ_B2_1919;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] words1 = sc.next().toCharArray();
        char[] words2 = sc.next().toCharArray();

        int[] cntArr1 = new int[26];
        int[] cntArr2 = new int[26];

        for(int i=0 ; i<words1.length ; i++) {
            cntArr1[words1[i]-'a']++;
        }
        for(int i=0 ; i<words2.length ; i++) {
            cntArr2[words2[i]-'a']++;
        }
        int cnt = 0;
        for(int i=0 ; i<26 ; i++) {
            cnt += Math.abs(cntArr1[i]-cntArr2[i]);
        }
        System.out.println(cnt);
    }
}
