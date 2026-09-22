#include <bits/stdc++.h>
using namespace std;

int solution(string num_str) {
    int sum = 0;
    for (char c : num_str) sum += c - '0';
    return sum;
}
