#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    long long k;
    cin >> n >> k;

    vector<pair<long long, long long>> v(n);
    for (int i = 0; i < n; i++) {
        long long a, b, c;
        cin >> a >> b >> c;

        v[i].first = a + b + c;
        if (a < b && b < c) {
            v[i].second = min(b - a, c - b) + 1;
        } else if ((a < b && b == c) || (a == b && b < c)) {
            v[i].second = b - a + 1;
        } else if (a == b && b == c) {
            v[i].second = -1;
        }
    }
    sort(v.begin(), v.end());

    for (int i = 1; i < n; i++) {
        auto [sum, cnt] = v[i];
        auto [psum, pcnt] = v[i - 1];

        if (pcnt == -1) {
            cout << psum << '\n';
            return;
        }
        if (pcnt > 0) {
            k -= pcnt * 2;
            if (k <= 0) {
                cout << psum << '\n';
                return;
            }
        }

        if (k < (sum - psum) * i) {
            cout << psum + k / i << '\n';
            return;
        }

        k -= (sum - psum) * i;
    }

    cout << v.back().first + k / n << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
