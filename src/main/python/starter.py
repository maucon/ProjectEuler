import sys
from importlib import import_module

if __name__ == '__main__':
    problem_number = int(sys.argv[1])

    try:
        package = str(problem_number // 100)
        package = '0' * (2 - len(package)) + package

        problem_class = str(problem_number)
        problem_class = '0' * (4 - len(problem_class)) + problem_class

        problem = import_module('p%s.p_%s' % (package, problem_class))
        print("SOLUTION:" + str(problem.solve()))

    except ModuleNotFoundError:
        exit()
