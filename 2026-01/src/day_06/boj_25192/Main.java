package day_06.boj_25192;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int cnt = 0;

        while (n-- > 0) {
            String line = br.readLine();

            if (line.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(line);
            }
        }
        cnt += set.size();

        System.out.println(cnt);
    }
}
