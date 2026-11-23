#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int pivot = n;
    for (int i = 1; i <= 2 * n - 1; i++) {
        for (int j = 1; j < pivot; j++) {
            cout << ' ';
        }
        for (int j = pivot; j <= n; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < n) {
            pivot--;
        } else {
            pivot++;
        }
    }
}
