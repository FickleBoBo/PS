#include <bits/stdc++.h>
using namespace std;

int solution(int price) {
    if (price >= 500'000) return price * 80 / 100;
    if (price >= 300'000) return price * 90 / 100;
    if (price >= 100'000) return price * 95 / 100;
    return price;
}
