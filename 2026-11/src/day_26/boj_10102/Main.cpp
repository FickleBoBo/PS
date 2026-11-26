#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a = 0;
    int b = 0;

    int v;
    string s;
    cin >> v >> s;

    for (char c : s) {
        if (c == 'A') {
            a++;
        } else {
            b++;
        }
    }

    if (a > b) {
        cout << 'A';
    } else if (a < b) {
        cout << 'B';
    } else {
        cout << "Tie";
    }
}
