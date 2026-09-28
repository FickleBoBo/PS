#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    int ans = count(s.begin(), s.end(), '0');
    if (s[0] == '1') {
        cout << ans << '\n';
    } else {
        vector<int> cnt0(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            cnt0[i] += cnt0[i + 1];
            if (s[i] == '0') cnt0[i]++;
        }
        vector<int> cnt1(n + 1);
        for (int i = 1; i < n; i++) {
            cnt1[i] += cnt1[i - 1];
            if (s[i] == '1') cnt1[i]++;
        }

        for (int i = 1; i < n; i++) {
            if (s[i] == '1') {
                ans = min({ans, cnt0[i + 1] + cnt1[i - 1]});
            }
        }
        ans = min({ans, cnt1[n - 1]});

        cout << ans << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
