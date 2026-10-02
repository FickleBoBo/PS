package day_09.BOJ_11536;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 0; i < N - 1; i++) {
            if (names[i].compareTo(names[i + 1]) > 0) isIncreasing = false;
            else if (names[i].compareTo(names[i + 1]) < 0) isDecreasing = false;
        }

        if (!isIncreasing && !isDecreasing) System.out.println("NEITHER");
        else if (isIncreasing) System.out.println("INCREASING");
        else System.out.println("DECREASING");
    }
}
