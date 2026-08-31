#include <bits/stdc++.h>
using namespace std;

vector<int> step(vector<int> v) {
    for (int& x : v) {
        if (x >= 50 && x % 2 == 0) {
            x /= 2;
        } else if (x < 50 && x % 2) {
            x = x * 2 + 1;
        }
    }

    return v;
}

int solution(vector<int> arr) {
    vector<int> prv = arr;
    int x = 0;

    while (true) {
        vector<int> cur = step(prv);

        if (prv == cur) return x;
        prv = cur;
        x++;
    }
}
