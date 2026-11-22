#include <bits/stdc++.h>
using namespace std;

int arr[1 + 1000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int num = 1;
    int idx = 1;
    bool flag = true;

    while (flag) {
        for (int i = 1; i <= num; i++) {
            arr[idx++] = num;
            if (idx > 1000) {
                flag = false;
                break;
            }
        }
        num++;
    }

    int a, b;
    cin >> a >> b;

    int sum = 0;
    for (int i = a; i <= b; i++) {
        sum += arr[i];
    }

    cout << sum;
}
