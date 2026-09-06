#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> dots) {
    int minx = min({dots[0][0], dots[1][0], dots[2][0], dots[3][0]});
    int maxx = max({dots[0][0], dots[1][0], dots[2][0], dots[3][0]});
    int miny = min({dots[0][1], dots[1][1], dots[2][1], dots[3][1]});
    int maxy = max({dots[0][1], dots[1][1], dots[2][1], dots[3][1]});
    return (maxx - minx) * (maxy - miny);
}
