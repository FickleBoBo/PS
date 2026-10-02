#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int l = 1;
    int r = 2 * n;
    for (int i = 1; i <= 2 * n - 1; i++) {
        for (int j = 1; j <= l; j++) {
            cout << '*';
        }
        for (int j = l + 1; j < r; j++) {
            cout << ' ';
        }
        for (int j = r; j <= 2 * n; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < n) {
            l++;
            r--;
        } else {
            l--;
            r++;
        }
    }
}
