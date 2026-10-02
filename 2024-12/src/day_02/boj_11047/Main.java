package day_02.BOJ_11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] divArr = new int[N];

        // 향상된 for문을 사용하려고 역순으로 저장
        for (int i = N - 1; i >= 0; i--) {
            divArr[i] = Integer.parseInt(br.readLine());
        }

        // 동전 개수 세고 잔액 갱신
        for (int div : divArr) {
            ans += K / div;
            K %= div;
        }

        System.out.println(ans);
    }
}
