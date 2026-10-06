#include <bits/stdc++.h>
using namespace std;

const int MAX = 1'000'000;
int st[MAX];
int pos = 0;

void push(int x) {
    st[pos++] = x;
}

void pop() {
    pos--;
}

int size() {
    return pos;
}

bool empty() {
    return pos == 0;
}

int top() {
    return st[pos - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int q;
        cin >> q;

        if (q == 1) {
            int x;
            cin >> x;
            push(x);
        } else if (q == 2) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << top() << '\n';
                pop();
            }
        } else if (q == 3) {
            cout << size() << '\n';
        } else if (q == 4) {
            cout << empty() << '\n';
        } else {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << top() << '\n';
            }
        }
    }
}
