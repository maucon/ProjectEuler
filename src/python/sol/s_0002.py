# Find the sum of all even-values Fibonacci numbers whose values not exceed four million.
def solve(limit=4000000):
    a, b, s = 1, 2, 0
    while a < limit:
        if a % 2 == 0:
            s += a
        a, b = b, a + b
    return s
