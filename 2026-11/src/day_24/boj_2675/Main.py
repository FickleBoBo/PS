import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    r, s = input().split()
    print("".join(c * int(r) for c in s))
