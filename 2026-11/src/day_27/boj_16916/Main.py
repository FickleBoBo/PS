import sys

input = sys.stdin.readline

s = input().rstrip()
p = input().rstrip()
print(int(p in s))
