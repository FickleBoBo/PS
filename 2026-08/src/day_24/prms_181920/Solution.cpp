#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int start_num, int end_num) {
    vector<int> v(end_num - start_num + 1);
    iota(v.begin(), v.end(), start_num);
    return v;
}
