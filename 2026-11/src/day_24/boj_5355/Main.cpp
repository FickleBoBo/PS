#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t >> ws;

    while (t--) {
        string line;
        getline(cin, line);
        stringstream ss(line);

        double x;
        ss >> x;

        char op;
        while (ss >> op) {
            if (op == '@') {
                x *= 3;
            } else if (op == '%') {
                x += 5;
            } else {
                x -= 7;
            }
        }

        cout << fixed << setprecision(2) << x << '\n';
    }
}
