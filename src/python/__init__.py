from importlib import import_module
from time import time_ns as time

if __name__ == '__main__':

    # ----------------------------------------------
    problem_number = 1
    # ----------------------------------------------

    print('\033[4mProblem %s\n\033[0m' % problem_number)
    with open('../problem/description/problem_%s.txt' % ('0' * (4 - len(str(problem_number))) + str(problem_number))) as file:
        for line in file.readlines():
            print(line.replace('\n', ''))
    print()

    try:
        problem = import_module('src.python.solution.s_%s' % ('0' * (4 - len(str(problem_number))) + str(problem_number)))
    except ModuleNotFoundError:
        print('\033[91mProblem not solved yet!\033[0m')
        exit(0)

    start_time = time()
    sol = problem.solve()
    total_time = time() - start_time


    def time_format(ns):
        t = '0' * (11 - len(str(ns))) + str(ns)
        for i in [2, 6, 10]:
            t = t[:i] + ':' + t[i:]
        return t


    print('Solution:', sol)
    print('Time:    ', time_format(total_time))
    print('         [ s| ms| μs| ns]')
