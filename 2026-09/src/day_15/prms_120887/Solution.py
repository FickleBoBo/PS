def solution(i, j, k):
    return sum(str(x).count(str(k)) for x in range(i, j + 1))
