#include <bits/stdc++.h>
using namespace std;

long long upperBound(long long key) {
    long long lo = 0, hi = INT_MAX;
    while (lo < hi) {
        long long mid = lo + (hi - lo) / 2;
        if (mid * mid <= key) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return lo;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long a, b;
    cin >> a >> b;

    long long cnt = upperBound(b) - upperBound(a);

    if (cnt == 0) {
        cout << 0;
    } else {
        long long g = gcd(cnt, b - a);
        cout << cnt / g << '/' << (b - a) / g;
    }
}
