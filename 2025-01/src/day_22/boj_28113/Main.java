package day_22.BOJ_28113;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A < Math.max(N, B)) System.out.println("Bus");
        else if (A > Math.max(N, B)) System.out.println("Subway");
        else System.out.println("Anything");
    }
}
