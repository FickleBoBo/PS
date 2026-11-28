#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1'000'000;
int st[MAX_N];
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
        int op;
        cin >> op;

        if (op == 1) {
            int x;
            cin >> x;
            push(x);
        } else if (op == 2) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << top() << '\n';
                pop();
            }
        } else if (op == 3) {
            cout << size() << '\n';
        } else if (op == 4) {
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
