#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int x1, y1, x2, y2, x3, y3;
    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

    int x4 = x1 ^ x2 ^ x3;
    int y4 = y1 ^ y2 ^ y3;
    cout << x4 << ' ' << y4;
}
