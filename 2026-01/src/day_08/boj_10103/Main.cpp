#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sum_a = 100;
    int sum_b = 100;

    int n;
    cin >> n;

    while (n--) {
        int a, b;
        cin >> a >> b;

        if (a > b) {
            sum_b -= a;
        } else if (a < b) {
            sum_a -= b;
        }
    }

    cout << sum_a << '\n';
    cout << sum_b << '\n';
}
