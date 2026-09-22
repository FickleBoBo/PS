#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    for (int x : delete_list) erase(arr, x);
    return arr;
}
