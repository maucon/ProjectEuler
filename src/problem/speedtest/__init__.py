from datetime import date
from importlib import import_module
from time import time_ns as time

import xlsxwriter

if __name__ == '__main__':

    def test(n):
        try:
            # src.python.solution before
            problem = import_module('src.python.solution.s_%s' % ('0' * (4 - len(str(n))) + str(n)))
            sol = problem.solve()

            # ----------------------------------------------
            test_count = 5
            # ----------------------------------------------

            total_time = 0
            for _ in range(test_count):
                start_time = time()
                problem.solve()
                total_time += time() - start_time
            total_time //= test_count

            def time_format(ns):
                t = '0' * (11 - len(str(ns))) + str(ns)
                for i in [-9, -6, -3]:
                    t = t[:i] + ':' + t[i:]
                return t

            return time_format(total_time), sol

        except ModuleNotFoundError:
            return '/', '/'


    workbook = xlsxwriter.Workbook('speedtests.xlsx')
    worksheet = workbook.add_worksheet(str(date.today()))
    # bold = workbook.add_format({'bold': True})
    worksheet.set_column('A:A', 20)
    worksheet.set_column('B:A', 20)

    for problem_number in range(0, 697):
        print(problem_number + 1)
        results = test(problem_number + 1)
        worksheet.write(problem_number, 0, results[0])
        worksheet.write(problem_number, 1, str(results[1]))

    workbook.close()
