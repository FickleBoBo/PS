package day_09.BOJ_B2_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;                  // cnt : 공백으로 이루어진 문자열의 개수
        while(st.hasMoreTokens()){    // 토큰이 남아있는 동안
            st.nextToken();           // 토큰 하나 소모
            cnt++;                    // 개수 하나 더하기
        }
        System.out.println(cnt);
        br.close();
    }
}
