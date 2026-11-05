#include <bits/stdc++.h>
using namespace std;

int a[5] = {1, 2, 3, 4, 5};
int b[8] = {2, 1, 2, 3, 2, 4, 2, 5};
int c[10] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
int cnt[3];

vector<int> solution(vector<int> answers) {
    for (int i = 0; i < answers.size(); i++) {
        if (answers[i] == a[i % 5]) cnt[0]++;
        if (answers[i] == b[i % 8]) cnt[1]++;
        if (answers[i] == c[i % 10]) cnt[2]++;
    }

    if (cnt[0] == cnt[1] && cnt[1] == cnt[2]) {
        return {1, 2, 3};
    } else if (cnt[0] == cnt[1] && cnt[1] > cnt[2]) {
        return {1, 2};
    } else if (cnt[0] == cnt[2] && cnt[2] > cnt[1]) {
        return {1, 3};
    } else if (cnt[1] == cnt[2] && cnt[2] > cnt[0]) {
        return {2, 3};
    } else if (cnt[0] > cnt[1] && cnt[0] > cnt[2]) {
        return {1};
    } else if (cnt[1] > cnt[0] && cnt[1] > cnt[2]) {
        return {2};
    } else {
        return {3};
    }
}
