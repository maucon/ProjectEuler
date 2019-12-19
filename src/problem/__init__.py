import os.path

import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':
    p = 1
    while True:
        try:
            soup = BeautifulSoup(requests.get('https://projecteuler.net/problem=%u' % p).content, 'html.parser')

            raw_number = str(soup.find('div', {'id': 'problem_info'}).get_text())
            number = raw_number.lower().replace(' ', '_')
            while len(number) < 12:
                number = number[:8] + '0' + number[8:]

            path = 'description/%s.txt' % number
            print(p)
            p += 1
            if os.path.exists(path):
                continue

            raw_text = str(soup.find('div', {'class': 'problem_content'}).get_text())
            text = raw_text.replace('$', ' ')[1:-1].encode('ascii', 'ignore')

            with open('description/%s.txt' % number, 'wb+') as file:
                file.write(text)

        except AttributeError:
            break
