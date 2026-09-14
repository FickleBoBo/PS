#include <bits/stdc++.h>
using namespace std;

const int MOD = 1'000'000'007;

int dfs(vector<int>& v, vector<bool>& chk, int pos, vector<bool>& pick, int n) {
    if (pos == n) return 0;

    bool ok = false;
    for (int i = 1; i <= n; i++) {
        if ((pos + 1) % n == 0) {
            for (int j = i; j <= i + 1; j++) {
                if (pick[j]) ok = true;
            }
        }
    }
    if (!ok) return 0;

    int cnt = 1;

    if (chk[pos]) {
        pick[pos] = true;
        cnt += dfs(v, chk, pos + 1, pick, n) % MOD;

        pick[pos] = false;
        cnt += dfs(v, chk, pos + 1, pick, n) % MOD;
    } else {
        pick[pos] = false;
        cnt += dfs(v, chk, pos + 1, pick, n) % MOD;
    }

    return cnt % MOD;
}

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<bool> chk(n + 1, true);
    chk[n] = false;
    chk[v[0]] = false;

    for (int i = 1; i < n; i++) {
        int s = (i + 1) * v[i];
        int e = (i + 1) * (v[i] + 1);

        for (int j = min(s, n); j < min(e, n); j++) {
            chk[j] = false;
        }
    }

    vector<bool> pick(n);
    cout << dfs(v, chk, 0, pick, n) << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
