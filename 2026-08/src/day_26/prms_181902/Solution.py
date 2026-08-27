import string
from collections import Counter


def solution(my_string):
    counter = Counter(my_string)
    return [counter[c] for c in string.ascii_uppercase + string.ascii_lowercase]
