package day_26.boj_3003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {1, 1, 2, 2, 2, 8};
        for (int x : arr) {
            int cnt = Integer.parseInt(st.nextToken());
            System.out.print((x - cnt) + " ");
        }
    }
}
