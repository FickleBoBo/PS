#include <bits/stdc++.h>
using namespace std;

bool is_parallel(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
    return (p1[0] - p2[0]) * (p3[1] - p4[1]) == (p3[0] - p4[0]) * (p1[1] - p2[1]);
}

int solution(vector<vector<int>> dots) {
    vector<int> p1 = dots[0], p2 = dots[1], p3 = dots[2], p4 = dots[3];
    return is_parallel(p1, p2, p3, p4) || is_parallel(p1, p3, p2, p4) || is_parallel(p1, p4, p2, p3);
}
