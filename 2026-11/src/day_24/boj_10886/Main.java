package day_24.boj_10886;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                cnt++;
            } else {
                cnt--;
            }
        }

        if (cnt > 0) {
            System.out.println("Junhee is not cute!");
        } else {
            System.out.println("Junhee is cute!");
        }
    }
}
