#include <bits/stdc++.h>
using namespace std;

int solution(int a, int d, vector<bool> included) {
    int sum = 0;
    for (int i = 0; i < included.size(); i++) {
        if (included[i]) sum += a + d * i;
    }

    return sum;
}
