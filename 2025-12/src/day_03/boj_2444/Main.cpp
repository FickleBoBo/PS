#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int l = n;
    int r = n;
    for (int i = 1; i <= 2 * n - 1; i++) {
        for (int j = 1; j < l; j++) {
            cout << ' ';
        }
        for (int j = l; j <= r; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < n) {
            l--;
            r++;
        } else {
            l++;
            r--;
        }
    }
}
