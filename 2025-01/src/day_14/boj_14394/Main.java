package day_14.BOJ_14394;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : input1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : input2) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        int cnt = 0;
        for (char c : map.keySet()) {
            cnt += Math.abs(map.get(c));
        }

        System.out.println(cnt / 2);
    }
}
