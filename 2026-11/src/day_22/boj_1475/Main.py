import sys

input = sys.stdin.readline

s = input().rstrip()
cnt = [0] * 10
for c in s:
    cnt[int(c)] += 1
cnt[6] = (cnt[6] + cnt[9] + 1) // 2

print(max(cnt[:9]))
