#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    if (num_list.size() >= 11) {
        int sum = 0;
        for (int x : num_list) {
            sum += x;
        }
        return sum;
    } else {
        int mul = 1;
        for (int x : num_list) {
            mul *= x;
        }
        return mul;
    }
}
