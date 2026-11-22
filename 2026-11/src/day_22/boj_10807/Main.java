package day_22.boj_10807;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            if (x == v) cnt++;
        }

        System.out.println(cnt);
    }
}
