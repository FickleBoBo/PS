import sys

input = sys.stdin.readline

sys.set_int_max_str_digits(0)

a, b = map(int, input().split())
print(a + b)
