def solve():
    def can_make(total, digs):
        if digs == total:
            return True
        if digs > total:
            t = 10
            while t < digs:
                rest = digs % t
                if rest < total and can_make(total - rest, digs // t):
                    return True
                t *= 10
        return False

    return 41332 + sum([i * i for i in range(10 ** 2 + 1, 10 ** 6 + 1) if i % 9 < 2 and can_make(i, i * i)])
