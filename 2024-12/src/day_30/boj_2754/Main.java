package day_30.BOJ_2754;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        double avg = 0;

        if (input[0] == 'A') avg += 4;
        else if (input[0] == 'B') avg += 3;
        else if (input[0] == 'C') avg += 2;
        else if (input[0] == 'D') avg += 1;

        if (input[input.length - 1] == '+') avg += 0.3;
        else if (input[input.length - 1] == '-') avg -= 0.3;

        System.out.println(avg);
    }
}
