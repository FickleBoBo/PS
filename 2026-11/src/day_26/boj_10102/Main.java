package day_26.boj_10102;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;
        br.readLine();
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
            } else {
                b++;
            }
        }

        if (a > b) {
            System.out.println("A");
        } else if (a < b) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}
