#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sum = 0;
    int mn = 100;

    for (int i = 0; i < 7; i++) {
        int x;
        cin >> x;

        if (x % 2) {
            sum += x;
            mn = min(mn, x);
        }
    }

    if (sum == 0) {
        cout << -1;
    } else {
        cout << sum << '\n';
        cout << mn << '\n';
    }
}
