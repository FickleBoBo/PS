#include <bits/stdc++.h>
using namespace std;

const long long INF = 1'000'000'000'000'000'000;

long long upper_bound_param(int n, long long k, vector<long long>& sum, vector<long long>& cost) {
    long long lo = *min_element(sum.begin(), sum.end());
    long long hi = lo + k + 1;
    while (lo < hi) {
        long long mid = lo + (hi - lo) / 2;

        long long need = 0;
        for (int i = 0; i < n && need <= k; i++) {
            if (sum[i] < mid) need += cost[i] + (mid - sum[i]);
        }

        if (need <= k) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }

    return lo;
}

void solve() {
    int n;
    long long k;
    cin >> n >> k;

    vector<long long> sum(n), cost(n);
    for (int i = 0; i < n; i++) {
        long long a, b, c;
        cin >> a >> b >> c;

        sum[i] = a + b + c;
        if (a == b && b == c) {
            cost[i] = INF;
        } else if (a <= b && b <= c) {
            cost[i] = 2 * (min(b - a, c - b) + 1);
        }
    }

    cout << upper_bound_param(n, k, sum, cost) - 1 << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
