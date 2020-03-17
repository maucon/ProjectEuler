def solve():
    start = int(1020304050607080900 ** 0.5)
    end = int(1929394959697989990 ** 0.5)
    for i in range(start, end, 10):
        ii = str(i * i)
        if ii[2] == '2' and ii[4] == '3' and ii[6] == '4' and ii[8] == '5' \
                and ii[10] == '6' and ii[12] == '7' and ii[14] == '8' and ii[16] == '9':
            return i
