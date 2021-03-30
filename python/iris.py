import numpy as np 
import pandas as pd 
from pandas import plotting

import matplotlib.pyplot as plt 

plt.style.use('seaborn')

import seaborn as sns

sns.set_style('whitegrid')

from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.neighbors import KNeighborsClassifier
from sklearn import svm
from sklearn import metrics
from sklearn.tree import DecisionTreeClassifier


iris = pd.read_csv('/home/tian/vscode/资料/iris.csv',usecols=[1,2,3,4,5,6])
iris.info()
iris.head()
iris.describe()


encoder = LabelEncoder()
y = encoder.fit_transform(y)

train_x,test_x,train_y,test_y = train_test_split(x,y,test_size=0.3,random_state=1)
model = svm.SVC()
#model = KNeighborsClassifier()
#model = DecisionTreeClassifier()
#model = LogisticRegression()

model.fit(train_x, train_y)

prediction = model.predict(test_x)

print("The acc of the regression is %s", metrics.accuracy_score((prediction,test_y)))






