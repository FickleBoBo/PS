#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    int n = 1;
    while (n < arr.size()) n <<= 1;
    arr.resize(n);

    return arr;
}
