#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string k;
        cin >> k;

        if ((k.back() - '0') % 2 == 0) {
            cout << "even\n";
        } else {
            cout << "odd\n";
        }
    }
}
