#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> num_list) {
    int odd = 0, even = 0;
    for (int x : num_list) {
        if (x % 2) {
            odd++;
        } else {
            even++;
        }
    }

    return {even, odd};
}
