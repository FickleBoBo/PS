package day_11.prms_181867;

class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x", -1);
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i].length();
        }

        return ans;
    }
}
