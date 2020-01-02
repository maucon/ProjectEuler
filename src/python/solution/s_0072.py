def solve(limit=1000000):
    phi = list(range(limit + 1))
    for n in range(2, limit + 1):
        if phi[n] == n:
            for k in range(n, limit + 1, n):
                phi[k] -= phi[k] // n
    return sum(phi) - 1
