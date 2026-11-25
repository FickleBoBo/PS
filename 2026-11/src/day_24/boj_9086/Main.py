import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    s = input().rstrip()
    print(s[0] + s[-1])
