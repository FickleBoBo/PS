package day_04.BOJ_5619;

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

        int ans = find(Math.min(N, 4), arr);
        System.out.println(ans);
    }

    private static int find(int len, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                pq.add(Integer.parseInt(new StringBuilder().append(arr[i]).append(arr[j]).toString()));
                pq.add(Integer.parseInt(new StringBuilder().append(arr[j]).append(arr[i]).toString()));
            }
        }

        pq.remove();
        pq.remove();
        return pq.remove();
    }

}
