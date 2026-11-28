import sys

input = sys.stdin.readline

n = int(input())

pivot = n
for i in range(1, 2 * n):
    print(" " * (pivot - 1) + "*" * (n - pivot + 1))
    if i < n:
        pivot -= 1
    else:
        pivot += 1
