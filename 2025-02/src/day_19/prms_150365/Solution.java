package day_19.PRMS_150365;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 최단거리가 k보다 길거나 k가 거리경로 + 2의 배수가 아니면 불가능한 케이스
        if ((Math.abs(r - x) + Math.abs(c - y)) % 2 != k % 2 || Math.abs(r - x) + Math.abs(c - y) > k) return "impossible";

        StringBuilder sb = new StringBuilder();

        // 잉여거리
        int remain = k - Math.abs(r - x) - Math.abs(c - y);

        // 상하 반복 횟수
        int udCnt = 0;

        // 좌우 반복 횟수
        int lrCnt = 0;

        if (x < r) {
            // 최단 경로에 포함
            for (int i = x; i < r; i++) {
                sb.append("d");
            }

            // 잉여 경로에 포함
            int dx = r;
            while (dx < n && remain > 0) {
                udCnt++;
                dx++;
                remain -= 2;
            }
            for (int i = 0; i < udCnt; i++) {
                sb.append("d");
            }

            if (y > c) {
                // 최단 경로에 포함
                for (int i = c; i < y; i++) {
                    sb.append("l");
                }

                // 잉여 경로에 포함
                int dy = c;
                while (dy > 1 && remain > 0) {
                    lrCnt++;
                    dy--;
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("l");
                }
                while (remain > 0) {
                    sb.append("rl");
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("r");
                }
            } else {
                // 잉여 경로에 포함
                int dy = y;
                while (dy > 1 && remain > 0) {
                    lrCnt++;
                    dy--;
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("l");
                }
                while (remain > 0) {
                    sb.append("rl");
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("r");
                }

                // 최단 경로에 포함
                for (int i = y; i < c; i++) {
                    sb.append("r");
                }
            }

            // 잉여 경로에 포함
            for (int i = 0; i < udCnt; i++) {
                sb.append("u");
            }
        } else {
            // 잉여 경로에 포함
            int dx = x;
            while (dx < n && remain > 0) {
                udCnt++;
                dx++;
                remain -= 2;
            }
            for (int i = 0; i < udCnt; i++) {
                sb.append("d");
            }

            if (y > c) {
                // 최단 경로에 포함
                for (int i = c; i < y; i++) {
                    sb.append("l");
                }

                // 잉여 경로에 포함
                int dy = c;
                while (dy > 1 && remain > 0) {
                    lrCnt++;
                    dy--;
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("l");
                }
                while (remain > 0) {
                    sb.append("rl");
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("r");
                }
            } else {
                // 잉여 경로에 포함
                int dy = y;
                while (dy > 1 && remain > 0) {
                    lrCnt++;
                    dy--;
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("l");
                }
                while (remain > 0) {
                    sb.append("rl");
                    remain -= 2;
                }
                for (int i = 0; i < lrCnt; i++) {
                    sb.append("r");
                }

                // 최단 경로에 포함
                for (int i = y; i < c; i++) {
                    sb.append("r");
                }
            }

            // 잉여 경로에 포함
            for (int i = 0; i < udCnt; i++) {
                sb.append("u");
            }

            // 최단 경로에 포함
            for (int i = r; i < x; i++) {
                sb.append("u");
            }
        }

        return sb.toString();
    }
}
