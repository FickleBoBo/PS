package day_21.boj_1267;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySum = 0;
        int mSum = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            ySum += (x / 30 + 1) * 10;
            mSum += (x / 60 + 1) * 15;
        }

        if (ySum < mSum) {
            System.out.println("Y " + ySum);
        } else if (ySum > mSum) {
            System.out.println("M " + mSum);
        } else {
            System.out.println("Y M " + ySum);
        }
    }
}
