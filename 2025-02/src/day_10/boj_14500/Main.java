package day_10.BOJ_14500;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<boolean[][]> tetrominoList = init();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (boolean[][] tetromino : tetrominoList) {
            int height = tetromino.length;
            int width = tetromino[0].length;

            for (int i = 0; i <= N - height; i++) {
                for (int j = 0; j <= M - width; j++) {
                    int sum = 0;

                    for (int a = 0; a < height; a++) {
                        for (int b = 0; b < width; b++) {
                            if (tetromino[a][b]) sum += map[i + a][j + b];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }

    private static List<boolean[][]> init() {
        List<boolean[][]> list = new ArrayList<>();

        boolean[][] type1 = new boolean[][]{{true, true, true, true}};
        boolean[][] type2 = new boolean[][]{{true, true}, {true, true}};
        boolean[][] type3 = new boolean[][]{{true, false}, {true, false}, {true, true}};
        boolean[][] type4 = new boolean[][]{{true, false}, {true, true}, {false, true}};
        boolean[][] type5 = new boolean[][]{{false, true, false}, {true, true, true}};
        boolean[][] flippedType3 = flip(type3);
        boolean[][] flippedType4 = flip(type4);

        list.add(type1);
        list.add(rotate90(type1));

        list.add(type2);

        list.add(type3);
        list.add(rotate90(type3));
        list.add(rotate180(type3));
        list.add(rotate270(type3));
        list.add(flippedType3);
        list.add(rotate90(flippedType3));
        list.add(rotate180(flippedType3));
        list.add(rotate270(flippedType3));

        list.add(type4);
        list.add(rotate90(type4));
        list.add(flippedType4);
        list.add(rotate90(flippedType4));

        list.add(type5);
        list.add(rotate90(type5));
        list.add(rotate180(type5));
        list.add(rotate270(type5));

        return list;
    }

    private static boolean[][] rotate90(boolean[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        boolean[][] newMatrix = new boolean[W][H];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                newMatrix[i][j] = matrix[H - 1 - j][i];
            }
        }

        return newMatrix;
    }

    private static boolean[][] rotate180(boolean[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        boolean[][] newMatrix = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMatrix[i][j] = matrix[H - 1 - i][W - 1 - j];
            }
        }

        return newMatrix;
    }

    private static boolean[][] rotate270(boolean[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        boolean[][] newMatrix = new boolean[W][H];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                newMatrix[i][j] = matrix[j][W - 1 - i];
            }
        }

        return newMatrix;
    }

    private static boolean[][] flip(boolean[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        boolean[][] newMatrix = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMatrix[i][j] = matrix[i][W - 1 - j];
            }
        }

        return newMatrix;
    }

}
