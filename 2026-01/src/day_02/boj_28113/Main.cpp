#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, a, b;
    cin >> n >> a >> b;

    if (a < b) {
        cout << "Bus";
    } else if (a > b) {
        cout << "Subway";
    } else {
        cout << "Anything";
    }
}
