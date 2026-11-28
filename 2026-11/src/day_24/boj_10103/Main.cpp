#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sumA = 100;
    int sumB = 100;

    int n;
    cin >> n;

    while (n--) {
        int a, b;
        cin >> a >> b;

        if (a > b) {
            sumB -= a;
        } else if (a < b) {
            sumA -= b;
        }
    }

    cout << sumA << '\n';
    cout << sumB << '\n';
}
