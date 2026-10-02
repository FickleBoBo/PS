package day_14.BOJ_1431;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put((char) (i + '0'), i);
        }

        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());

            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < o1.length(); i++) {
                sumA += map.getOrDefault(o1.charAt(i), 0);
                sumB += map.getOrDefault(o2.charAt(i), 0);
            }

            if (sumA != sumB) return Integer.compare(sumA, sumB);

            return o1.compareTo(o2);
        });

        for (String str : list) {
            sb.append(str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
