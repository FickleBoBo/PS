import string
from collections import Counter


def solution(my_string):
    cnt = Counter(my_string)
    return [cnt[c] for c in string.ascii_uppercase + string.ascii_lowercase]
