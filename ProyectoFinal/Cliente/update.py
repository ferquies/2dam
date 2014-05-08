import urllib.request

def update():
    url = "http://localhost/proyectom/vids.txt"
    filename = "vids.txt"
    urllib.request.urlretrieve(url, filename)
    print ("Update completed")
