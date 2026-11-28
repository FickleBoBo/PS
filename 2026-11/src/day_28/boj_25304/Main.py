import sys

input = sys.stdin.readline

x = int(input())
n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    x -= a * b

print("Yes" if x == 0 else "No")
