package day_22.boj_3273;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int l = 0, r = n - 1;
        int cnt = 0;
        while (l < r) {
            if (arr[l] + arr[r] < x) {
                l++;
            } else if (arr[l] + arr[r] > x) {
                r--;
            } else {
                cnt++;
                l++;
                r--;
            }
        }

        System.out.println(cnt);
    }
}
