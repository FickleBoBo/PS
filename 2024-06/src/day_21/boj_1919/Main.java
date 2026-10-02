package day_21.BOJ_B2_1919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        // 문자열의 알파벳 개수를 저장하는 카운팅 배열
        int[] cntArr = new int[26];

        for(int i=0 ; i<str1.length() ; i++){
            cntArr[str1.charAt(i) - 'a']++;    // 앞에선 더하고
        }
        for(int i=0 ; i<str2.length() ; i++){
            cntArr[str2.charAt(i) - 'a']--;   // 뒤에선 빼고
        }

        int ans = 0;
        for(int i=0 ; i<26 ; i++){
            ans += Math.abs(cntArr[i]);    // 카운팅 배열에서 0이 아니면 그 절댓값만큼 없애줘야 함
        }

        System.out.println(ans);
    }
}
