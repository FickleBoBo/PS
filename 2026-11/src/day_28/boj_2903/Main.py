import sys

input = sys.stdin.readline

n = int(input())
print(((1 << n) + 1) ** 2)
