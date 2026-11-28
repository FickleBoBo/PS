import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    y_sum, k_sum = 0, 0
    for _ in range(9):
        y, k = map(int, input().split())
        y_sum += y
        k_sum += k

    if y_sum > k_sum:
        print("Yonsei")
    elif y_sum < k_sum:
        print("Korea")
    else:
        print("Draw")
