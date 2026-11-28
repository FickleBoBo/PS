#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int mnX = 10000;
    int mnY = 10000;
    int mxX = -10000;
    int mxY = -10000;

    int n;
    cin >> n;

    while (n--) {
        int x, y;
        cin >> x >> y;

        mnX = min(mnX, x);
        mnY = min(mnY, y);
        mxX = max(mxX, x);
        mxY = max(mxY, y);
    }

    cout << (mxX - mnX) * (mxY - mnY);
}
