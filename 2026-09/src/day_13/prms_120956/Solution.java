package day_13.prms_120956;

class Solution {
    public int solution(String[] babbling) {
        int cnt = 0;
        for (String s : babbling) {
            String res = s
                    .replace("aya", " ")
                    .replace("ye", " ")
                    .replace("woo", " ")
                    .replace("ma", " ");

            if (res.isBlank()) cnt++;
        }

        return cnt;
    }
}
