from itertools import compress


def solve():
    plimit = 7376508
    sieve = bytearray([True] * (plimit // 2))
    for i in range(3, int(plimit ** 0.5) + 1, 2):
        if sieve[i // 2]:
            sieve[i * i // 2::i] = bytearray((plimit - i * i - 1) // (2 * i) + 1)
    primes = [2, *compress(range(3, plimit, 2), sieve[1:])]

    lim = plimit
    for i in [2, 4, 8, 16]:
        lim **= 0.5
        for p in primes:
            if p > lim:
                break
            primes.append(p ** i)

    primes.sort()

    s = 1
    for p in primes[:500500]:
        s = s * p % 500500507
    return s
