import sys

input = sys.stdin.readline

input()
arr = list(map(int, input().split()))
y_sum = sum(x // 30 + 1 for x in arr) * 10
m_sum = sum(x // 60 + 1 for x in arr) * 15

if y_sum < m_sum:
    print("Y", y_sum)
elif y_sum > m_sum:
    print("M", m_sum)
else:
    print("Y M", y_sum)
