#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> v;
    for (int i = 0; i < num_list.size(); i += n) {
        v.push_back(num_list[i]);
    }

    return v;
}
