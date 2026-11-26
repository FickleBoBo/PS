#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int prv = -1'000'000;

    int x;
    while (cin >> x) {
        if (x >= prv) {
            prv = x;
        } else {
            cout << "Bad";
            return 0;
        }
    }

    cout << "Good";
}
