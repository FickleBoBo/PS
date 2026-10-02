package day_07.BOJ_10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String reverse = new StringBuilder(input).reverse().toString();

        if (input.equals(reverse)) System.out.println(1);
        else System.out.println(0);
    }
}
