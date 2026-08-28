package day_25.prms_12909;

class Solution2 {
    boolean solution(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else {
                if (cnt == 0) return false;
                cnt--;
            }
        }

        return cnt == 0;
    }
}
