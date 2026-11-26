import sys

input = sys.stdin.readline

s = input().rstrip()
print(sum(c in "aeiou" for c in s))
