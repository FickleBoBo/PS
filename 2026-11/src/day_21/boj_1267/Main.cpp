#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int ySum = 0;
    int mSum = 0;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;

        ySum += (x / 30 + 1) * 10;
        mSum += (x / 60 + 1) * 15;
    }

    if (ySum < mSum) {
        cout << "Y " << ySum << '\n';
    } else if (ySum > mSum) {
        cout << "M " << mSum << '\n';
    } else {
        cout << "Y M " << ySum << '\n';
    }
}
