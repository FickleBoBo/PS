import string
import sys

input = sys.stdin.readline

s = input().rstrip().upper()
cnt = [s.count(c) for c in string.ascii_uppercase]
mx = max(cnt)

print(string.ascii_uppercase[cnt.index(mx)] if cnt.count(mx) == 1 else "?")
