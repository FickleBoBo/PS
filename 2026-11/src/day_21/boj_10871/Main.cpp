#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    while (n--) {
        int x;
        cin >> x;

        if (x < k) cout << x << ' ';
    }
}
