#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    priority_queue<int> pq;
    long long sum = 0;
    for (int i = 0; i < m - 1; i++) {
        pq.push(a[i]);
        sum += a[i];
    }

    long long ans = -LLONG_MAX;
    for (int i = m - 1; i < n; i++) {
        ans = max(ans, (long long)m * a[i] - sum);

        if (!pq.empty() && pq.top() > a[i]) {
            sum -= pq.top();
            pq.pop();
            sum += a[i];
            pq.push(a[i]);
        }
    }

    cout << ans << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
