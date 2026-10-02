package day_02.BOJ_11723;

import java.io.*;
import java.util.*;

public class Main_Bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int set = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "add":
                    int X = Integer.parseInt(st.nextToken());
                    set |= (1 << X);
                    break;

                case "remove":
                    X = Integer.parseInt(st.nextToken());
                    set &= ~(1 << X);
                    break;

                case "check":
                    X = Integer.parseInt(st.nextToken());
                    sb.append(((set & (1 << X)) > 0) ? 1 : 0).append("\n");
                    break;

                case "toggle":
                    X = Integer.parseInt(st.nextToken());
                    if ((set & (1 << X)) > 0) set &= ~(1 << X);
                    else set |= (1 << X);
                    break;

                case "all":
                    for (int n = 1; n <= 20; n++) {
                        set |= (1 << n);
                    }
                    break;

                case "empty":
                    set = 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
