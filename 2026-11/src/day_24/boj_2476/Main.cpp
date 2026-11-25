#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int mx = 0;

    int n;
    cin >> n;

    while (n--) {
        int a, b, c;
        cin >> a >> b >> c;

        if (a == b && b == c) {
            mx = max(mx, 10000 + a * 1000);
        } else if (a == b) {
            mx = max(mx, 1000 + a * 100);
        } else if (b == c) {
            mx = max(mx, 1000 + b * 100);
        } else if (c == a) {
            mx = max(mx, 1000 + c * 100);
        } else {
            mx = max(mx, max({a, b, c}) * 100);
        }
    }

    cout << mx;
}
