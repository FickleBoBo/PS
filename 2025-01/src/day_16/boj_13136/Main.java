package day_16.BOJ_13136;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        System.out.println(((R + N - 1) / N) * ((C + N - 1) / N));
    }
}
