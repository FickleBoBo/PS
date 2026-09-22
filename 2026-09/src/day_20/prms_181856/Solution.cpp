#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    if (arr1.size() > arr2.size()) return 1;
    if (arr1.size() < arr2.size()) return -1;

    int sum1 = 0, sum2 = 0;
    for (int x : arr1) sum1 += x;
    for (int x : arr2) sum2 += x;

    return (sum1 > sum2) - (sum1 < sum2);
}
