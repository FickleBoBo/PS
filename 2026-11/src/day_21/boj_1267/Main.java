package day_21.boj_1267;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ys = 0;
        int ms = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            ys += (x / 30 + 1) * 10;
            ms += (x / 60 + 1) * 15;
        }

        if (ys < ms) {
            System.out.println("Y " + ys);
        } else if (ys > ms) {
            System.out.println("M " + ms);
        } else {
            System.out.println("Y M " + ys);
        }
    }
}
