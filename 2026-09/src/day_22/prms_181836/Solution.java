package day_22.prms_181836;

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] arr = new String[picture.length * k];
        int idx = 0;

        for (String s : picture) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.repeat(c, k);
            }

            String res = sb.toString();
            for (int j = 0; j < k; j++) {
                arr[idx++] = res;
            }
        }

        return arr;
    }
}
