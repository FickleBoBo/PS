package day_14.BOJ_1252;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken(), 2);
        BigInteger B = new BigInteger(st.nextToken(), 2);

        System.out.println(A.add(B).toString(2));
    }
}
