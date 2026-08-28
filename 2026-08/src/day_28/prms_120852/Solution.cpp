#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n) {
    vector<int> v;
    int x = 2;

    while (n > 1) {
        if (n % x == 0) {
            v.push_back(x);
            while (n % x == 0) {
                n /= x;
            }
            continue;
        }

        x++;
    }

    return v;
}
