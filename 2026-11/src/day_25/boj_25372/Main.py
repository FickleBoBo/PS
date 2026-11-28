import sys

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    s = input().rstrip()
    print("yes" if 6 <= len(s) <= 9 else "no")
