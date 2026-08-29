#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> array, int n) {
    int ans = 0;
    int diff = 100;

    for (int x : array) {
        if (abs(x - n) < diff) {
            ans = x;
            diff = abs(x - n);
        } else if (abs(x - n) == diff && x < ans) {
            ans = x;
        }
    }

    return ans;
}
