from math import gcd


def solve():
    val = 1
    for i in [2, 3, 5, 7, 11, 13, 17, 19, 23]:
        val *= i
    return val * 4


def solve_alt(sol=15499 / 94744):
    i = 2
    step = 6
    last_i = 0
    current_low = 1
    while True:
        amount = 0
        for k in range(1, i + 1):
            if gcd(i, k) == 1:
                amount += 1

        x = amount / (i - 1)
        if x < current_low:
            current_low = x
            step = i - last_i
            print(i, '\t', step, '\t', x)

            if x < sol:
                return i
            last_i = i
        i += step
