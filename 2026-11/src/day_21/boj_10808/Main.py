import string
import sys

input = sys.stdin.readline

s = input().rstrip()
print(*[s.count(c) for c in string.ascii_lowercase])
