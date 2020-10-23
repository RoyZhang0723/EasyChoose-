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
    url = 'https://www.polyu.edu.hk/ama/listing_of_subjects/'
    html = requent_course_web(url)
    soup = BeautifulSoup(html, 'lxml')
    save_to_csv(soup)

def save_to_csv(soup):
    list = soup.find(class_='en_us').find(id='wrapper').find(id='container').find(class_='clearfix').find(class_='content left')\
        .find(class_='pagecontent clearfix').find(class_='leftcontainer left no-right').find(class_='inner-container').find(class_='undergraduate-pro-box')\
        .find(class_='listing-table').find('tbody').find_all('tr')
    del list[0]
    id = 1
    with open('amaC.csv', mode='w') as csv_file:
        filenames = ['ID', 'subject code', 'subject name']
        writer = csv.DictWriter(csv_file, fieldnames=filenames)
        writer.writeheader()
        for item in list:
            subject_code = item.find_all('td')[0].find('a').text
            suject_name = item.find_all('td')[1].text
            writer.writerow({'ID': id, 'subject code': subject_code, 'subject name': suject_name})
            id = id + 1

if __name__ == '__main__':
    main()