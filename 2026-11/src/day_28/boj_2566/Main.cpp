#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int mx = -1;
    int r = 0, c = 0;

    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            int x;
            cin >> x;

            if (x > mx) {
                mx = x;
                r = i;
                c = j;
            }
        }
    }

    cout << mx << '\n';
    cout << r << ' ' << c;
}
