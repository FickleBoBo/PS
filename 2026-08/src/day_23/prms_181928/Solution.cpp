#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    int odd = 0, even = 0;

    for (int x : num_list) {
        if (x % 2) {
            odd = odd * 10 + x;
        } else {
            even = even * 10 + x;
        }
    }

    return odd + even;
}
