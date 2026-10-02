package day_07.BOJ_1924;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < M; i++) {
            D += arr[i];
        }
        D %= 7;

        if (D == 0) System.out.println("SUN");
        else if (D == 1) System.out.println("MON");
        else if (D == 2) System.out.println("TUE");
        else if (D == 3) System.out.println("WED");
        else if (D == 4) System.out.println("THU");
        else if (D == 5) System.out.println("FRI");
        else System.out.println("SAT");
    }
}
