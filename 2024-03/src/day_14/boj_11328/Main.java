package day_14.BOJ_B2_11328;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++) {
            char[] input = sc.next().toCharArray();
            char[] ans = sc.next().toCharArray();

            if(input.length != ans.length) {
                System.out.println("Impossible");
                continue;
            }

            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            for(int i=0 ; i<input.length ; i++) {
                arr1[input[i]-'a']++;
                arr2[ans[i]-'a']++;
            }
            boolean flag = true;
            for(int i=0 ; i<26 ; i++) {
                if(arr1[i] != arr2[i]) {
                    flag = false;
                }
            }
            if(flag) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }
        }

    }
}
