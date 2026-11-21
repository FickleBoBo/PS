import sys

input = sys.stdin.readline

t = int(input())
out = [sum(map(int, input().split())) for _ in range(t)]
print("\n".join(map(str, out)))
