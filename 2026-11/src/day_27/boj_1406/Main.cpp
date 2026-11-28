#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<char> f, b;

    string s;
    cin >> s;

    for (char c : s) {
        f.push_back(c);
    }

    int m;
    cin >> m;

    while (m--) {
        char op;
        cin >> op;

        if (op == 'L') {
            if (!f.empty()) {
                b.push_front(f.back());
                f.pop_back();
            }
        } else if (op == 'D') {
            if (!b.empty()) {
                f.push_back(b.front());
                b.pop_front();
            }
        } else if (op == 'B') {
            if (!f.empty()) f.pop_back();
        } else {
            char c;
            cin >> c;
            f.push_back(c);
        }
    }

    for (char c : f) cout << c;
    for (char c : b) cout << c;
}
