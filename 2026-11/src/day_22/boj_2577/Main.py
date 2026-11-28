import sys

input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())
s = str(a * b * c)

for d in range(10):
    print(s.count(str(d)))
