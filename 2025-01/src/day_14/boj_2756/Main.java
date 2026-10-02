package day_14.BOJ_2756;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            double[][] player1 = new double[3][2];
            for (int i = 0; i < 3; i++) {
                player1[i][0] = Double.parseDouble(st.nextToken());
                player1[i][1] = Double.parseDouble(st.nextToken());
            }

            double[][] player2 = new double[3][2];
            for (int i = 0; i < 3; i++) {
                player2[i][0] = Double.parseDouble(st.nextToken());
                player2[i][1] = Double.parseDouble(st.nextToken());
            }

            int point1 = 0;
            int point2 = 0;
            for (int i = 0; i < 3; i++) {
                point1 += getPoint(player1[i][0], player1[i][1]);
                point2 += getPoint(player2[i][0], player2[i][1]);
            }

            if (point1 > point2) {
                sb.append("SCORE: ").append(point1).append(" to ").append(point2).append(", PLAYER 1 WINS.\n");
            } else if (point1 < point2) {
                sb.append("SCORE: ").append(point1).append(" to ").append(point2).append(", PLAYER 2 WINS.\n");
            } else {
                sb.append("SCORE: ").append(point1).append(" to ").append(point2).append(", TIE.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getPoint(double x, double y) {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        if (distance > 15) return 0;
        else if (distance > 12) return 20;
        else if (distance > 9) return 40;
        else if (distance > 6) return 60;
        else if (distance > 3) return 80;
        else return 100;
    }

}
