import sys

input = sys.stdin.readline

MAX_N = 10000


class Stack:
    def __init__(self):
        self.st = [0] * MAX_N
        self.pos = 0

    def push(self, x):
        self.st[self.pos] = x
        self.pos += 1

    def pop(self):
        self.pos -= 1
        return self.st[self.pos]

    def size(self):
        return self.pos

    def empty(self):
        return self.pos == 0

    def top(self):
        return self.st[self.pos - 1]


stack = Stack()
out = []

n = int(input())
for _ in range(n):
    q = input().split()

    if q[0] == "push":
        stack.push(int(q[1]))
    elif q[0] == "pop":
        if stack.empty():
            out.append(-1)
        else:
            out.append(stack.pop())
    elif q[0] == "size":
        out.append(stack.size())
    elif q[0] == "empty":
        if stack.empty():
            out.append(1)
        else:
            out.append(0)
    else:
        if stack.empty():
            out.append(-1)
        else:
            out.append(stack.top())

print("\n".join(map(str, out)))
