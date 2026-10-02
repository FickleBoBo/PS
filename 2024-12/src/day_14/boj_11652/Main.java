package day_14.BOJ_11652;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        long ans = 0;
        int maxCnt = 0;

        for (Map.Entry<Long, Integer> entry : cntMap.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCnt) {
                ans = key;
                maxCnt = value;
            } else if (value == maxCnt) {
                ans = Math.min(ans, key);
            }
        }

        System.out.println(ans);
    }
}
