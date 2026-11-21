#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int mx = 0;
    int idx = 0;
    for (int i = 1; i <= 9; i++) {
        int x;
        cin >> x;

        if (x > mx) {
            mx = x;
            idx = i;
        }
    }

    cout << mx << '\n';
    cout << idx << '\n';
}
