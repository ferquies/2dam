import os
import datetime
import urllib.request
from update import *

def actualizar(d, vids, url):
    if(not os.path.isdir(d)):
        os.mkdir(d)

    update()

    f = open(vids)
    files = []
    factuales = os.listdir(d)
    log = open("registro.log", "a")

    for linea in f:
        files.append(linea[0:len(linea)-1])

    f.close()

    for l in files:
        if(l not in factuales):
            name = l
            l = l.replace(" ", "%20")
            urllib.request.urlretrieve(url+l, d+name)
            log.write(str(datetime.datetime.now()) + " - Downloaded " + d+l + "\n")
            

    for l in factuales:
        if(l not in files):
            os.remove(d+l)
            log.write(str(datetime.datetime.now()) + " - Deleted " + d+l + "\n")
    
    log.close()

d = "./Videos/"
vids = "vids.txt"
url = "http://localhost/proyectom/Videos/"

actualizar(d, vids, url)

d2 = "./Videos_alt/"
vids2 = "vids_alt.txt"
url2 = "http://localhost/proyectom/Videos_alt/"

actualizar(d2, vids2, url2)