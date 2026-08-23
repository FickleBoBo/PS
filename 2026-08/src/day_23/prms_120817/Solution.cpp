#include <bits/stdc++.h>
using namespace std;

double solution(vector<int> numbers) {
    double sum = 0;
    for (int x : numbers) sum += x;
    return sum / numbers.size();
}
