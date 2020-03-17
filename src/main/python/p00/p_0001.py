def solve(limit=1000):
    return sum({*range(3, limit, 3)} | {*range(5, limit, 5)})
