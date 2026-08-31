#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers, int n) {
    int sum = 0;
    for (int x : numbers) {
        sum += x;
        if (sum > n) return sum;
    }

    return -1;
}
