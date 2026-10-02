package day_14.BOJ_11098;

import java.io.*;
import java.util.*;

public class Main {

    private static class Player implements Comparable<Player> {
        int value;
        String name;

        public Player(int value, String name) {
            this.value = value;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return Integer.compare(o.value, this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Player[] players = new Player[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                players[i] = new Player(value, name);
            }
            Arrays.sort(players);

            bw.write(players[0].name);
            bw.newLine();
        }

        bw.flush();
    }
}
