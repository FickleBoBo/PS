#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int c;
        cin >> c;

        cout << c / 25 << ' ';
        c %= 25;

        cout << c / 10 << ' ';
        c %= 10;

        cout << c / 5 << ' ';
        c %= 5;

        cout << c << '\n';
    }
}
