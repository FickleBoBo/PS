package day_17.BOJ_15644;

import java.io.*;
import java.util.*;

public class Main {

    private static final char[] order = {'U', 'D', 'L', 'R'};

    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(Point p) {
            this.r = p.r;
            this.c = p.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Point red = null;
        Point blue = null;
        Point exit = null;

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') red = new Point(i, j);
                else if (map[i][j] == 'B') blue = new Point(i, j);
                else if (map[i][j] == 'O') exit = new Point(i, j);
            }
        }

        String ans = bfs(red, blue, exit, N, M, map);

        bw.write(ans);
        bw.flush();
    }

    private static String bfs(Point startRed, Point startBlue, Point exit, int N, int M, char[][] map) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(startRed);
        q.offer(startBlue);

        Queue<StringBuilder> pathQ = new ArrayDeque<>();
        pathQ.offer(new StringBuilder());

        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[startRed.r][startRed.c][startBlue.r][startBlue.c] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len / 2; i++) {
                Point red = q.poll();
                Point blue = q.poll();
                StringBuilder path = pathQ.poll();

                if (isSamePosition(red, exit) && !isSamePosition(blue, exit)) {
                    return new StringBuilder().append(dist).append("\n").append(path).toString();
                }

                for (int dir = 0; dir < 4; dir++) {
                    Point[] points = move(order[dir], map, new Point(red), new Point(blue));
                    int redNr = points[0].r;
                    int redNc = points[0].c;
                    int blueNr = points[1].r;
                    int blueNc = points[1].c;

                    if (visited[redNr][redNc][blueNr][blueNc]) continue;

                    q.offer(new Point(redNr, redNc));
                    q.offer(new Point(blueNr, blueNc));
                    visited[redNr][redNc][blueNr][blueNc] = true;
                    pathQ.offer(new StringBuilder(path).append(order[dir]));
                }
            }

            dist++;
            if (dist > 10) return "-1";
        }

        return "-1";
    }

    private static boolean isSamePosition(Point p1, Point p2) {
        return p1.r == p2.r && p1.c == p2.c;
    }

    // 두 구슬의 위치관계를 기반으로 order에 대한 이동을 수행하고 최종 위치를 반환하는 메서드
    private static Point[] move(char order, char[][] map, Point red, Point blue) {
        if (order == 'U') {
            if (red.c == blue.c) {
                if (red.r < blue.r) {
                    while (map[red.r - 1][red.c] != '#' && map[red.r][red.c] != 'O') {
                        red.r--;
                    }
                    while (map[blue.r - 1][blue.c] != '#' && map[blue.r][blue.c] != 'O' && (map[red.r][red.c] == 'O' || blue.r - 1 != red.r)) {
                        blue.r--;
                    }
                } else {
                    while (map[blue.r - 1][blue.c] != '#' && map[blue.r][blue.c] != 'O') {
                        blue.r--;
                    }
                    while (map[red.r - 1][red.c] != '#' && map[red.r][red.c] != 'O' && (map[blue.r][blue.c] == 'O' || red.r - 1 != blue.r)) {
                        red.r--;
                    }
                }
            } else {
                while (map[red.r - 1][red.c] != '#' && map[red.r][red.c] != 'O') {
                    red.r--;
                }
                while (map[blue.r - 1][blue.c] != '#' && map[blue.r][blue.c] != 'O') {
                    blue.r--;
                }
            }
        } else if (order == 'D') {
            if (red.c == blue.c) {
                if (red.r > blue.r) {
                    while (map[red.r + 1][red.c] != '#' && map[red.r][red.c] != 'O') {
                        red.r++;
                    }
                    while (map[blue.r + 1][blue.c] != '#' && map[blue.r][blue.c] != 'O' && (map[red.r][red.c] == 'O' || blue.r + 1 != red.r)) {
                        blue.r++;
                    }
                } else {
                    while (map[blue.r + 1][blue.c] != '#' && map[blue.r][blue.c] != 'O') {
                        blue.r++;
                    }
                    while (map[red.r + 1][red.c] != '#' && map[red.r][red.c] != 'O' && (map[blue.r][blue.c] == 'O' || red.r + 1 != blue.r)) {
                        red.r++;
                    }
                }
            } else {
                while (map[red.r + 1][red.c] != '#' && map[red.r][red.c] != 'O') {
                    red.r++;
                }
                while (map[blue.r + 1][blue.c] != '#' && map[blue.r][blue.c] != 'O') {
                    blue.r++;
                }
            }
        } else if (order == 'L') {
            if (red.r == blue.r) {
                if (red.c < blue.c) {
                    while (map[red.r][red.c - 1] != '#' && map[red.r][red.c] != 'O') {
                        red.c--;
                    }
                    while (map[blue.r][blue.c - 1] != '#' && map[blue.r][blue.c] != 'O' && (map[red.r][red.c] == 'O' || blue.c - 1 != red.c)) {
                        blue.c--;
                    }
                } else {
                    while (map[blue.r][blue.c - 1] != '#' && map[blue.r][blue.c] != 'O') {
                        blue.c--;
                    }
                    while (map[red.r][red.c - 1] != '#' && map[red.r][red.c] != 'O' && (map[blue.r][blue.c] == 'O' || red.c - 1 != blue.c)) {
                        red.c--;
                    }
                }
            } else {
                while (map[red.r][red.c - 1] != '#' && map[red.r][red.c] != 'O') {
                    red.c--;
                }
                while (map[blue.r][blue.c - 1] != '#' && map[blue.r][blue.c] != 'O') {
                    blue.c--;
                }
            }
        } else if (order == 'R') {
            if (red.r == blue.r) {
                if (red.c > blue.c) {
                    while (map[red.r][red.c + 1] != '#' && map[red.r][red.c] != 'O') {
                        red.c++;
                    }
                    while (map[blue.r][blue.c + 1] != '#' && map[blue.r][blue.c] != 'O' && (map[red.r][red.c] == 'O' || blue.c + 1 != red.c)) {
                        blue.c++;
                    }
                } else {
                    while (map[blue.r][blue.c + 1] != '#' && map[blue.r][blue.c] != 'O') {
                        blue.c++;
                    }
                    while (map[red.r][red.c + 1] != '#' && map[red.r][red.c] != 'O' && (map[blue.r][blue.c] == 'O' || red.c + 1 != blue.c)) {
                        red.c++;
                    }
                }
            } else {
                while (map[red.r][red.c + 1] != '#' && map[red.r][red.c] != 'O') {
                    red.c++;
                }
                while (map[blue.r][blue.c + 1] != '#' && map[blue.r][blue.c] != 'O') {
                    blue.c++;
                }
            }
        }

        return new Point[]{red, blue};
    }

}
