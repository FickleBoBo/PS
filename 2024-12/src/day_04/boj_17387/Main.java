package day_04.BOJ_17387;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        if (cross(x1, y1, x2, y2, x3, y3, x4, y4) && cross(x3, y3, x4, y4, x1, y1, x2, y2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean cross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int vector123 = ccw(x1, y1, x2, y2, x3, y3);
        int vector124 = ccw(x1, y1, x2, y2, x4, y4);

        // 두 선분의 기울기가 일치
        if (vector123 == 0 && vector124 == 0) {
            // 기울기가 무한대면 y 좌표로 비교
            if (x1 == x2) {
                return overlap(y1, y2, y3, y4);
            }
            return overlap(x1, x2, x3, x4);
        }
        // 세 점(1, 2, 3)이 일직선 상에 위치
        else if (vector123 == 0) {
            return isEndPoint(x1, y1, x2, y2, x3, y3);
        }
        // 세 점(1, 2, 4)이 일직선 상에 위치
        else if (vector124 == 0) {
            return isEndPoint(x1, y1, x2, y2, x4, y4);
        }

        return vector123 * vector124 < 0;
    }

    // 점 (x3, y3)가 선분 ((x1, y1), (x2, y2))에 포함되는지 boolean으로 반환
    private static boolean isEndPoint(int x1, int y1, int x2, int y2, int x3, int y3) {
        int newX1 = Math.min(x1, x2);
        int newX2 = Math.max(x1, x2);
        int newY1 = Math.min(y1, y2);
        int newY2 = Math.max(y1, y2);

        return newX1 <= x3 && x3 <= newX2 && newY1 <= y3 && y3 <= newY2;
    }

    // 두 선분이 겹치는 부분이 있는지 boolean으로 반환
    private static boolean overlap(int pos1, int pos2, int pos3, int pos4) {
        int newPos1 = Math.min(pos1, pos2);
        int newPos2 = Math.max(pos1, pos2);
        int newPos3 = Math.min(pos3, pos4);
        int newPos4 = Math.max(pos3, pos4);

        if (newPos1 < newPos4) {
            return newPos2 >= newPos3;
        } else {
            return newPos1 <= newPos4;
        }
    }

    // CCW 알고리즘
    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long vector = (x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3);
        return vector == 0 ? 0 : (int) (vector / Math.abs(vector));
    }

}
