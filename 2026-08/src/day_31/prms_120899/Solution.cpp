#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> array) {
    int idx = max_element(array.begin(), array.end()) - array.begin();
    return {array[idx], idx};
}
