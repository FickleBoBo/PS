package day_01.BOJ_G4_1958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner를 이용한 풀이
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.next().toCharArray();
        char[] arr2 = sc.next().toCharArray();
        char[] arr3 = sc.next().toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;

        int[][][] dp = new int[1+len1][1+len2][1+len3];

        for(int i=1 ; i<=len1 ; i++){
            for(int j=1 ; j<=len2 ; j++){
                for(int k=1 ; k<=len3 ; k++){

                    // 새로 추가되는 문자가 서로 동일하면 길이 + 1
                    if(arr1[i-1] == arr2[j-1] && arr2[j-1] == arr3[k-1]){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    // 새로 추가되는 문자가 서로 다르면 지금까지 구한 길이
                    else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[len1][len2][len3]);
    }
}
