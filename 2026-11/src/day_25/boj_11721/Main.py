import sys

input = sys.stdin.readline

s = input().rstrip()
print("\n".join(s[i : i + 10] for i in range(0, len(s), 10)))
