package day_06.BOJ_14910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        boolean flag = true;

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (next < num) {
                flag = false;
                break;
            }
            num = next;
        }

        if (flag) System.out.println("Good");
        else System.out.println("Bad");
    }
}
