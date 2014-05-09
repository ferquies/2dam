import urllib.request

def update():
    url = "http://localhost/proyectom/vids.txt"
    filename = "vids.txt"
    urllib.request.urlretrieve(url, filename)
    url = "http://localhost/proyectom/vids_alt.txt"
    filename = "vids_alt.txt"
    urllib.request.urlretrieve(url, filename)
