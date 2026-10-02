package day_05.BOJ_9996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), "*");
        String prefix = st.nextToken();
        String suffix = st.nextToken();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() < prefix.length() + suffix.length()) {
                bw.write("NE\n");
            } else if (input.startsWith(prefix) && input.endsWith(suffix)) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}
