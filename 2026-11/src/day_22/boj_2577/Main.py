import sys

input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())
s = str(a * b * c)

print("\n".join(str(s.count(str(d))) for d in range(10)))
