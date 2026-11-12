#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int yellow) {
    for (int h = 3; h < brown; h++) {
        int w = (brown + 4) / 2 - h;
        if ((w - 2) * (h - 2) == yellow) return {w, h};
    }

    return {};
}
