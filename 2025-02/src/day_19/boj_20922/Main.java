package day_19.BOJ_20922;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int len = 0;
        int[] cntArr = new int[1 + MAX];

        while (right < N) {
            int cnt = cntArr[arr[right]];

            if (cnt < K) {
                cntArr[arr[right]]++;
                right++;
                len = Math.max(len, right - left);
            } else {
                cntArr[arr[left]]--;
                left++;
            }
        }

        System.out.println(len);
    }
}
