#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> num_list) {
    sort(num_list.begin(), num_list.end());
    return vector<int>(num_list.begin(), num_list.begin() + 5);
}
