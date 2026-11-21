import sys

input = sys.stdin.readline

for _ in range(3):
    cnt = sum(map(int, input().split()))
    if cnt == 0:
        print("D")
    elif cnt == 1:
        print("C")
    elif cnt == 2:
        print("B")
    elif cnt == 3:
        print("A")
    else:
        print("E")
