package day_01.BOJ_G5_9251;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {

        // BufferedReader를 이용한 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[1+len1][1+len2];

        for(int i=1 ; i<=len1 ; i++){
            for(int j=1 ; j<=len2 ; j++){

                // 새로 추가되는 문자가 서로 동일하면 길이 + 1
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 새로 추가되는 문자가 서로 다르면 지금까지 구한 길이
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
    }
}
