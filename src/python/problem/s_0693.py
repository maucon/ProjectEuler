def solve():
    def g(x):
        def l(xx, yy):
            sn = yy
            count = 1
            while yy > 1:
                yy = yy ** 2 % xx
                xx += 1
                count += 1
            return count

        m = 0
        y = 0
        for ii in range(2, x):
            lo = l(x, ii)
            if lo > m:
                m = lo
                y = ii
        return m, y

    for i in range(3, 100):
        print(g(i))
