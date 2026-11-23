import sys

input = sys.stdin.readline

t = int(input())

out = []
for _ in range(t):
    x, y = map(int, input().split())
    out.append(x + y)

print("\n".join(map(str, out)))
