package day_02.BOJ_2217;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 로프가 들어올릴 수 있는 최대 중량 기준으로 정렬
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {

            // 해당 로프보다 튼튼한 로프의 개수를 세서 최대 중량 계산
            ans = Math.max(ans, arr[i] * (N - i));
        }

        System.out.println(ans);
    }
}
