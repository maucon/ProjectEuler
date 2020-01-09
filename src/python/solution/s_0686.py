from itertools import count
from math import log10


def solve(limit=678910):
    # min = 0.08990511146839708
    # max = 0.09342168527655303
    c = 0
    log10_2 = log10(2)
    for i in count(1, 1):
        num = i * log10_2
        if 0.08990511146839707 < (num - int(num)) < 0.09342168527655304:
            c += 1
            if c == limit:
                return i
