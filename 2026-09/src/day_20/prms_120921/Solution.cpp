#include <bits/stdc++.h>
using namespace std;

int solution(string A, string B) {
    for (int i = 0; i < A.size(); i++) {
        if (A == B) return i;
        rotate(A.begin(), A.end() - 1, A.end());
    }

    return -1;
}
