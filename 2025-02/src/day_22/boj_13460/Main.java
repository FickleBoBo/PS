package day_22.BOJ_13460;

import java.io.*;
import java.util.*;

// 1시간

public class Main {

    private static class Node {
        int redR;
        int redC;
        int blueR;
        int blueC;
        char order = '\u0000';
        boolean redStatus = false;
        boolean blueStatus = false;

        public Node() {
        }

        public Node(int redR, int redC, int blueR, int blueC, char order, boolean redStatus, boolean blueStatus) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.order = order;
            this.redStatus = redStatus;
            this.blueStatus = blueStatus;
        }
    }

    private static char[] command = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node input = new Node();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    input.redR = i;
                    input.redC = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    input.blueR = i;
                    input.blueC = j;
                    map[i][j] = '.';
                }
            }
        }

        int ans = bfs(input, N, M, map);
        System.out.println(ans);
    }

    private static Node move(Node node, char order, int N, int M, char[][] map) {
        int redR = node.redR;
        int redC = node.redC;
        int blueR = node.blueR;
        int blueC = node.blueC;
        boolean redIsEscape = false;
        boolean blueIsEscape = false;

        if (order == 'U') {
            if (redC != blueC) {
                while (map[redR - 1][redC] != '#') {
                    redR--;
                    if (map[redR][redC] == 'O') {
                        redIsEscape = true;
                        redR = -1;
                        redC = -1;
                        break;
                    }
                }
                while (map[blueR - 1][blueC] != '#') {
                    blueR--;
                    if (map[blueR][blueC] == 'O') {
                        blueIsEscape = true;
                        blueR = -1;
                        blueC = -1;
                        break;
                    }
                }
            } else {
                if (redR < blueR) {
                    while (map[redR - 1][redC] != '#') {
                        redR--;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                    while (map[blueR - 1][blueC] != '#' && blueR - 1 != redR) {
                        blueR--;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                } else {
                    while (map[blueR - 1][blueC] != '#') {
                        blueR--;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                    while (map[redR - 1][redC] != '#' && redR - 1 != blueR) {
                        redR--;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                }
            }

            return new Node(redR, redC, blueR, blueC, order, redIsEscape, blueIsEscape);
        }
        if (order == 'D') {
            if (redC != blueC) {
                while (map[redR + 1][redC] != '#') {
                    redR++;
                    if (map[redR][redC] == 'O') {
                        redIsEscape = true;
                        redR = -1;
                        redC = -1;
                        break;
                    }
                }
                while (map[blueR + 1][blueC] != '#') {
                    blueR++;
                    if (map[blueR][blueC] == 'O') {
                        blueIsEscape = true;
                        blueR = -1;
                        blueC = -1;
                        break;
                    }
                }
            } else {
                if (redR > blueR) {
                    while (map[redR + 1][redC] != '#') {
                        redR++;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                    while (map[blueR + 1][blueC] != '#' && blueR + 1 != redR) {
                        blueR++;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                } else {
                    while (map[blueR + 1][blueC] != '#') {
                        blueR++;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                    while (map[redR + 1][redC] != '#' && redR + 1 != blueR) {
                        redR++;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                }
            }

            return new Node(redR, redC, blueR, blueC, order, redIsEscape, blueIsEscape);
        }
        if (order == 'L') {
            if (redR != blueR) {
                while (map[redR][redC - 1] != '#') {
                    redC--;
                    if (map[redR][redC] == 'O') {
                        redIsEscape = true;
                        redR = -1;
                        redC = -1;
                        break;
                    }
                }
                while (map[blueR][blueC - 1] != '#') {
                    blueC--;
                    if (map[blueR][blueC] == 'O') {
                        blueIsEscape = true;
                        blueR = -1;
                        blueC = -1;
                        break;
                    }
                }
            } else {
                if (redC < blueC) {
                    while (map[redR][redC - 1] != '#') {
                        redC--;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                    while (map[blueR][blueC - 1] != '#' && blueC - 1 != redC) {
                        blueC--;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                } else {
                    while (map[blueR][blueC - 1] != '#') {
                        blueC--;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                    while (map[redR][redC - 1] != '#' && redC - 1 != blueC) {
                        redC--;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                }
            }

            return new Node(redR, redC, blueR, blueC, order, redIsEscape, blueIsEscape);
        }
        if (order == 'R') {
            if (redR != blueR) {
                while (map[redR][redC + 1] != '#') {
                    redC++;
                    if (map[redR][redC] == 'O') {
                        redIsEscape = true;
                        redR = -1;
                        redC = -1;
                        break;
                    }
                }
                while (map[blueR][blueC + 1] != '#') {
                    blueC++;
                    if (map[blueR][blueC] == 'O') {
                        blueIsEscape = true;
                        blueR = -1;
                        blueC = -1;
                        break;
                    }
                }
            } else {
                if (redC > blueC) {
                    while (map[redR][redC + 1] != '#') {
                        redC++;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                    while (map[blueR][blueC + 1] != '#' && blueC + 1 != redC) {
                        blueC++;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                } else {
                    while (map[blueR][blueC + 1] != '#') {
                        blueC++;
                        if (map[blueR][blueC] == 'O') {
                            blueIsEscape = true;
                            blueR = -1;
                            blueC = -1;
                            break;
                        }
                    }
                    while (map[redR][redC + 1] != '#' && redC + 1 != blueC) {
                        redC++;
                        if (map[redR][redC] == 'O') {
                            redIsEscape = true;
                            redR = -1;
                            redC = -1;
                            break;
                        }
                    }
                }
            }

            return new Node(redR, redC, blueR, blueC, order, redIsEscape, blueIsEscape);
        }

        return null;
    }

    private static int bfs(Node input, int N, int M, char[][] map) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(input);

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.remove();

                if (node.redStatus && !node.blueStatus) return dist;
                if (node.blueStatus) continue;

                for (int dir = 0; dir < 4; dir++) {
                    if (node.order == command[dir]) continue;

                    q.add(move(node, command[dir], N, M, map));
                }
            }

            dist++;
            if (dist > 10) break;
        }

        return -1;
    }

}
