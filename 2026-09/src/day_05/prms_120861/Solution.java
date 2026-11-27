package day_05.prms_120861;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxX = board[0] / 2, maxY = board[1] / 2;

        for (String s : keyinput) {
            if (s.equals("up")) {
                y = Math.min(y + 1, maxY);
            } else if (s.equals("down")) {
                y = Math.max(y - 1, -maxY);
            } else if (s.equals("left")) {
                x = Math.max(x - 1, -maxX);
            } else {
                x = Math.min(x + 1, maxX);
            }
        }

        return new int[]{x, y};
    }
}
