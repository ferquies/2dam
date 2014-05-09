import os
import urllib.request
from update import *

d = "./Videos/"
vids = "vids.txt"
url = "http://localhost/proyectom/Videos/"

if(not os.path.isdir(d)):
    os.mkdir(d)

update()

f = open(vids)
files = []
factuales = os.listdir(d)

for linea in f:
    files.append(linea[0:len(linea)-1])

f.close()

for l in files:
    if(l not in factuales):
        urllib.request.urlretrieve(url+l, d+l)

for l in factuales:
    if(l not in files):
        os.remove(d+l)