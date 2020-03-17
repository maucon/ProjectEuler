import os
import re


def solve():
    with open(os.path.dirname(os.path.abspath(__file__)) + '/res/p_0089.txt') as file:
        rows = file.read()
        return len(rows) - len(re.sub("DCCCC|LXXXX|VIIII|CCCC|XXXX|IIII", '12', rows))
