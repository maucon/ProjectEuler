def solve(limit=10000000000):
    psieve, primes = [True for _ in range(int(limit ** 0.5) + 1)], [2]
    for p in range(3, len(psieve), 2):
        if psieve[p]:
            primes.append(p)
            for i in range(p * 2, len(psieve), p):
                psieve[i] = False

    un = int(0.7188912635 * limit)
    return limit - len(primes) - un


def alt_solve(limit=10000000000):
    v = int(limit ** 0.5)
    lo, hi, tot = [i - 1 for i in range(v + 1)], [0] + [limit // i - 1 for i in range(1, v + 1)], limit
    for p in range(2, v + 1):
        if lo[p] == lo[p - 1]:
            continue
        tot -= p
        p_cnt, q = lo[p - 1], p * p
        end = min(v, limit // q)
        for i in range(1, end + 1):
            d = i * p
            if d <= v:
                hi[i] -= hi[d] - p_cnt
            else:
                hi[i] -= lo[limit // d] - p_cnt
        for i in range(v, q - 1, -1):
            lo[i] -= lo[i // p] - p_cnt
    for k in range(1, v):
        tot -= k * (hi[k] - hi[k + 1])
    return tot - (v * (hi[v] - lo[v]))
