package day_28.prms_181829;

class Solution {
    public int solution(int[][] board, int k) {
        int sum = 0;
        for (int i = 0; i < Math.min(board.length, k + 1); i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i + j > k) break;
                sum += board[i][j];
            }
        }

        return sum;
    }
}
