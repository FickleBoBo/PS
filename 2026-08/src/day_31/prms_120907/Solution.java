package day_31.prms_120907;

class Solution {
    public String[] solution(String[] quiz) {
        String[] ans = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);
            int z = Integer.parseInt(arr[4]);
            String op = arr[1];

            int res = op.equals("+") ? x + y : x - y;
            ans[i] = res == z ? "O" : "X";
        }

        return ans;
    }
}
