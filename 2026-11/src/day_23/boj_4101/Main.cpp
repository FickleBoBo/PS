#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        int a, b;
        cin >> a >> b;

        if (a == 0) break;

        if (a > b) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }
}
