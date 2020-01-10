import os
from math import log


def solve():
    with open(os.path.dirname(os.path.abspath(__file__)) + '/res/p_0099.txt') as file:
        lines = [li[:-1].split(',') for li in file.readlines()]
        p = m = 0
        for i, l in enumerate(lines, start=1):
            v = int(l[1]) * log(int(l[0]), 10)
            if v > m:
                m, p = v, i
        return p
