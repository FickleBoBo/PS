#include <bits/stdc++.h>
using namespace std;

int count_factor(int x, int div) {
    int cnt = 0;
    while (x > 0) {
        x /= div;
        cnt += x;
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    int cnt2 = count_factor(n, 2) - count_factor(m, 2) - count_factor(n - m, 2);
    int cnt5 = count_factor(n, 5) - count_factor(m, 5) - count_factor(n - m, 5);
    cout << min(cnt2, cnt5);
}
