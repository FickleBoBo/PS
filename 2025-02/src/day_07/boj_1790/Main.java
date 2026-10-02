package day_07.BOJ_1790;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int num = 0;  // 현재 수
        int len = 1;  // 현재 수의 길이
        int flag = 10;  // 현재 수가 10의 거듭제곱인지 판단하는 flag 변수

        while (K - len >= 0) {
            K -= len;
            num++;

            if (num == flag) {
                len++;
                flag *= 10;
            }
        }

        // 현재 수가 N보다 크면 불가능한 상황
        if (num > N) System.out.println(-1);
        else System.out.println(String.valueOf(num).charAt(K));
    }
}
