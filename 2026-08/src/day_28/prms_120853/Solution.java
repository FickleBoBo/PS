package day_28.prms_120853;

class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) {
                sum -= Integer.parseInt(arr[i - 1]);
            } else {
                sum += Integer.parseInt(arr[i]);
            }
        }

        return sum;
    }
}
