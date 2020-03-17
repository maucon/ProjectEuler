from importlib import import_module
from time import time_ns as time

import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':

    # ----------------------------------------------
    problem_number = 1
    # ----------------------------------------------

    # TODO: add MathJax parsing
    print('\033[4mProblem %s\n\033[0m' % problem_number)
    try:
        print("\n".join([s.strip() for s in
                         BeautifulSoup(requests.get("https://projecteuler.net/problem=" + str(problem_number)).content, "html.parser").find_all("div", {"class": "problem_content"})[0].get_text()
                        .replace("\n", " ").replace(". ", ".\n").split("\n")]))
    except IndexError:
        print('\033[91mNo problem description found!\033[0m')

    try:
        package = str(problem_number // 100)
        problem = import_module('python.p%s.p_%s' % ('0' * (2 - len(package)) + package, '0' * (4 - len(str(problem_number))) + str(problem_number)))

        start_time = time()
        sol = problem.solve()
        total_time = time() - start_time

        t = '0' * (11 - len(str(total_time))) + str(total_time)
        for i in [-9, -6, -3]:
            t = t[:i] + ':' + t[i:]

        print('Solution:', sol)
        print('Time:    ', t)
        print('         [ s| ms| μs| ns]')

    except ModuleNotFoundError:
        print('\033[91mProblem not solved yet!\033[0m')
