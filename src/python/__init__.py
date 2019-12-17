from time import time_ns as time

from src.python.solution.s_0004 import solve

if __name__ == '__main__':
    start_time = time()
    sol = solve()
    total_time = time() - start_time


    def time_format(ns):
        t = '0' * (11 - len(str(ns))) + str(ns)
        for i in [2, 6, 10]:
            t = t[:i] + ':' + t[i:]
        return t


    print('Solution:', sol)
    print('Time:    ', time_format(total_time))
    print('         [ s| ms| μs| ns]')
