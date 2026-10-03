package day_05.prms_120861;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxx = board[0] / 2, maxy = board[1] / 2;

        for (String s : keyinput) {
            if (s.equals("up")) {
                y = Math.min(y + 1, maxy);
            } else if (s.equals("down")) {
                y = Math.max(y - 1, -maxy);
            } else if (s.equals("left")) {
                x = Math.max(x - 1, -maxx);
            } else {
                x = Math.min(x + 1, maxx);
            }
        }

        return new int[]{x, y};
    }
}
