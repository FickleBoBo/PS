package day_11.prms_181867;

class Solution {
    public int[] solution(String myString) {
        String[] tokens = myString.split("x", -1);
        int[] ans = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            ans[i] = tokens[i].length();
        }

        return ans;
    }
}
