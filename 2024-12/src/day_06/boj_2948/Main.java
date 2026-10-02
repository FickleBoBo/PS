package day_06.BOJ_2948;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < M; i++) {
            D += arr[i];
        }
        D %= 7;

        if (D == 0) System.out.println("Wednesday");
        else if (D == 1) System.out.println("Thursday");
        else if (D == 2) System.out.println("Friday");
        else if (D == 3) System.out.println("Saturday");
        else if (D == 4) System.out.println("Sunday");
        else if (D == 5) System.out.println("Monday");
        else System.out.println("Tuesday");
    }
}
