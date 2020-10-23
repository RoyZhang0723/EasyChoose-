import requests
from bs4 import BeautifulSoup
import csv
import string
headers = {
    'Usser-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36'
}

def requent_course_web(url):
    try:
        response = requests.get(url,headers=headers)
        if response.status_code == 200:
            return response.text
    except requests.RequestException:
        return None

def main():
    url = 'https://www.comp.polyu.edu.hk/en-us/study/undergraduate-programmes/subject'
    html = requent_course_web(url)
    soup = BeautifulSoup(html, 'lxml')
    save_to_csv(soup)

def get_code(str):
    l = str.split(' ', 1 )[0]
    return l

def get_name(str):
    l = str.split(' ', 1 )[1]
    return l

def save_to_csv(soup):
    list = soup.find(class_='en_us').find(id='wrapper-container').find(id='container').find(class_="right-part")\
        .find(class_='right-part-inner clearfix').find_all('ul')
    id = 1
    with open('compC.csv', mode='w') as csv_file:
        filenames = ['ID', 'subject code', 'subject name']
        writer = csv.DictWriter(csv_file, fieldnames=filenames)
        writer.writeheader()
        ulNumber = 1
        for items in list:
            if ulNumber % 2 == 0:
                item = items.find_all('li')
                for i in item:
                    subject_code = get_code(i.find('a').text)
                    subject_name = get_name(i.find('a').text)
                    writer.writerow({'ID': id, 'subject code': subject_code, 'subject name': subject_name})
                    id = id + 1
            else:
                item = items.find('ul').find_all('li')
                for i in item:
                    subject_code = get_code(i.find('a').text)
                    subject_name = get_name(i.find('a').text)
                    writer.writerow({'ID': id, 'subject code': subject_code, 'subject name': subject_name})
                    id = id + 1
            ulNumber = ulNumber + 1

if __name__ == '__main__':
    main()