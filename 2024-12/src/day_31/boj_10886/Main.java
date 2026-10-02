package day_31.BOJ_10886;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int flag = 0;
        for (int i = 0; i < N; i++) {
            int vote = Integer.parseInt(br.readLine());

            if (vote == 1) flag++;
            else flag--;
        }

        if (flag > 0) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}
