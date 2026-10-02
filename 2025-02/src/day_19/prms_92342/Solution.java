package day_19.PRMS_92342;

class Solution {

    // 라이언과 어피치의 최대 점수 차
    private static int max = 0;

    // 라이언과 어피치의 최대 점수 차일때 answer
    private static int[] ans = new int[11];

    // 라이언에 대한 승(1), 무(0), 패(-1) 배열
    private static final int[] visited = new int[11];

    public int[] solution(int n, int[] info) {
        powerSet(0, 0, n, info);

        if (max == 0) return new int[]{-1};
        return ans;
    }

    // 각 점수에 대한 승무패를 탐색하는 메서드
    private static void powerSet(int selIdx, int result, int n, int[] info) {
        if (selIdx == 11) {
            // 라이언이 지는 조합이면 return하는 백트래킹
            if (result < max) return;

            solve(result, n, info);
            return;
        }

        // 패
        visited[selIdx] = -1;
        powerSet(selIdx + 1, result - (10 - selIdx), n, info);

        // 무
        visited[selIdx] = 0;
        if (info[selIdx] == 0) powerSet(selIdx + 1, result, n, info);
        else powerSet(selIdx + 1, result - (10 - selIdx), n, info);

        // 승
        visited[selIdx] = 1;
        powerSet(selIdx + 1, result + (10 - selIdx), n, info);
    }

    private static void solve(int result, int n, int[] info) {
        // 라이언이 쏜 총 화살 수
        int cnt = 0;

        // 라이언이 쏜 각 점수당 화살 수
        int[] arr = new int[11];

        for (int i = 0; i <= 10; i++) {
            if (visited[i] == 1) {
                cnt += info[i] + 1;
                arr[i] = info[i] + 1;
            } else if (visited[i] == 0 && info[i] != 0) {
                cnt += info[i];
                arr[i] = info[i];
            }
        }

        // 라이언이 n개를 초과하는 화살을 쏴야하면 return
        if (cnt > n) return;

        // 라이언이 n개 미만으로 화살을 쏴서 나타난 결과면 결과가 바뀌지 않는 선에서 점수가 낮은 과녁에 추가로 쏨
        if (cnt < n) {
            for (int i = 10; i >= 0; i--) {
                if (visited[i] == 1) {
                    arr[i] += n - cnt;
                    break;
                } else if (visited[i] == -1) {
                    while (cnt < n && arr[i] < info[i]) {
                        arr[i]++;
                        cnt++;
                    }
                    if (cnt == n) break;
                }
            }
        }

        if (result > max) {
            max = result;
            ans = arr;
            return;
        }

        if (result == max) {
            for (int i = 10; i >= 0; i--) {
                if (ans[i] > arr[i]) return;
                else if (ans[i] < arr[i]) {
                    ans = arr;
                    return;
                }
            }
        }
    }

}
