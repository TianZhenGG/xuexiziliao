import re
import random
import json
import pandas as pd
from faker import Faker
from faker.providers import BaseProvider

df = pd.read_csv("test_system.csv",sep="\t")
df = df.fillna(0)

count = {}

for name in df.columns.values:
    count[name] = list(set(df[name]))

result = []

for i in range(0,50000):
    list = []
    for key,value in count.items():
        index = random.randint(0,int(len(value))-1)
        list.append(value[index])
    result.append(list)
test_data = pd.DataFrame(columns=df.columns.values,data=result)
test_data.to_csv("test_data.csv",index=False)






 
