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

        if (n % 2 == 0) {
            cout << '0' << '\n';
        } else {
            cout << x << '\n';
        }
    }
}
