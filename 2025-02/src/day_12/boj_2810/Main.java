package day_12.BOJ_2810;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), "S", true);
        int ans = 0;
        int cnt = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("S")) ans++;
            else cnt += token.length() / 2;
        }

        if (cnt != 0) cnt++;

        System.out.println(ans + cnt);
    }
}
