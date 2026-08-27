#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers) {
    sort(numbers.begin(), numbers.end());
    return numbers[numbers.size() - 2] * numbers[numbers.size() - 1];
}
