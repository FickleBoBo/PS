#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n) {
    vector<int> v;
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            v.push_back(i);
            if (i != n / i) v.push_back(n / i);
        }
    }
    sort(v.begin(), v.end());

    return v;
}
