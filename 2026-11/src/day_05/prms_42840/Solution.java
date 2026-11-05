package day_05.prms_42840;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % 5]) cnt[0]++;
            if (answers[i] == b[i % 8]) cnt[1]++;
            if (answers[i] == c[i % 10]) cnt[2]++;
        }

        if (cnt[0] == cnt[1] && cnt[1] == cnt[2]) {
            return new int[]{1, 2, 3};
        } else if (cnt[0] == cnt[1] && cnt[1] > cnt[2]) {
            return new int[]{1, 2};
        } else if (cnt[0] == cnt[2] && cnt[2] > cnt[1]) {
            return new int[]{1, 3};
        } else if (cnt[1] == cnt[2] && cnt[2] > cnt[0]) {
            return new int[]{2, 3};
        } else if (cnt[0] > cnt[1] && cnt[0] > cnt[2]) {
            return new int[]{1};
        } else if (cnt[1] > cnt[0] && cnt[1] > cnt[2]) {
            return new int[]{2};
        } else {
            return new int[]{3};
        }
    }
}
