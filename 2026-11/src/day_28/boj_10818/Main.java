package day_28.boj_10818;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int min = 1_000_000;
        int max = -1_000_000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        System.out.println(min + " " + max);
    }
}
