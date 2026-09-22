#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, int n) {
    for (int i = 0; i < arr.size(); i++) {
        if (arr.size() % 2 != i % 2) arr[i] += n;
    }

    return arr;
}
