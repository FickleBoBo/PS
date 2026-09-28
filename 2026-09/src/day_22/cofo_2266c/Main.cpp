#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    int cnt0 = count(s.begin(), s.end(), '0');
    if (s[0] == '1') {
        cout << cnt0 << '\n';
    } else {
        int ans = cnt0;
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                cnt0--;
            } else {
                ans = min(ans, cnt0 + cnt1);
                cnt1++;
            }
        }
        ans = min(ans, cnt1);

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
