#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n) {
    vector<int> v;
    while (n > 1) {
        v.push_back(n);
        if (n % 2) {
            n = 3 * n + 1;
        } else {
            n /= 2;
        }
    }
    v.push_back(n);

    return v;
}
