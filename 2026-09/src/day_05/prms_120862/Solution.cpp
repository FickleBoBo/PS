#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers) {
    int mx = -INT_MAX;
    for (int i = 0; i < numbers.size() - 1; i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            mx = max(mx, numbers[i] * numbers[j]);
        }
    }

    return mx;
}
