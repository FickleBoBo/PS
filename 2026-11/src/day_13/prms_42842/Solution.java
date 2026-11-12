package day_13.prms_42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h = 3; h < brown; h++) {
            int w = (brown + 4) / 2 - h;
            if ((w - 2) * (h - 2) == yellow) return new int[]{w, h};
        }

        return null;
    }
}
