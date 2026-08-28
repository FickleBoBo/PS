def solution(s):
    lst = s.split()
    total = 0

    for i in range(len(lst)):
        if lst[i] == "Z":
            total -= int(lst[i - 1])
        else:
            total += int(lst[i])

    return total
