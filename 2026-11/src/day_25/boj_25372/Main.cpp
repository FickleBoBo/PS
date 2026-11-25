#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string s;
        cin >> s;

        if (6 <= s.size() && s.size() <= 9) {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }
}
