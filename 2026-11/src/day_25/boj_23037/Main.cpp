#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int sum = 0;
    for (char c : s) {
        int d = c - '0';
        sum += d * d * d * d * d;
    }

    cout << sum;
}
