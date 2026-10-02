package day_14.BOJ_B2_2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int Amin = Integer.parseInt(A.replaceAll("6", "5"));
        int Amax = Integer.parseInt(A.replaceAll("5", "6"));
        int Bmin = Integer.parseInt(B.replaceAll("6", "5"));
        int Bmax = Integer.parseInt(B.replaceAll("5", "6"));

        System.out.println((Amin + Bmin) + " " + (Amax + Bmax));
    }
}
