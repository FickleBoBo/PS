#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int tc = 1;; tc++) {
        int l, p, v;
        cin >> l >> p >> v;

        if (l == 0) break;
        cout << "Case " << tc << ": " << v / p * l + min(v % p, l) << '\n';
    }
}
