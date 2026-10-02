package day_12.BOJ_9627;

import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] input = new String[N];
        int len = -1;
        int pos = -1;

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
            len += input[i].length();
            if (input[i].equals("$")) pos = i;
        }

        for (int i = 1; i < 1000; i++) {
            if (len + len(i) == i) {
                input[pos] = getStr(i);
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(input[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String getStr(int num) {
        if (map.containsKey(num)) return map.get(num);

        StringBuilder sb = new StringBuilder();

        if (num >= 100) sb.append(map.get(num / 100)).append("hundred");

        if (num % 100 / 10 * 10 >= 20) sb.append(map.get(num % 100 / 10 * 10)).append(map.get(num % 10));
        else sb.append(map.get(num % 100));

        return sb.toString();
    }

    private static int len(int num) {
        return getStr(num).length();
    }

}
