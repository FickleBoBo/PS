package day_09.BOJ_2295;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        for (int x = 0; x < N; x++) {
            for (int y = x; y < N; y++) {
                set.add(arr[x] + arr[y]);
            }
        }

        for (int k = N - 1; k >= 0; k--) {
            for (int z = 0; z < N; z++) {
                if (set.contains(arr[k] - arr[z])) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}
