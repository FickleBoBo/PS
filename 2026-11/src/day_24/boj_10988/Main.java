package day_24.boj_10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String rs = new StringBuilder(s).reverse().toString();

        if (s.equals(rs)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
