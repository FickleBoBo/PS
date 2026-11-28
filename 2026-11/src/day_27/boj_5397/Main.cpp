#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        deque<char> f, b;

        string s;
        cin >> s;

        for (char c : s) {
            if (c == '-') {
                if (!f.empty()) f.pop_back();
            } else if (c == '<') {
                if (!f.empty()) {
                    b.push_front(f.back());
                    f.pop_back();
                }
            } else if (c == '>') {
                if (!b.empty()) {
                    f.push_back(b.front());
                    b.pop_front();
                }
            } else {
                f.push_back(c);
            }
        }

        for (char c : f) cout << c;
        for (char c : b) cout << c;
        cout << '\n';
    }
}
