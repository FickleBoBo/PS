package day_27.boj_7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        for (String name : set) {
            bw.write(name);
            bw.newLine();
        }

        bw.flush();
    }
}
