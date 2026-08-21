#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> numbers) {
    for (int& x : numbers) {
        x *= 2;
    }

    return numbers;
}
