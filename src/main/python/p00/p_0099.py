from math import log

import requests


def solve():
    lines = [li.split(',') for li in requests.get("https://projecteuler.net/project/resources/p099_base_exp.txt").text.split("\n")]
    p = m = 0
    for i, l in enumerate(lines, start=1):
        v = int(l[1]) * log(int(l[0]), 10)
        if v > m:
            m, p = v, i
    return p
