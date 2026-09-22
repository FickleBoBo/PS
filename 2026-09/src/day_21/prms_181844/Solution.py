def solution(arr, delete_list):
    seen = set(delete_list)
    return [x for x in arr if x not in seen]
