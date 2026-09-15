#include <bits/stdc++.h>
using namespace std;

int solution(int chicken) {
    int sum = 0;
    int x = chicken;
    while (x >= 10) {
        sum += x / 10;
        x = x / 10 + x % 10;
    }

    return sum;
}
