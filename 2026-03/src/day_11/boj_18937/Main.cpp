#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int nimsum = 0;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        nimsum ^= x - 2;
    }

    string s;
    cin >> s;
    bool white_first = s == "Whiteking";

    if (nimsum) {
        if (white_first) {
            cout << "Whiteking";
        } else {
            cout << "Blackking";
        }
    } else {
        if (white_first) {
            cout << "Blackking";
        } else {
            cout << "Whiteking";
        }
    }
}
