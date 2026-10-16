package day_11.boj_18937;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nimsum = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            nimsum ^= x - 2;
        }
        boolean whiteFirst = br.readLine().equals("Whiteking");

        if (nimsum != 0) {
            if (whiteFirst) {
                System.out.println("Whiteking");
            } else {
                System.out.println("Blackking");
            }
        } else {
            if (whiteFirst) {
                System.out.println("Blackking");
            } else {
                System.out.println("Whiteking");
            }
        }
    }
}
