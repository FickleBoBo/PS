#include <bits/stdc++.h>
using namespace std;

int solution(int a, int b) {
    int x = stoi(to_string(a) + to_string(b));
    int y = 2 * a * b;
    return max(x, y);
}
