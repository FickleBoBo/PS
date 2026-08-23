#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    long long mul = 1, sum = 0;
    for (int x : num_list) {
        mul *= x;
        sum += x;
    }

    return mul < sum * sum;
}
