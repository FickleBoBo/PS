def is_parallel(p1, p2, p3, p4):
    return (p1[0] - p2[0]) * (p3[1] - p4[1]) == (p3[0] - p4[0]) * (p1[1] - p2[1])


def solution(dots):
    p1, p2, p3, p4 = dots
    return int(is_parallel(p1, p2, p3, p4) or is_parallel(p1, p3, p2, p4) or is_parallel(p1, p4, p2, p3))
