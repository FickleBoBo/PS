import sys

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    a, b = input().split()
    print("Possible" if sorted(a) == sorted(b) else "Impossible")
