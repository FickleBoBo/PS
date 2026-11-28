#include <bits/stdc++.h>
using namespace std;

int countFactor(int x, int div) {
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

    int cnt2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
    int cnt5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);
    cout << min(cnt2, cnt5);
}
