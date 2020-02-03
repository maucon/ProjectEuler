def solve():
    m = s = 1504170715041707
    n = 4503599627370517
    while m > 1:
        n, m = m, m - n % m
        s += m
    return s


def solve_alt():
    min_num = max_num = s = 1504170715041707
    while min_num > 1:
        new = (min_num + max_num) % 4503599627370517
        if new < min_num:
            min_num = new
            s += min_num
        else:
            max_num = new
    return s
