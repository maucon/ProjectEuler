def solve(limit=1000000000000):
    def f(n):
        return n * (n + 1) // 2 - 1

    v = int(limit ** 0.5)
    s_cnt = [i - 1 for i in range(v + 1)]
    s_sum = [f(i) for i in range(v + 1)]
    l_cnt = [limit // i - 1 if i else 0 for i in range(v + 1)]
    l_sum = [f(limit // i) if i else 0 for i in range(v + 1)]
    used = [0] * (v + 1)

    ret = 0
    for p in range(2, v + 1):
        if s_cnt[p] == s_cnt[p - 1]:
            continue
        p_cnt = s_cnt[p - 1]
        p_sum = s_sum[p - 1]
        q = p * p
        ret += p * (l_cnt[p] - p_cnt)
        l_cnt[1] -= l_cnt[p] - p_cnt
        l_sum[1] -= (l_sum[p] - p_sum) * p
        interval = (p & 1) + 1
        end = min(v, limit // q)
        for i in range(p + interval, end + 1, interval):
            if used[i]:
                continue
            d = i * p
            if d <= v:
                l_cnt[i] -= l_cnt[d] - p_cnt
                l_sum[i] -= (l_sum[d] - p_sum) * p
            else:
                t = limit // d
                l_cnt[i] -= s_cnt[t] - p_cnt
                l_sum[i] -= (s_sum[t] - p_sum) * p
        if q <= v:
            for i in range(q, end, p * interval):
                used[i] = True
        for i in range(v, q - 1, -1):
            t = i // p
            s_cnt[i] -= s_cnt[t] - p_cnt
            s_sum[i] -= (s_sum[t] - p_sum) * p
    return (l_sum[1] + ret) % 1000000000

# my try bruh
#
# from itertools import compress
#
#
# def solve(limit=10 ** 12):
#     plimit = int(limit ** 0.5) + 1
#     sieve = bytearray([True] * (plimit // 2))
#     for i in range(3, int(plimit ** 0.5) + 1, 2):
#         if sieve[i // 2]:
#             sieve[i * i // 2::i] = bytearray((plimit - i * i - 1) // (2 * i) + 1)
#     primes = [*compress(range(3, plimit, 2), sieve[1:])]
#
#     s = limit - 2 + 1060
#     div = 1
#     for p in primes:
#         s += (round(limit / p / 2 / div) - 1) * p
#         print((round(limit / p / 2 / div)), p)
#         div = p / 2 / div
#
#     return s
