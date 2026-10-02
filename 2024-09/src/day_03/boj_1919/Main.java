package day_03.BOJ_B2_1919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[] cntArr = new int[26];

        // 앞에선 더하고
        for(int n : str1){
            cntArr[n - 'a']++;
        }

        // 뒤에선 빼고
        for(int n : str2){
            cntArr[n - 'a']--;
        }

        int ans = 0;
        for(int n : cntArr){
            ans += Math.abs(n);    // 카운팅 배열에서 0이 아니면 그 절댓값만큼 없애줘야 함
        }

        System.out.println(ans);
    }
}
