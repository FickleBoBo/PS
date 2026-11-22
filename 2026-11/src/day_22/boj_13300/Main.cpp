#include <bits/stdc++.h>
using namespace std;

int cnt[1 + 6][2];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    while (n--) {
        int s, y;
        cin >> s >> y;
        cnt[y][s]++;
    }

    int ans = 0;
    for (int i = 1; i <= 6; i++) {
        for (int j = 0; j <= 1; j++) {
            ans += (cnt[i][j] + k - 1) / k;
        }
    }

    cout << ans;
}
