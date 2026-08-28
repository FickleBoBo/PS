package day_28.prms_120854;

class Solution {
    public int[] solution(String[] strlist) {
        int[] arr = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            arr[i] = strlist[i].length();
        }

        return arr;
    }
}
