import operator as op
from functools import reduce


def solve():
    def ncr(n, r):
        r = min(r, n - r)
        num = reduce(op.mul, range(n, n - r, -1), 1)
        den = reduce(op.mul, range(1, r + 1), 1)
        return num / den

    return str(7 * (1 - ncr(60, 20) / ncr(70, 20)))[:11]
