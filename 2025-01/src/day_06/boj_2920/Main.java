package day_06.BOJ_2920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        boolean isAscending = true;
        boolean isDescending = true;

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());

            if (num > next) isAscending = false;
            else if (num < next) isDescending = false;

            num = next;
        }

        if (!isAscending && !isDescending) System.out.println("mixed");
        else if (isAscending) System.out.println("ascending");
        else System.out.println("descending");
    }
}
