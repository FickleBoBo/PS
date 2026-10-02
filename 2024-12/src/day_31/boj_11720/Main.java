package day_31.BOJ_11720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Character.getNumericValue(input.charAt(i));
        }

        System.out.println(sum);
    }
}
