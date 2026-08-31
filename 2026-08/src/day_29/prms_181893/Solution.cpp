#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    for (int i = 0; i < query.size(); i++) {
        if (i % 2) {
            arr = vector<int>(arr.begin() + query[i], arr.end());
        } else {
            arr = vector<int>(arr.begin(), arr.begin() + query[i] + 1);
        }
    }

    return arr;
}
