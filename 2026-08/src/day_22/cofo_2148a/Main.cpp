#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int x, n;
        cin >> x >> n;

        if (n % 2) {
            cout << x << '\n';
        } else {
            cout << 0 << '\n';
        }
    }
}
