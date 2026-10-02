package day_04.PRMS_172927;

class Solution {

    private static final int DIAMOND = 0;
    private static final int IRON = 1;
    private static final int STONE = 2;

    // 행은 곡괭이의 종류, 열은 광물의 종류, 값은 피로도
    private static final int[][] map = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1},
    };

    private static int ans = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        int pickCnt = 0;
        for (int pick : picks) {
            pickCnt += pick;
        }

        // 계산의 편의를 위해 광물을 정수로 바꿔줌
        int[] newMinerals = init(minerals);

        // 곡괭이의 개수와 광물을 모두 캐는데 필요한 곡괭이의 개수 중 최솟값이 순열에서 뽑을 곡괭이의 수
        int maxIdx = Math.min(pickCnt, (minerals.length + 4) / 5);

        permutation(0, maxIdx, 0, picks, newMinerals);

        return ans;
    }

    private static void permutation(int selIdx, int maxIdx, int result, int[] picks, int[] minerals) {
        // 현재까지 구한 최소값보다 커지면 더 탐색할 필요 없음(백트래킹)
        if (result >= ans) return;

        if (selIdx == maxIdx) {
            ans = result;
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;

            // 곡괭이 선택
            picks[i]--;

            permutation(selIdx + 1, maxIdx, result + mining(i, minerals, selIdx * 5, (selIdx + 1) * 5), picks, minerals);

            // 순열 탐색 후 곡괭이 선택 해제
            picks[i]++;
        }
    }

    private static int[] init(String[] minerals) {
        int[] newMinerals = new int[minerals.length];

        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("iron")) newMinerals[i] = IRON;
            else if (minerals[i].equals("stone")) newMinerals[i] = STONE;
        }

        return newMinerals;
    }

    private static int mining(int pick, int[] minerals, int startIdx, int endIdx) {
        // 마지막 곡괭이가 캘 광물이 5개가 안될 수 있음
        endIdx = Math.min(endIdx, minerals.length);

        int result = 0;

        for (int i = startIdx; i < endIdx; i++) {
            result += map[pick][minerals[i]];
        }

        return result;
    }

}
