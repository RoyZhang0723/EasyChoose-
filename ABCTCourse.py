import requests
from bs4 import BeautifulSoup
import csv
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
    url = 'https://www.polyu.edu.hk/abct/intranet/en/teaching/subject_description_forms/index.html'
    html = requent_course_web(url)
    soup = BeautifulSoup(html, 'lxml')
    save_to_csv(soup)

def save_to_csv(soup):
    # list = soup.find('body').find(id='sizecontrol').find(id='wrap_outer').find(id='wrapper').find(id='middle_zone')\
    #     .find(id='content_wrap').find(id='right_cnt').find(id='content').find(class_='color_table').find('tbody').find_all('tr')
    list = soup.find('body').find('tbody').find_all('tr')
    del list[0]
    id = 1
    with open('abctC.csv', mode='w',encoding='utf-8-sig') as csv_file:
        filenames = ['ID', 'subject code', 'subject name']
        writer = csv.DictWriter(csv_file, fieldnames=filenames)
        writer.writeheader()
        for item in list:
            subject_code = u'' + item.find_all('td')[0].text
            suject_name = u'' + item.find_all('td')[1].text
            writer.writerow({'ID': id, 'subject code': subject_code, 'subject name': suject_name})
            id = id + 1

if __name__ == '__main__':
    main()