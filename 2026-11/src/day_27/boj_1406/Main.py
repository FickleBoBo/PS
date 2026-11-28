import sys
from collections import deque

input = sys.stdin.readline

f = deque(input().rstrip())
b = deque()

m = int(input())
for _ in range(m):
    tokens = input().split()
    op = tokens[0]

    if op == "L":
        if f:
            b.appendleft(f.pop())
    elif op == "D":
        if b:
            f.append(b.popleft())
    elif op == "B":
        if f:
            f.pop()
    else:
        f.append(tokens[1])

print("".join(f) + "".join(b))
