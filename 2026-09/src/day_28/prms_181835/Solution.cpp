#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, int k) {
    if (k % 2) {
        for (int& x : arr) x *= k;
    } else {
        for (int& x : arr) x += k;
    }

    return arr;
}
