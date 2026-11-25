#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int first;
    cin >> first;

    for (int i = 0; i < n - 1; i++) {
        int r;
        cin >> r;
        int g = gcd(first, r);
        cout << first / g << '/' << r / g << '\n';
    }
}
