#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int a, b, c;
        cin >> a >> b >> c;

        if (a >= b + c || b >= a + c || c >= a + b) {
            cout << "Case #" << tc << ": invalid!\n";
        } else if (a == b && b == c) {
            cout << "Case #" << tc << ": equilateral\n";
        } else if (a == b || b == c || c == a) {
            cout << "Case #" << tc << ": isosceles\n";
        } else {
            cout << "Case #" << tc << ": scalene\n";
        }
    }
}
