package day_05.BOJ_10158;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int x = (p + t) % (w * 2) < w ? (p + t) % w : w * 2 - (p + t) % (w * 2);
        int y = (q + t) % (h * 2) < h ? (q + t) % h : h * 2 - (q + t) % (h * 2);

        sb.append(x).append(" ").append(y);

        bw.write(sb.toString());
        bw.flush();
    }
}
