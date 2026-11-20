#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long n;
    cin >> n;

    if (n % 5 == 0) {
        cout << n / 5;
    } else if (n >= 3 && (n - 3) % 5 == 0) {
        cout << (n - 3) / 5 + 1;
    } else if (n >= 6 && (n - 6) % 5 == 0) {
        cout << (n - 6) / 5 + 2;
    } else if (n >= 9 && (n - 9) % 5 == 0) {
        cout << (n - 9) / 5 + 3;
    } else if (n >= 12 && (n - 12) % 5 == 0) {
        cout << (n - 12) / 5 + 4;
    } else {
        cout << -1;
    }
}
