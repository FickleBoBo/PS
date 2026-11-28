import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    f = deque()
    b = deque()

    s = input().rstrip()
    for c in s:
        if c == "-":
            if f:
                f.pop()
        elif c == "<":
            if f:
                b.appendleft(f.pop())
        elif c == ">":
            if b:
                f.append(b.popleft())
        else:
            f.append(c)

    print("".join(f) + "".join(b))
