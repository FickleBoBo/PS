package day_31.prms_181886;

class Solution {
    public String[] solution(String[] names) {
        String[] arr = new String[(names.length + 4) / 5];
        int idx = 0;

        for (int i = 0; i < names.length; i += 5) {
            arr[idx++] = names[i];
        }

        return arr;
    }
}
