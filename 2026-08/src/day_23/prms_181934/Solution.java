package day_23.prms_181934;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">")) {
            if (eq.equals("=")) return n >= m ? 1 : 0;
            return n > m ? 1 : 0;
        } else {
            if (eq.equals("=")) return n <= m ? 1 : 0;
            return n < m ? 1 : 0;
        }
    }
}
