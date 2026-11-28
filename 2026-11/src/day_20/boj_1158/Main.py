import sys
from collections import deque

input = sys.stdin.readline
out = []

n, k = map(int, input().split())

q = deque(range(1, n + 1))
while q:
    q.rotate(-(k - 1))
    out.append(q.popleft())

print("<" + ", ".join(map(str, out)) + ">")
