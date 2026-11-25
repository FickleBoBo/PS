package day_24.boj_2884;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m >= 45) {
            System.out.println(h + " " + (m - 45));
        } else {
            if (h > 0) {
                System.out.println((h - 1) + " " + (m + 15));
            } else {
                System.out.println("23 " + (m + 15));
            }
        }
    }
}
