package day_05.prms_120861;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] pos = {0, 0};
        int maxx = board[0] / 2;
        int maxy = board[1] / 2;

        for (String s : keyinput) {
            if (s.equals("up")) {
                pos[1] = Math.min(pos[1] + 1, maxy);
            } else if (s.equals("down")) {
                pos[1] = Math.max(pos[1] - 1, -maxy);
            } else if (s.equals("left")) {
                pos[0] = Math.max(pos[0] - 1, -maxx);
            } else {
                pos[0] = Math.min(pos[0] + 1, maxx);
            }
        }

        return pos;
    }
}
