#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t >> ws;

    while (t--) {
        string s;
        getline(cin, s);
        stringstream ss(s);

        double x;
        ss >> x;

        char c;
        while (ss >> c) {
            if (c == '@') {
                x *= 3;
            } else if (c == '%') {
                x += 5;
            } else {
                x -= 7;
            }
        }

        cout << fixed << setprecision(2) << x << '\n';
    }
}
