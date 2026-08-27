#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers, int k) {
    return numbers[2 * (k - 1) % numbers.size()];
}
