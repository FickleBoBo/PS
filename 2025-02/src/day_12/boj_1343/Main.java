package day_12.BOJ_1343;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);

        boolean flag = true;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int len = token.length();

            if (token.equals(".")) {
                sb.append(token);
                continue;
            }

            if (len % 2 == 1) {
                flag = false;
                break;
            }

            for (int i = 0; i < len / 4; i++) {
                sb.append("AAAA");
            }

            for (int i = 0; i < len % 4; i++) {
                sb.append("B");
            }
        }

        if (flag) {
            bw.write(sb.toString());
            bw.flush();
        } else {
            System.out.println(-1);
        }
    }
}
