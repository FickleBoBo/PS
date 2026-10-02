package day_04.BOJ_20149;

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

            double[] pos = intersectionPoint(x1, y1, x2, y2, x3, y3, x4, y4);
            if (pos != null) {
                System.out.printf("%.10f %.10f", pos[0], pos[1]);
            }
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

    // 두 선분의 교점 반환
    private static double[] intersectionPoint(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        // 선분이 교차하지 않으면 null 반환
        if ((ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) > 0) ||
                (ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) > 0)) {
            return null;
        }

        long newX1 = Math.min(x1, x2);
        long newX2 = Math.max(x1, x2);
        long newY1 = Math.min(y1, y2);
        long newY2 = Math.max(y1, y2);
        long newX3 = Math.min(x3, x4);
        long newX4 = Math.max(x3, x4);
        long newY3 = Math.min(y3, y4);
        long newY4 = Math.max(y3, y4);

        // 두 직선 모두 y축과 평행한 경우
        if (x1 == x2 && x3 == x4) {
            if (newY2 == newY3) {
                return new double[]{x1, newY2};
            } else if (newY1 == newY4) {
                return new double[]{x1, newY1};
            }
            return null;
        }
        // 한 직선이 y축과 평행한 경우
        else if (x1 == x2) {
            double m = (double) (y4 - y3) / (x4 - x3);
            return new double[]{x1, (m) * (x1 - x3) + (y3)};
        }
        // 한 직선이 y축과 평행한 경우
        else if (x3 == x4) {
            double m = (double) (y2 - y1) / (x2 - x1);
            return new double[]{x3, (m) * (x3 - x1) + (y1)};
        }
        // 두 직선이 모두 기울기를 가진 경우
        else {
            // 두 직선의 기울기가 같은 경우
            if ((y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1)) {
                double m = (double) (y2 - y1) / (x2 - x1);

                if (m >= 0) {
                    if (newX2 == newX3 && newY2 == newY3) {
                        return new double[]{newX2, newY2};
                    } else if (newX1 == newX4 && newY1 == newY4) {
                        return new double[]{newX1, newY1};
                    }
                } else {
                    if (newX2 == newX3 && newY1 == newY4) {
                        return new double[]{newX2, newY1};
                    } else if (newX1 == newX4 && newY2 == newY3) {
                        return new double[]{newX1, newY2};
                    }
                }
                return null;
            }

            double m1 = (double) (y2 - y1) / (x2 - x1);
            double m2 = (double) (y4 - y3) / (x4 - x3);
            double x = (m2 * x3 - m1 * x1 + y1 - y3) / (m2 - m1);
            double y = (m1 * m2 * x3 - m1 * m2 * x1 + m2 * y1 - m1 * y3) / (m2 - m1);

            return new double[]{x, y};
        }
    }

}
