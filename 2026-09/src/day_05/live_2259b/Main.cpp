#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    int odd = 0, even1 = 0, even2 = 0;
    while (n--) {
        int x;
        cin >> x;

        if (x % 2) {
            odd++;
        } else {
            if (x / 2 % 2) {
                even1++;
            } else {
                even2++;
            }
        }
    }

    cout << max({odd, even1, even2}) << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
