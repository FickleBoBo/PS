package day_01.BOJ_1427;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] N = br.readLine().toCharArray();
        Arrays.sort(N);

        for (int i = N.length - 1; i >= 0; i--) {
            sb.append(N[i]);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
