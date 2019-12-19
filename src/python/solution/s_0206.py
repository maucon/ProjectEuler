import re


def solve():
    start = int(1020304050607080900 ** 0.5)
    end = int(1929394959697989990 ** 0.5)
    pattern = re.compile(r'1.2.3.4.5.6.7.8.9.0')
    for i in range(start, end, 10):
        if pattern.match(str(i ** 2)):
            return i
