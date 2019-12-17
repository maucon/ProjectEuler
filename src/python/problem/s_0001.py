# Find the sum of all the multiples of 3 or 5 below 1000.
def solve(limit=1000):
    return sum({*range(3, limit, 3)} | {*range(5, limit, 5)})
