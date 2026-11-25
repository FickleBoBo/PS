#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int ysum = 0;
        int ksum = 0;

        for (int i = 0; i < 9; i++) {
            int y, k;
            cin >> y >> k;
            ysum += y;
            ksum += k;
        }

        if (ysum > ksum) {
            cout << "Yonsei\n";
        } else if (ysum < ksum) {
            cout << "Korea\n";
        } else {
            cout << "Draw\n";
        }
    }
}
