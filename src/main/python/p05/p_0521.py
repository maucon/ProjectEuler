# def solve_alt(limit=1000000000000):
#     def f(n):
#         return n * (n + 1) // 2 - 1
#
#     v = int(limit ** 0.5)
#     s_cnt = [i - 1 for i in range(v + 1)]
#     s_sum = [f(i) for i in range(v + 1)]
#     l_cnt = [limit // i - 1 if i else 0 for i in range(v + 1)]
#     l_sum = [f(limit // i) if i else 0 for i in range(v + 1)]
#     used = [0] * (v + 1)
#
#     ret = 0
#     for p in range(2, v + 1):
#         if s_cnt[p] == s_cnt[p - 1]:
#             continue
#         p_cnt = s_cnt[p - 1]
#         p_sum = s_sum[p - 1]
#         q = p * p
#         ret += p * (l_cnt[p] - p_cnt)
#         l_cnt[1] -= l_cnt[p] - p_cnt
#         l_sum[1] -= (l_sum[p] - p_sum) * p
#         interval = (p & 1) + 1
#         end = min(v, limit // q)
#         for i in range(p + interval, end + 1, interval):
#             if used[i]:
#                 continue
#             d = i * p
#             if d <= v:
#                 l_cnt[i] -= l_cnt[d] - p_cnt
#                 l_sum[i] -= (l_sum[d] - p_sum) * p
#             else:
#                 t = limit // d
#                 l_cnt[i] -= s_cnt[t] - p_cnt
#                 l_sum[i] -= (s_sum[t] - p_sum) * p
#         if q <= v:
#             for i in range(q, end, p * interval):
#                 used[i] = True
#         for i in range(v, q - 1, -1):
#             t = i // p
#             s_cnt[i] -= s_cnt[t] - p_cnt
#             s_sum[i] -= (s_sum[t] - p_sum) * p
#     return (l_sum[1] + ret)


# my try bruh
from itertools import compress


def solve(limit=10 ** 12):
    deviation = [1.0, 1.0, 0.9978955592519785, 0.9996926521579136, 0.9999107171475905, 0.9999889266687397, 0.9999998939187886, 1.0000002954573632, 1.000000245265624, 1.0000000990092017,
                 1.000000036888216, 1.0000000125720443]
    prime_sums = [17, 1060, 76127, 5736396, 454396537, 37550402023, 3203324994356, 279209790387276, 24739512092254535, 2220822432581729238, 201467077743744681014, 18435588552550705911377,
                  1699246443377779418889494, 157589260710736940541561021]

    plimit = int(limit ** 0.5) + 1
    sieve = bytearray([True] * (plimit // 2))
    for i in range(3, int(plimit ** 0.5) + 1, 2):
        if sieve[i // 2]:
            sieve[i * i // 2::i] = bytearray((plimit - i * i - 1) // (2 * i) + 1)
    primes = [2, *compress(range(3, plimit, 2), sieve[1:])]

    val = prime_sums[len(str(limit)) - 2]
    lim = limit
    for p in primes:
        m = round(lim * (1 / p))
        lim -= m
        val += (m - 1) * p

    return val

# {2: 50, 3: 33, 5: 20, 7: 14}
# 28 # 28
# 1257 # 1257
# 79189 # 79356
# 5786451 # 5788230
# 455298741 # 455339395
# 37568404989 # 37568821001
# 3203714961609 # 3203715301463
# 279218813374515 # 279218730877285
# 24739731010688477 # 24739724942884403
# 2220827932427240957 # 2220827712544861778
# 201467219561892846337 # 201467212130126801338
# 18435592284459044389811 # 18435592052685966114620
