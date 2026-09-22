def solution(arr1, arr2):
    a = (len(arr1), sum(arr1))
    b = (len(arr2), sum(arr2))

    return (a > b) - (a < b)
