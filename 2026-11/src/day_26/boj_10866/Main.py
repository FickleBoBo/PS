import sys

input = sys.stdin.readline

MAX_N = 10000


class Deque:
    def __init__(self):
        self.dq = [0] * (MAX_N * 2)
        self.s = MAX_N
        self.e = MAX_N

    def push_front(self, x):
        self.s -= 1
        self.dq[self.s] = x

    def push_back(self, x):
        self.dq[self.e] = x
        self.e += 1

    def pop_front(self):
        self.s += 1
        return self.dq[self.s - 1]

    def pop_back(self):
        self.e -= 1
        return self.dq[self.e]

    def size(self):
        return self.e - self.s

    def empty(self):
        return self.s == self.e

    def front(self):
        return self.dq[self.s]

    def back(self):
        return self.dq[self.e - 1]


deque = Deque()
out = []

n = int(input())
for _ in range(n):
    q = input().split()

    if q[0] == "push_front":
        deque.push_front(int(q[1]))
    elif q[0] == "push_back":
        deque.push_back(int(q[1]))
    elif q[0] == "pop_front":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.pop_front())
    elif q[0] == "pop_back":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.pop_back())
    elif q[0] == "size":
        out.append(deque.size())
    elif q[0] == "empty":
        if deque.empty():
            out.append(1)
        else:
            out.append(0)
    elif q[0] == "front":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.front())
    else:
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.back())

print("\n".join(map(str, out)))
