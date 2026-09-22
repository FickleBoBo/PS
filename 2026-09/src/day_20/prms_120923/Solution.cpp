#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int num, int total) {
    vector<int> v(num);
    iota(v.begin(), v.end(), total / num - (num - 1) / 2);
    return v;
}
