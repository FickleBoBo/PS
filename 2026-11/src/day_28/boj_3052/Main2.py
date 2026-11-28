import sys

input = sys.stdin.readline

seen = set()
for _ in range(10):
    x = int(input())
    seen.add(x % 42)

print(len(seen))
