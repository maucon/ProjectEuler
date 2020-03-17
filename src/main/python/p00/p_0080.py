from decimal import Decimal, getcontext


def solve():
    s, getcontext().prec = 0, 102
    for i in [x for x in range(2, 100) if x not in [4, 9, 16, 25, 36, 49, 64, 81]]:
        for c in str(Decimal(i).sqrt()).replace(".", "")[:100]:
            s += int(c)
    return s
