package day_07.BOJ_30676;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N >= 620) System.out.println("Red");
        else if (N >= 590) System.out.println("Orange");
        else if (N >= 570) System.out.println("Yellow");
        else if (N >= 495) System.out.println("Green");
        else if (N >= 450) System.out.println("Blue");
        else if (N >= 425) System.out.println("Indigo");
        else if (N >= 380) System.out.println("Violet");
    }
}
