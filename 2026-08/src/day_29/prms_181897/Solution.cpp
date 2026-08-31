#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, vector<int> slicer, vector<int> num_list) {
    int a = slicer[0], b = slicer[1], c = slicer[2];

    if (n == 1) return vector<int>(num_list.begin(), num_list.begin() + b + 1);
    if (n == 2) return vector<int>(num_list.begin() + a, num_list.end());
    if (n == 3) return vector<int>(num_list.begin() + a, num_list.begin() + b + 1);

    vector<int> v;
    for (int i = a; i <= b; i += c) {
        v.push_back(num_list[i]);
    }

    return v;
}
