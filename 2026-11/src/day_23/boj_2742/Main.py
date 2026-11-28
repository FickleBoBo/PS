import sys

input = sys.stdin.readline

n = int(input())
print("\n".join(map(str, range(n, 0, -1))))
