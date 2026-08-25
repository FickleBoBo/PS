#include <bits/stdc++.h>
using namespace std;

int solution(int balls, int share) {
    long long ans = 1;
    for (int i = 1; i <= share; i++) {
        ans = ans * (balls - i + 1) / i;
    }

    return (int)ans;
}
