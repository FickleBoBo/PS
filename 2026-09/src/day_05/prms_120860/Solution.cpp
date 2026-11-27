#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> dots) {
    int minX = min({dots[0][0], dots[1][0], dots[2][0], dots[3][0]});
    int maxX = max({dots[0][0], dots[1][0], dots[2][0], dots[3][0]});
    int minY = min({dots[0][1], dots[1][1], dots[2][1], dots[3][1]});
    int maxY = max({dots[0][1], dots[1][1], dots[2][1], dots[3][1]});
    return (maxX - minX) * (maxY - minY);
}
