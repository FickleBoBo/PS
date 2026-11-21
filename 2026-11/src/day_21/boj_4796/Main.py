import sys

input = sys.stdin.readline

tc = 1
while True:
    l, p, v = map(int, input().split())
    if l == 0:
        break
    print(f"Case {tc}: {v // p * l + min(v % p, l)}")
    tc += 1
