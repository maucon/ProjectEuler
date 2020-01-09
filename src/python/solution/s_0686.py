from itertools import count
from math import log10


# min = 0.08990511146839708 -> log2(int('123' + '0' * 1000000)) * log10(2) % 1
# max = 0.09342168527655303 -> log2(int('123' + '9' * 1000000)) * log10(2) % 1

def solve(limit=678910):
    start = [x for x in range(1, 1000) if str(2 ** x).startswith('123')][0]
    inc, log10_2 = {196, 289, 485}, log10(2)
    for _ in range(limit - 1):
        for i in inc:
            num = (start + i) * log10_2
            if 0.08990511146839707 < num % 1 < 0.09342168527655304:
                start += i
                break
    return start


# First solutions (~40s)
def solve_alt(limit=678910):
    c, log10_2 = 0, log10(2)
    for i in count(1, 1):
        num = i * log10_2
        if 0.08990511146839707 < num % 1 < 0.09342168527655304:
            c += 1
            if c == limit:
                return i
