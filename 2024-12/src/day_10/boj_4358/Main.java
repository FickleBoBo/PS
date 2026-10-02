package day_10.BOJ_4358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        Map<String, Integer> map = new TreeMap<>();
        int cnt = 0;

        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            sb.append(key).append(" ").append(round(value, cnt, 4)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String round(double value, int cnt, int places) {
        return String.format("%.4f", Math.round(value / cnt * Math.pow(10, places + 2)) / Math.pow(10, places));
    }

}
