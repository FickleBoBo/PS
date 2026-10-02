package day_06.BOJ_3003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= Integer.parseInt(st.nextToken());
        }

        for (int n : arr) {
            sb.append(n).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
