import sys

input = sys.stdin.readline

a1 = int(input())
a2 = int(input())
a3 = int(input())

if a1 + a2 + a3 == 180:
    if a1 == 60 and a2 == 60 and a3 == 60:
        print("Equilateral")
    elif a1 == a2 or a2 == a3 or a3 == a1:
        print("Isosceles")
    else:
        print("Scalene")
else:
    print("Error")
