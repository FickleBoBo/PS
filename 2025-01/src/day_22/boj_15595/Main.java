package day_22.BOJ_15595;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            int result = Integer.parseInt(st.nextToken());

            if (result == 4) {
                set.add(id);
            } else {
                if (set.contains(id)) continue;
                map.put(id, map.getOrDefault(id, 0) + 1);
            }
        }
        set.remove("megalusion");

        int sum = set.size();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!set.contains(entry.getKey())) continue;

            sum += entry.getValue();
        }

        if ((sum) == 0) System.out.println(0);
        else System.out.println((double) set.size() / sum * 100);
    }
}
