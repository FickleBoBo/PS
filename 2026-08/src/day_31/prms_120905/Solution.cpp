#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, vector<int> numlist) {
    vector<int> v;
    for (int x : numlist) {
        if (x % n == 0) v.push_back(x);
    }

    return v;
}
