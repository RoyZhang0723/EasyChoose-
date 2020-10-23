import pandas as pd
from sqlalchemy import create_engine

df = pd.read_csv('AllCourse.csv')

# 当engine连接的时候我们就插入数据
engine = create_engine('mysql://root:Xb121314@localhost/easychoose?charset=utf8')
with engine.connect() as conn, conn.begin():
    df.to_sql('course', conn, if_exists='replace')