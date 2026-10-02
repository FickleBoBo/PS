package day_18.BOJ_S3_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

        int sum = 0;

        // 처음 - 기호가 등장하기 전까지의 연산 처리
        while(st2.hasMoreTokens()){
            sum += Integer.parseInt(st2.nextToken());
        }

        // - 기호를 기준으로 토큰으로 나눴고 각 토큰의 합을 sum에서 빼주는게 최소
        while(st.hasMoreTokens()){
            st2 = new StringTokenizer(st.nextToken(), "+");

            int tmp = 0;

            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }

            sum -= tmp;
        }

        System.out.println(sum);
    }
}
