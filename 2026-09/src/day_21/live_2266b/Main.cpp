#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long a, b, c;
    cin >> a >> b >> c;

    if (a < b) {
        if (abs(a + c - b) > abs(a - b)) {
            cout << abs(a + c - b) << '\n';
        } else {
            cout << abs(a - b) << '\n';
        }
    } else {
        cout << abs(a + c - b) << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
