#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> numbers, int num1, int num2) {
    return vector<int>(numbers.begin() + num1, numbers.begin() + num2 + 1);
}
