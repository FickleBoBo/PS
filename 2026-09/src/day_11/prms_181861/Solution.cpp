#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> v;
    for (int x : arr) {
        for (int i = 0; i < x; i++) {
            v.push_back(x);
        }
    }

    return v;
}
