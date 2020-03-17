import os
import re

import requests


def solve():
    rows = requests.get("https://projecteuler.net/project/resources/p089_roman.txt").text
    return len(rows) - len(re.sub("DCCCC|LXXXX|VIIII|CCCC|XXXX|IIII", '12', rows))
