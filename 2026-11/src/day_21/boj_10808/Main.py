import string
import sys

input = sys.stdin.readline

s = input().strip()
print(*[s.count(c) for c in string.ascii_lowercase])
