package day_05.BOJ_2457;

import java.io.*;
import java.util.*;

public class Main {

    private static class Day {
        int start;
        int end;

        public Day(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Day> days = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.start, o2.start));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            // 지는 날이 3월 이전이거나 피는 날이 12월이면 필요 없는 꽃
            if (m2 < 3 || m1 == 12) continue;

            days.add(new Day(m1 * 100 + d1, m2 * 100 + d2));
        }

        int cnt = 0;
        int end = 301;

        while (!days.isEmpty()) {
            // 임시 우선순위 큐
            PriorityQueue<Day> tmp = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.end, o1.end));
            while (!days.isEmpty() && days.peek().start <= end) {
                tmp.add(days.remove());
            }

            // 임시 우선순위 큐가 비는 상황은 연속되게 피도록 선택할 수 없는 경우
            if (tmp.isEmpty()) break;

            end = tmp.remove().end;
            cnt++;

            if (end >= 1201) break;
        }

        if (end >= 1201) System.out.println(cnt);
        else System.out.println(0);
    }
}
