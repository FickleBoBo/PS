import sys

input = sys.stdin.readline

n = int(input())

pivot = 1
for i in range(1, 2 * n):
    print("*" * pivot)
    if i < n:
        pivot += 1
    else:
        pivot -= 1
