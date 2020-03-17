from itertools import combinations_with_replacement, permutations


def solve():
    count = 0
    for i in list(combinations_with_replacement('0123456789', 7))[1:]:
        n = int(''.join(i))
        while True:
            if n == 1:
                break
            elif n == 89:
                count += len(set(permutations(i, 7)))
                break
            else:
                n = sum([int(x) ** 2 for x in str(n)])
    return count
