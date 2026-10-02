package day_24.BOJ_19583;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> entry = new HashSet<>();
        Set<String> exit = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            String time = st.nextToken();
            String name = st.nextToken();

            if (before(time, S)) {
                entry.add(name);
            } else if (after(time, E) && before(time, Q)) {
                exit.add(name);
            }
        }

        entry.retainAll(exit);

        System.out.println(entry.size());
    }

    private static boolean before(String time, String criterion) {
        return time.compareTo(criterion) <= 0;
    }

    private static boolean after(String time, String criterion) {
        return time.compareTo(criterion) >= 0;
    }

}
