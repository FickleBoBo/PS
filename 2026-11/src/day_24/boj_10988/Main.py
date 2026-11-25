import sys

input = sys.stdin.readline

s = input().rstrip()
print(int(s == s[::-1]))
