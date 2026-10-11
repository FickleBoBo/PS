def solution(a, b):
    days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    week = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    return week[(sum(days[: a - 1]) + b) % 7]
