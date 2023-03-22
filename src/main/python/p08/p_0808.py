ss = 100_000  # sieve size (10^x)


def solve(n=50):
    rps = []
    primes = []

    sc = int(0)  # sieve count
    while len(rps) < n:
        sieve = [True for _ in range(ss)]
        for prime in primes:
            if pow(prime, 2) >= (sc + 1) * ss:
                break

            start = prime * (int(ss * sc / prime) + 1)
            if start >= (sc + 1) * ss:
                continue
            sieve[start % ss:ss: prime] = [False] * len(sieve[start % ss:ss: prime])

        for p in range(3 if sc == 0 else 1, ss, 2):
            if not sieve[p]:
                continue

            if sc == 0:
                sieve[p:ss:p] = [False] * len(sieve[p:ss:p])

            prime = p + ss * sc
            primes.append(prime)

            p_squared = pow(prime, 2)
            reverse = int(str(p_squared)[::-1])
            revers_root = reverse ** .5
            if reverse == p_squared or revers_root % 1 != 0:
                continue

            is_prime = True
            if revers_root not in primes:
                for pr in primes:
                    if pr > revers_root:
                        break
                    if reverse % pr != 0:
                        continue
                    is_prime = False
                    break
            if is_prime:
                rps.append(p_squared)
                if int(len(rps)) == n:
                    return sum(rps)

        sc += 1

    return sum(rps)


def is_palindrome(number):
    n = str(number)
    return n == n[::-1]
