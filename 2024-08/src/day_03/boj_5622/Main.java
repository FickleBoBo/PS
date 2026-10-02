package day_03.BOJ_B2_5622;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳에 해당하는 정답을 미리 저장
        char[] ansArr = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

        char[] input = br.readLine().toCharArray();
        int ans = 0;

        for(char c : input){
            ans += ansArr[c - 'A'];
        }

        System.out.println(ans);
    }
}
