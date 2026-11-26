import sys

input = sys.stdin.readline

MAX_N = 2_000_000


class Queue:
    def __init__(self):
        self.q = [0] * MAX_N
        self.s = 0
        self.e = 0

    def push(self, x):
        self.q[self.e] = x
        self.e += 1

    def pop(self):
        self.s += 1
        return self.q[self.s - 1]

    def size(self):
        return self.e - self.s

    def empty(self):
        return self.s == self.e

    def front(self):
        return self.q[self.s]

    def back(self):
        return self.q[self.e - 1]


queue = Queue()
out = []

n = int(input())
for _ in range(n):
    q = input().split()

    if q[0] == "push":
        queue.push(int(q[1]))
    elif q[0] == "pop":
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.pop())
    elif q[0] == "size":
        out.append(queue.size())
    elif q[0] == "empty":
        if queue.empty():
            out.append(1)
        else:
            out.append(0)
    elif q[0] == "front":
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.front())
    else:
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.back())

print("\n".join(map(str, out)))
