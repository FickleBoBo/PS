package day_14.BOJ_17413;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), "<>", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("<")) {
                sb.append(token).append(st.nextToken()).append(st.nextToken());
                continue;
            }

            StringTokenizer st2 = new StringTokenizer(token, " ", true);
            while (st2.hasMoreTokens()) {
                sb.append(new StringBuilder(st2.nextToken()).reverse());
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
