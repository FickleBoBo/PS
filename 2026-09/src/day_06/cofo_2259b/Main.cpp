#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> cnt(4);
    while (n--) {
        int x;
        cin >> x;
        cnt[x % 4]++;
    }

    cout << max({cnt[1] + cnt[3], cnt[0], cnt[2]}) << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
