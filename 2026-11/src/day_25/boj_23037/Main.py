import sys

input = sys.stdin.readline

print(sum(int(c) ** 5 for c in input().rstrip()))
