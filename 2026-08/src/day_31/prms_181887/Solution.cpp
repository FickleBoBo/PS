#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    int odd = 0, even = 0;
    for (int i = 0; i < num_list.size(); i++) {
        if (i % 2) {
            odd += num_list[i];
        } else {
            even += num_list[i];
        }
    }

    return max(odd, even);
}
