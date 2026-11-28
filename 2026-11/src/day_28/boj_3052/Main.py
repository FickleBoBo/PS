import sys

input = sys.stdin.readline

seen = [False] * 42
for _ in range(10):
    x = int(input())
    seen[x % 42] = True

print(seen.count(True))
