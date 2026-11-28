#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int ySum = 0;
        int kSum = 0;

        for (int i = 0; i < 9; i++) {
            int y, k;
            cin >> y >> k;
            ySum += y;
            kSum += k;
        }

        if (ySum > kSum) {
            cout << "Yonsei\n";
        } else if (ySum < kSum) {
            cout << "Korea\n";
        } else {
            cout << "Draw\n";
        }
    }
}
